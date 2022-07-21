package cn.com.yusys.yusp.uimp.distribution.service;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yusp.uimp.base.service.UserInfoService;
import cn.com.yusys.yusp.uimp.distribution.constants.DistributionConstants;
import cn.com.yusys.yusp.uimp.distribution.domain.PmaFComDepAcctInfo;
import cn.com.yusys.yusp.uimp.distribution.domain.PmaFComDepPeriod;
import cn.com.yusys.yusp.uimp.distribution.domain.PmaFcomDepDistributeInfo;
import cn.com.yusys.yusp.uimp.distribution.repository.mapper.PmaFComDepAcctInfoMapper;
import cn.com.yusys.yusp.uimp.distribution.repository.mapper.PmaFComDepPeriodMapper;
import cn.com.yusys.yusp.uimp.distribution.repository.mapper.PmaFcomDepDistributeMapper;
import com.ecc.echain.util.UNIDProducer;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author:Mr.raop
 * @create:2022-05-11
 */
@Service
public class PmaFComDepPeriodService  extends CommonService {

    protected final Log logger = LogFactory.getLog(PmaFComDepPeriodService.class);

    @Autowired
    private PmaFComDepPeriodMapper pmaFComDepPeriodMapper;

    @Autowired
    private PmaFcomDepDistributeMapper pmaFcomDepDistributeMapper;

    @Autowired
    private PmaFComDepAcctInfoMapper pmaFComDepAcctInfoMapper;

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private PmaMidInfoService pmaMidInfoService;
    private int index;

    @Transactional(readOnly = true)
    public List<Map<String, Object>> queryList(QueryModel model) {
        PageHelper.startPage(model.getPage(), model.getSize());

        List<Map<String, Object>> list = pmaFComDepPeriodMapper.queryList(model);

        logger.info("查询存款业绩分配集合[{model}]成功:"+model.toString());
        PageHelper.clearPage();
        return list;
    }

    @Override
    protected CommonMapper getMapper() {
        return pmaFComDepPeriodMapper;
    }

    @Transactional(readOnly = true)
    public ResultDto<PmaFComDepPeriod> savePmaPeriod(PmaFComDepPeriod pmaperiod) {
        ResultDto<PmaFComDepPeriod> result = new ResultDto<>();
        pmaFComDepPeriodMapper.insertSelective(pmaperiod);
        result.setMessage("新增存款业绩分配区间成功");
        result.setData(pmaperiod);
        result.setCode(0);
        return result;
    }

    @Transactional(readOnly = true)
    public void delPeriodById(String periodId) {
        pmaFComDepPeriodMapper.delPmaFComDepPeriod(periodId);
    }

    @Transactional(rollbackFor = Exception.class)
    public void savePmaDistributeList(List<UploadNode> pressList){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String curTime = sdf.format(new Date());
        String loginCode = userInfoService.getUserInfo().getLoginCode();
        String orgCode = userInfoService.getUserInfo().getOrg().getId();
        String userName = userInfoService.getUserInfo().getUserName();
        int index = 1;
        for(UploadNode node : pressList){
            String ID = node.value.get("ID");
            if(StringUtils.isBlank(ID)){
                continue;
            }
            PmaFComDepAcctInfo acctEntity = pmaFComDepAcctInfoMapper.selectByPrimaryKey(ID);
            if (acctEntity == null) {
                throw new RuntimeException("第" + index + "行，此数据不存在");
            }
            QueryModel model = new QueryModel();
            model.getCondition().put("acctInfoNo",ID);
            List<Map<String, Object>> periodList = pmaFComDepPeriodMapper.queryList(model);
            for(Map<String, Object>  period: periodList){
                if(!period.containsKey("ID") || StringUtils.isBlank((String)period.get("ID"))){
                    continue;
                }
                pmaFcomDepDistributeMapper.delDistribute((String)period.get("ID"));
            }
            pmaFComDepPeriodMapper.delPmaFComDepPeriod(ID);
            int i_index = 0;
            int lastData = 0;
            for(UploadNode childNode: node.children){
                int startDate = Integer.parseInt(String.valueOf(childNode.value.get("起始日期")).replace("-","").replace("/",""));
                int endDate = Integer.parseInt(String.valueOf(childNode.value.get("结束日期")).replace("-","").replace("/",""));
                if(startDate >= endDate){
                    throw new RuntimeException("第"+index+"行，结束日期必须大于起始日期");
                }
                if(i_index > 0){
                    if(lastData > startDate){
                        throw new RuntimeException("第"+index+"行，起始日期必须大于上一个结束日期");
                    }
                }
                lastData = endDate;
                i_index ++;
                UNIDProducer childUuid = new UNIDProducer();
                String childUuidStr= childUuid.getUNID();
                PmaFComDepPeriod period = new PmaFComDepPeriod();
                period.setId(childUuidStr);
                period.setAcctInfoNo(ID);
                period.setAcctNo(childNode.value.get("主账号"));
                period.setSubAcctNo(childNode.value.get("子账号"));
                period.setEffectDate(childNode.value.get("起始日期"));
                period.setExpirateDate(childNode.value.get("结束日期"));
                period.setOperTime(dateFormat.format(new Date()));
                period.setOperOrgId(orgCode);
                period.setOperUserId(loginCode);
                period.setOperUserName(userName);
                period.setCreator(loginCode);
                period.setCreateDate(curTime);
                period.setCreateOrg(orgCode);
                pmaFComDepPeriodMapper.insertSelective(period);
                String allocType = "";
                boolean isRate = false;
                int j_index = 0;
                double all = Double.parseDouble(String.valueOf(acctEntity.getBalance()));
                double last_amount = 0.0;
                int periodIndex = 0;
                for(UploadNode grandNode : childNode.children){
//                    if(j_index == 0){
//                        allocType = grandNode.value.get("分配类型");
//                        if(StringUtils.isNotBlank(allocType) && allocType.equals("金额")){
//                            isRate = false;
//                        }else if(StringUtils.isNotBlank(allocType) && allocType.equals("比例")){
//                            isRate = true;
//                        }else{
//                            throw new RuntimeException("第"+index+"行，无法解析的分配类型");
//                        }
//                    }else {
//                        if(StringUtils.isNotBlank(allocType) && !allocType.equals(grandNode.value.get("分配类型"))){
//                            throw new RuntimeException("第"+index+"行，分配类型有差异");
//                        }
//                    }

                    allocType = grandNode.value.get("分配类型");
                    if(DistributionConstants.ALLOC_TYPE.RATE.toString().equals(allocType)){
                        double rate = 0.0;
                        for (UploadNode fourthNode : grandNode.children) {
                            index ++;
                            UNIDProducer grandUuid = new UNIDProducer();
                            String grandUuidStr= grandUuid.getUNID();
                            PmaFcomDepDistributeInfo depDistributeInfo = new PmaFcomDepDistributeInfo();
                            depDistributeInfo.setId(grandUuidStr);
                            depDistributeInfo.setPeriodId(childUuidStr);
                            depDistributeInfo.setAllotType(grandNode.value.get("分配类型"));
                            depDistributeInfo.setStartAmt("0");
                            depDistributeInfo.setEndAmt(acctEntity.getBalance());
                            // 2022/6/14 weixy6 业绩分配的分配对象由客户经理修改为全行的职员
                            Map<String, Object> manager = pmaMidInfoService.selectUser(fourthNode.value.get("客户经理编号"));
                            if(manager == null || StringUtils.isBlank((String)manager.get("userId"))){
                                throw new RuntimeException("第"+index+"行，该职员信息不存在");
                            }
                            depDistributeInfo.setManagerId(fourthNode.value.get("客户经理编号"));
                            depDistributeInfo.setManagerName(manager.get("userName").toString());
                            if(StringUtils.isBlank(fourthNode.value.get("业绩分配比例(%)"))){
                                throw new RuntimeException("第"+index+"行，业绩分配比例(%)为空");
                            }
                            depDistributeInfo.setDistrRate(fourthNode.value.get("业绩分配比例(%)"));
                            rate += Double.parseDouble(fourthNode.value.get("业绩分配比例(%)"));
                            if(rate>100 || rate <=0){
                                throw new RuntimeException("第"+index+"行，比例错误");
                            }
                            pmaFcomDepDistributeMapper.insertSelective(depDistributeInfo);
                        }
                        if(rate != 100){
                            throw new RuntimeException("第"+index+"行，比例错误");
                        }
                    }else {
                        // 金额检验
                        int rowIndex = index + 1;
                        if(StringUtils.isBlank(grandNode.value.get("起始金额"))){
                            throw new RuntimeException("第"+ rowIndex+"行，起始金额为空");
                        }
                        if(StringUtils.isBlank(grandNode.value.get("结束金额"))){
                            throw new RuntimeException("第"+rowIndex+"行，结束金额为空");
                        }
                        double startAmount = Double.parseDouble(grandNode.value.get("起始金额"));
                        double endAmount = Double.parseDouble(grandNode.value.get("结束金额"));
                        if(endAmount < startAmount){
                            throw new RuntimeException("第"+rowIndex+"行，起始金额大于结束金额");
                        }else if(startAmount != last_amount + (periodIndex != 0 ? 1 : 0)){
                            throw new RuntimeException("第"+rowIndex+"行，起始金额不连续");
                        }
                        last_amount = endAmount;

                        double rate = 0.0;
                        for (UploadNode fourthNode : grandNode.children) {
                            index++;
                            UNIDProducer grandUuid = new UNIDProducer();
                            String grandUuidStr= grandUuid.getUNID();
                            PmaFcomDepDistributeInfo depDistributeInfo = new PmaFcomDepDistributeInfo();
                            depDistributeInfo.setId(grandUuidStr);
                            depDistributeInfo.setPeriodId(childUuidStr);
                            depDistributeInfo.setAllotType(grandNode.value.get("分配类型"));
                            Map<String, Object> manager = pmaMidInfoService.selectUser(fourthNode.value.get("客户经理编号"));
                            if(manager == null || StringUtils.isBlank((String)manager.get("userId"))){
                                throw new RuntimeException("第"+index+"行，该职员信息不存在");
                            }
                            depDistributeInfo.setManagerName(manager.get("userName").toString());
                            depDistributeInfo.setManagerId(fourthNode.value.get("客户经理编号"));
                            depDistributeInfo.setStartAmt(grandNode.value.get("起始金额"));
                            depDistributeInfo.setEndAmt(grandNode.value.get("结束金额"));
                            if (DistributionConstants.ALLOC_TYPE.BOTH.toString().equals(allocType)) {
                                rate += Double.parseDouble(fourthNode.value.get("业绩分配比例(%)"));
                                if(rate>100 || rate <=0){
                                    throw new RuntimeException("第"+index+"行，比例错误");
                                }
                                depDistributeInfo.setDistrRate(fourthNode.value.get("业绩分配比例(%)"));
                            } else {
                                depDistributeInfo.setDistrRate(String.valueOf(Double.parseDouble("100")));
                            }
                            pmaFcomDepDistributeMapper.insertSelective(depDistributeInfo);
                            j_index ++;
                        }
                        if (DistributionConstants.ALLOC_TYPE.BOTH.toString().equals(allocType)) {
                            if(rate != 100){
                                throw new RuntimeException("第"+index+"行，比例错误");
                            }
                        }
                    }
                    periodIndex++;
                }
                if(!DistributionConstants.ALLOC_TYPE.RATE.toString().equals(allocType) && last_amount != all){
                    throw new RuntimeException("第"+index+"行，汇总金额不等于贷款金额");
                }
            }
            PmaFComDepAcctInfo update = new PmaFComDepAcctInfo();
            update.setId(ID);
            update.setDstrSts("2");
            pmaFComDepAcctInfoMapper.updateByPrimaryKeySelective(update);
        }
    }
}
