package cn.com.yusys.yusp.uimp.distribution.service;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yusp.uimp.base.service.UserInfoService;
import cn.com.yusys.yusp.uimp.distribution.domain.PmaFComDepLoansInfo;
import cn.com.yusys.yusp.uimp.distribution.domain.PmaFComDepLoansPeriod;
import cn.com.yusys.yusp.uimp.distribution.domain.PmaFComDepLoansRel;
import cn.com.yusys.yusp.uimp.distribution.domain.PmaFComDepLoansRelOfPeriod;
import cn.com.yusys.yusp.uimp.distribution.repository.mapper.PmaFComDepLoansInfoMapper;
import cn.com.yusys.yusp.uimp.distribution.repository.mapper.PmaFComDepLoansPeriodMapper;
import cn.com.yusys.yusp.uimp.distribution.repository.mapper.PmaFComDepLoansRelMapper;
import cn.com.yusys.yusp.uimp.distribution.service.IPmaFComDepCommService;
import com.alibaba.fastjson.JSON;
import com.ecc.echain.util.UNIDProducer;
import com.github.pagehelper.PageHelper;
import net.sf.json.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author:Mr.raop
 * @create:2022-05-20
 */
@Component("PmaFComDepLoansInfoService")
public class PmaFComDepLoansInfoService extends CommonService implements IPmaFComDepCommService {

    protected final Log logger = LogFactory.getLog(IPmaFComDepCommService.class);

    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private PmaFComDepLoansInfoMapper pmaFComDepLoansInfoMapper;
    @Autowired
    private PmaFComDepLoansPeriodMapper pmaFComDepLoansPeriodMapper;
    @Autowired
    private PmaFComDepLoansRelMapper pmaFComDepLoansRelMapper;

    @Autowired
    private PmaMidInfoService pmaMidInfoService;

    @Override
    protected CommonMapper getMapper() {
        return pmaFComDepLoansInfoMapper;
    }

    @Override
    public List<Map<String, Object>> queryCommList(QueryModel model) {
        PageHelper.startPage(model.getPage(), model.getSize());

        model.getCondition().put("orgCode", userInfoService.getUserInfo().getOrg().getCode());
        List<Map<String, Object>> list = pmaFComDepLoansInfoMapper.queryList(model);

        logger.info("查询贷款业绩分配集合[{model}]成功:"+model.toString());
        PageHelper.clearPage();
        return list;
    }

    @Override
    public List<Map<String, Object>> queryHisList(QueryModel model) {
        PageHelper.startPage(model.getPage(), model.getSize());

        List<Map<String, Object>> list = pmaFComDepLoansInfoMapper.queryLoansHis(model);

        logger.info("查询贷款业绩分配历史集合[{model}]成功:"+model.toString());
        PageHelper.clearPage();
        return list;
    }

    @Override
    public ResultDto<Object> savezbBean(Map<String, Object> map) {
        ResultDto<Object> resultDto = new ResultDto<>();
        PmaFComDepLoansRelOfPeriod lrList = JSON.parseObject(JSON.toJSON(map).toString(), PmaFComDepLoansRelOfPeriod.class);

        String loansInfoId = lrList.getLoansInfoId();
        if(StringUtils.isEmpty(loansInfoId)){
            logger.error("获取主键id失败:"+lrList.toString());
            return resultDto;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String curTime = sdf.format(new Date());
        String loginCode = userInfoService.getUserInfo().getLoginCode();
        String orgCode = userInfoService.getUserInfo().getOrg().getId();


        List<PmaFComDepLoansPeriod> periodList = lrList.getPeriodList();
        //1.根据获取的主键id删除区间表、明细表
        this.pmaFComDepLoansRelMapper.delDistribute(loansInfoId);
        logger.info("1.1删除存款业绩分配明细集合[{pdList}]成功:"+lrList.toString());
        this.pmaFComDepLoansPeriodMapper.delPmaFComDepPeriod(loansInfoId);
        logger.info("1.2删除存款业绩分配区间集合[{pdList}]成功:"+lrList.toString());
        if(!CollectionUtils.isEmpty(periodList)){
            /*for(PmaFComDepLoansPeriod vo : periodList){
                this.pmaFComDepLoansRelMapper.delDistribute(vo.getId());
            }*/

            //区间list
            List<PmaFComDepLoansPeriod> periodLists = new ArrayList<>();
            //详情list
            List<PmaFComDepLoansRel> distributeLists = new ArrayList<>();

            //2.遍历前端区间参数重组区间list及详情list
            for(PmaFComDepLoansPeriod plist : periodList){
                String periodId = UUID.randomUUID().toString().replace("-", "");
                plist.setId(periodId);
                plist.setLoansInfoId(loansInfoId);
                plist.setOperUserId(loginCode);

                plist.setCreator(loginCode);
                plist.setCreateDate(curTime);
                plist.setCreateOrg(orgCode);
                periodLists.add(plist);

                List<PmaFComDepLoansRel> distributeList = plist.getPmaFComDepLoansRel();
                for(PmaFComDepLoansRel dlist: distributeList){
                    String distributeId = UUID.randomUUID().toString().replace("-", "");
                    dlist.setId(distributeId);
                    dlist.setPeriodId(periodId);

                    dlist.setCreator(loginCode);
                    dlist.setCreateDate(curTime);
                    dlist.setCreateOrg(orgCode);
                    distributeLists.add(dlist);
                }
            }

            //3.批量插入区间表及明细表
            pmaFComDepLoansPeriodMapper.batchInsertPeriod(periodLists);
            logger.info("2.批量插入区间表[{periodLists}]成功:"+periodLists.toString());

            pmaFComDepLoansRelMapper.batchInsertDistribute(distributeLists);
            logger.info("3.批量插入明细表[{distributeLists}]成功:"+distributeLists.toString());
        }

        //4.审批流程接口调用
        resultDto.setCode(0);
        resultDto.setMessage("保存成功");
        return resultDto;
    }

    @Override
    public void executeApprove(Map<String,Object> map) {
        Object o = map.get("loansInfo");
        PmaFComDepLoansInfo pmaFComDepLoansInfo = null;
        if(o!=null && o!=""){
             pmaFComDepLoansInfo =  (PmaFComDepLoansInfo)o;
        }
        pmaFComDepLoansInfoMapper.updateByPrimaryKeySelective(pmaFComDepLoansInfo);
    }


    public List<Map<String, Object>> oneToManyQueryList(QueryModel queryModel) {
        PageHelper.startPage(queryModel.getPage(), queryModel.getSize());
        List<Map<String, Object>> list = pmaFComDepLoansInfoMapper.oneToManyQueryList(queryModel);
        PageHelper.clearPage();
        return list;
    }

    public Long oneToManyQueryCount(QueryModel queryModel) {
        return pmaFComDepLoansInfoMapper.oneToManyQueryCount(queryModel);
    }

    public void savePressList(List<UploadNode> pressList) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String curTime = sdf.format(new Date());
        String loginCode = userInfoService.getUserInfo().getLoginCode();
        String orgCode = userInfoService.getUserInfo().getOrg().getId();
        int index = 1;
        for(UploadNode node : pressList) {
            String ID = node.value.get("ID");
            if (StringUtils.isBlank(ID)) {
                continue;
            }
            QueryModel deptModel = new QueryModel();
            deptModel.getCondition().put("id",ID);
            List<Map<String,Object>> deptList = pmaFComDepLoansInfoMapper.queryList(deptModel);
            if(deptList.isEmpty() || deptList.get(0) == null){
                throw new RuntimeException("第"+index+"行，此数据不存在");
            }
            Map<String,Object> dept = deptList.get(0);
            QueryModel model = new QueryModel();
            model.getCondition().put("loansInfoId",ID);
            List<Map<String, Object>> periodList = pmaFComDepLoansPeriodMapper.queryList(model);
            for(Map<String, Object>  period: periodList){
                if(!period.containsKey("ID") || StringUtils.isBlank((String)period.get("ID"))){
                    continue;
                }
                pmaFComDepLoansRelMapper.delDistribute((String)period.get("ID"));
            }
            pmaFComDepLoansPeriodMapper.delPmaFComDepPeriod(ID);
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
                PmaFComDepLoansPeriod period = new PmaFComDepLoansPeriod();
                period.setId(childUuidStr);
                period.setLoansInfoId(ID);
                period.setEffectDate(childNode.value.get("起始日期"));
                period.setExpirateDate(childNode.value.get("结束日期"));
                period.setOperTime(dateFormat.format(new Date()));
                period.setOperOrgId(userInfoService.getUserInfo().getOrg().getId());
                period.setOperUserId(userInfoService.getUserInfo().getUserId());
                period.setCreator(loginCode);
                period.setCreateDate(curTime);
                period.setCreateOrg(orgCode);
                pmaFComDepLoansPeriodMapper.insertSelective(period);
                String allocType = "";
                boolean isRate = true;
                int j_index = 0;
                double rate = 0.0;
                double all = Double.parseDouble(String.valueOf(dept.get("lAmt")));
                double last_amount = 0.0;

                for(UploadNode grandNode : childNode.children){
                    index ++;
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
                    UNIDProducer grandUuid = new UNIDProducer();
                    String grandUuidStr= grandUuid.getUNID();
                    PmaFComDepLoansRel pmaFComDepLoansRel = new PmaFComDepLoansRel();
                    pmaFComDepLoansRel.setId(grandUuidStr);
                    pmaFComDepLoansRel.setPeriodId(childUuidStr);
                    pmaFComDepLoansRel.setAllotType(grandNode.value.get("分配类型"));
                    pmaFComDepLoansRel.setManagerId(grandNode.value.get("客户经理编号"));
                    Map<String, Object> manager = pmaMidInfoService.selectUser(grandNode.value.get("客户经理编号"));
                    if(manager == null || StringUtils.isBlank((String)manager.get("userId"))){
                        throw new RuntimeException("第"+index+"行，该职员信息不存在");
                    }
                    pmaFComDepLoansRel.setManagerName(manager.get("userName").toString());
//                    if(isRate){
                        if(StringUtils.isBlank(grandNode.value.get("业绩分配比例(%)"))){
                            throw new RuntimeException("第"+index+"行，业绩分配比例(%)为空");
                        }
                        rate += Double.parseDouble(grandNode.value.get("业绩分配比例(%)"));
                        if(rate>100 || rate <=0){
                            throw new RuntimeException("第"+index+"行，比例错误");
                        }
//                    }else {
//                        if(StringUtils.isBlank(grandNode.value.get("起始金额"))){
//                            throw new RuntimeException("第"+index+"行，起始金额为空");
//                        }
//                        if(StringUtils.isBlank(grandNode.value.get("结束金额"))){
//                            throw new RuntimeException("第"+index+"行，结束金额为空");
//                        }
//                        double startAmount = Double.parseDouble(grandNode.value.get("起始金额"));
//                        double endAmount = Double.parseDouble(grandNode.value.get("结束金额"));
//                        if(endAmount < startAmount){
//                            throw new RuntimeException("第"+index+"行，起始金额大于结束金额");
//                        }else if(startAmount != last_amount){
//                            throw new RuntimeException("第"+index+"行，起始金额不连续");
//                        }
//                        last_amount = endAmount;
//                    }
                    pmaFComDepLoansRel.setStartAmt(grandNode.value.get("起始金额"));
                    pmaFComDepLoansRel.setEndAmt(grandNode.value.get("结束金额"));
                    pmaFComDepLoansRel.setDistrRate(grandNode.value.get("业绩分配比例(%)"));
                    pmaFComDepLoansRelMapper.insertSelective(pmaFComDepLoansRel);
                    j_index ++;
                }
//                if(isRate){
                    if(rate != 100){
                        throw new RuntimeException("第"+index+"行，比例错误");
                    }
//                }else if(last_amount != all){
//                    throw new RuntimeException("第"+index+"行，汇总金额不等于贷款金额");
//                }
            }
            PmaFComDepLoansInfo update = new PmaFComDepLoansInfo();
            update.setId(ID);
            update.setDstrSts("2");
            pmaFComDepLoansInfoMapper.updateByPrimaryKeySelective(update);
        }

    }


}
