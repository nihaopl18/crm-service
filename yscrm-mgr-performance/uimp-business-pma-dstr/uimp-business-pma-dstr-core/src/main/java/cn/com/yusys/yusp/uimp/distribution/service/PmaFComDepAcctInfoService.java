package cn.com.yusys.yusp.uimp.distribution.service;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yusp.uimp.base.service.UserInfoService;
import cn.com.yusys.yusp.uimp.distribution.domain.PmaFComDepAcctInfo;
import cn.com.yusys.yusp.uimp.distribution.domain.PmaFComDepDistributeOfPeriod;
import cn.com.yusys.yusp.uimp.distribution.domain.PmaFComDepPeriod;
import cn.com.yusys.yusp.uimp.distribution.domain.PmaFcomDepDistributeInfo;
import cn.com.yusys.yusp.uimp.distribution.repository.mapper.PmaFComDepAcctInfoMapper;
import cn.com.yusys.yusp.uimp.distribution.repository.mapper.PmaFComDepPeriodMapper;
import cn.com.yusys.yusp.uimp.distribution.repository.mapper.PmaFcomDepDistributeMapper;
import com.alibaba.fastjson.JSON;
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
@Component("PmaFComDepAcctInfoService")
public class PmaFComDepAcctInfoService extends CommonService implements IPmaFComDepCommService {

    protected final Log logger = LogFactory.getLog(PmaFComDepAcctInfoService.class);

    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private PmaFComDepAcctInfoMapper pmaFComDepAcctInfoMapper;
    @Autowired
    private PmaFComDepPeriodMapper pmaFComDepPeriodMapper;
    @Autowired
    private PmaFcomDepDistributeMapper pmaFcomDepDistributeMapper;

    @Override
    protected CommonMapper getMapper() {
        return pmaFComDepAcctInfoMapper;
    }

    @Override
    public List<Map<String, Object>> queryCommList(QueryModel model) {

        PageHelper.startPage(model.getPage(), model.getSize());
        model.getCondition().put("orgCode", userInfoService.getUserInfo().getOrg().getCode());
        List<Map<String, Object>> list = pmaFComDepAcctInfoMapper.queryList(model);

        logger.info("查询存款业绩分配集合[{model}]成功:" + model.toString());
        PageHelper.clearPage();
        return list;
    }

    @Override
    public List<Map<String, Object>> queryHisList(QueryModel model) {
        PageHelper.startPage(model.getPage(), model.getSize());

        List<Map<String, Object>> list = pmaFComDepAcctInfoMapper.queryDepositHis(model);

        logger.info("查询存款业绩分配历史集合[{model}]成功:" + model.toString());
        PageHelper.clearPage();
        return list;
    }

    @Override
    public ResultDto<Object> savezbBean(Map<String, Object> map) {
        ResultDto<Object> resultDto = new ResultDto<>();
        PmaFComDepDistributeOfPeriod pdList = JSON.parseObject(JSON.toJSON(map).toString(), PmaFComDepDistributeOfPeriod.class);

        String acctInfoId = pdList.getAcctInfoId();
        if (StringUtils.isEmpty(acctInfoId)) {
            logger.error("获取主键id失败:" + pdList.toString());
            return resultDto;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String curTime = sdf.format(new Date());
        String loginCode = userInfoService.getUserInfo().getLoginCode();
        String orgCode = userInfoService.getUserInfo().getOrg().getId();


        List<PmaFComDepPeriod> periodList = pdList.getPeriodList();
        //1.根据获取的主键id删除区间表、明细表
        this.pmaFcomDepDistributeMapper.delDistribute(acctInfoId);
        logger.info("1.1删除存款业绩分配明细集合[{pdList}]成功:" + pdList.toString());
        this.pmaFComDepPeriodMapper.delPmaFComDepPeriod(acctInfoId);
        logger.info("1.2删除存款业绩分配区间集合[{pdList}]成功:" + pdList.toString());
        List<String> periodIdList = new ArrayList<>();
        if (!CollectionUtils.isEmpty(periodList)) {

            if (!CollectionUtils.isEmpty(periodList)) {
                //区间list
                List<PmaFComDepPeriod> periodLists = new ArrayList<>();
                //详情list
                List<PmaFcomDepDistributeInfo> distributeLists = new ArrayList<>();

                //2.遍历前端区间参数重组区间list及详情list
                for (PmaFComDepPeriod plist : periodList) {
                    if(!StringUtils.isEmpty(plist.getApplySts()) && plist.getApplySts().equals("2")){
                        continue;
                    }
                    String periodId = UUID.randomUUID().toString().replace("-", "");
                    periodIdList.add(periodId);
                    plist.setId(periodId);
                    plist.setAcctInfoNo(acctInfoId);

                    plist.setCreator(loginCode);
                    plist.setCreateDate(curTime);
                    plist.setCreateOrg(orgCode);
                    periodLists.add(plist);

                    List<PmaFcomDepDistributeInfo> distributeList = plist.getPmaFcomDepDistributeInfo();
                    for (PmaFcomDepDistributeInfo dlist : distributeList) {
                        String distributeId = UUID.randomUUID().toString().replace("-", "");
                        dlist.setId(distributeId);
                        dlist.setPeriodId(periodId);

                        dlist.setCreator(loginCode);
                        dlist.setCreateDate(curTime);
                        dlist.setCreateOrg(orgCode);
                        distributeLists.add(dlist);
                    }
                }
                if(!CollectionUtils.isEmpty(periodLists)){
                    //3.批量插入区间表及明细表
                    pmaFComDepPeriodMapper.batchInsertPeriod(periodLists);
                    logger.info("2.批量插入区间表[{periodLists}]成功:" + periodLists.toString());
                }
                if(!CollectionUtils.isEmpty(distributeLists)){
                    pmaFcomDepDistributeMapper.batchInsertDistribute(distributeLists);
                    logger.info("3.批量插入明细表[{distributeLists}]成功:" + distributeLists.toString());
                }



            }
        }

        //4.审批流程接口调用
        resultDto.setCode(0);
        resultDto.setMessage("保存成功");
        resultDto.setData(periodIdList);
        return resultDto;
    }

    @Override
    public void executeApprove(Map<String,Object> map) {
        String applySts = map.get("applySts").toString();
        Object o = map.get("acctInfo");
        PmaFComDepAcctInfo pmaFComDepAcctInfo = null;
        if(o!=null && o!=""){
            pmaFComDepAcctInfo =  (PmaFComDepAcctInfo)o;
        }
        pmaFComDepAcctInfoMapper.updateAcctInfo(pmaFComDepAcctInfo);
        //同步更新明细表的审批字段
        pmaFcomDepDistributeMapper.updateDistributeByAcctInfoNo(pmaFComDepAcctInfo.getId(),applySts);
        //根据acctInfoNo根据更新区间表的审批字段
        pmaFComDepPeriodMapper.updatePeriodByAcctInfoNo(pmaFComDepAcctInfo.getId(),applySts);

         /*QueryModel queryModel = new QueryModel();
        queryModel.getCondition().put("id",pmaFComDepAcctInfo.getId());
        List<Map<String, Object>> list = pmaFComDepAcctInfoMapper.queryList(queryModel);
        if(list!=null && list.size()>0){
            //主表审批字段有数据说明是第二次更新的数据，否则是第一次更新的数据
           if(null != list.get(0).get("applySts") && list.get(0).get("applySts").toString().equals("2")){

            }else {
                //根据主键id更新主表审批字段不为空的applySts
                //pmaFComDepAcctInfoMapper.updateAcctInfoById(pmaFComDepAcctInfo.getId(),applySts,dstrSts);
                pmaFComDepAcctInfoMapper.updateAcctInfo(pmaFComDepAcctInfo);
            }

            //审批通过才更新区间明细表
            if(applySts.equals("2") || applySts.equals("1")){
                //同步更新明细表的审批字段
                pmaFcomDepDistributeMapper.updateDistributeByAcctInfoNo(pmaFComDepAcctInfo.getId(),applySts);
                //根据acctInfoNo根据更新区间表的审批字段
                pmaFComDepPeriodMapper.updatePeriodByAcctInfoNo(pmaFComDepAcctInfo.getId(),applySts);
            }
        }*/
    }

    public List<Map<String, Object>> oneToManyQueryList(QueryModel model){
        PageHelper.startPage(model.getPage(), model.getSize());
        List<Map<String, Object>> list = pmaFComDepAcctInfoMapper.oneToManyQueryList(model);
        PageHelper.clearPage();
        return list;
    }

    public Long oneToManyQueryCount(QueryModel model){
        return pmaFComDepAcctInfoMapper.oneToManyQueryCount(model);
    }


}
