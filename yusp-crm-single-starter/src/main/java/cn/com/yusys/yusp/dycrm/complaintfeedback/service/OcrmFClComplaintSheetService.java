package cn.com.yusys.yusp.dycrm.complaintfeedback.service;

import cn.com.yusys.yusp.admin.web.rest.util.HeaderUtil;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.dycrm.complaintfeedback.domain.CustomerInformationDTO;
import cn.com.yusys.yusp.dycrm.complaintfeedback.domain.OcrmFClComplaintSheet;
import cn.com.yusys.yusp.dycrm.complaintfeedback.repository.mapper.OcrmFClComplaintSheetMapper;
import cn.com.yusys.yusp.uaa.client.UaaClient;
import cn.com.yusys.yusp.uaa.client.dto.UserInfoDTO;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 *
 * @项目名称: yusp-crm-single-starter
 * @类名称: OcrmFClComplaintSheetService
 * @类描述:
 * @功能描述: 模型版本信息
 * @创建人: chenrb@yusys.com.cn
 * @创建时间: 2022/3/28 10:46
 * @修改备注:
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class OcrmFClComplaintSheetService extends CommonService {

    @Autowired
    private UaaClient uaaClient;

    @Autowired
    private OcrmFClComplaintSheetMapper ocrmFClComplaintSheetMapper;


    private static SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


    @Override
    protected CommonMapper getMapper() {
        return ocrmFClComplaintSheetMapper;
    }


    public List<Map<String, Object>> queryPrepare(QueryModel queryModel) {
        PageHelper.startPage(queryModel.getPage(), queryModel.getSize());
        Map<String, Object> queryMap = new HashMap<>();
        ResponseEntity<UserInfoDTO> dto = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken()); //获取当前登录人信息
        UserInfoDTO user = dto.getBody();
        queryMap.put("userCode", user.getLoginCode());  //登录用户编码
        queryMap.put("orgCode", user.getOrg().getCode());  //登录用户所属机构编码

        String userId = user.getUserCode(); //主办经理账号
        String custId =(String) queryModel.getCondition().get("custId"); //客户编号
        String customerId = "";
        if (!"".equals(custId) && custId != null && "undefined".equals(custId)){
            if (custId.contains("_")){
                customerId = custId.split("_")[0];
            }else {
                customerId = custId;
            }

        }
        String sheetId =(String) queryModel.getCondition().get("sheetId"); //工单编号
        String custEcifNo =(String) queryModel.getCondition().get("custEcifNo"); //客户编号
        String handleState =(String) queryModel.getCondition().get("handleState"); //客户编号
        queryMap.put("userId",userId);
        queryMap.put("customerId",customerId);
        queryMap.put("sheetId",sheetId);
        queryMap.put("custEcifNo",custEcifNo);
        queryMap.put("handleState",handleState);
        List<Map<String, Object>> list =  ocrmFClComplaintSheetMapper.queryComplaint(queryMap);
        PageHelper.clearPage();
        return list;
    }



    /**
     * 查询投诉反馈详情
     */
    public CustomerInformationDTO queryComplaintSheetInfo(QueryModel queryModel) {
        Map<String, Object> queryMap = new HashMap<>();
        String sheetId =(String) queryModel.getCondition().get("sheetId"); //工单编号
        queryMap.put("sheetId",sheetId);
        CustomerInformationDTO customerInformationDTO = ocrmFClComplaintSheetMapper.queryComplaintSheetInfo(queryMap);
        return customerInformationDTO;
    }



    /**
     * 保存主办经理反馈数据
     */
    public int saveData(QueryModel queryModel ) {
        String handleTime = sf.format(new Date());
        Map<String, Object> queryMap = new HashMap<>();
        String sheetIds = (String)queryModel.getCondition().get("sheetIds");
        String sheetResult = (String)queryModel.getCondition().get("sheetResult");
        queryMap.put("handletime",handleTime);
        queryMap.put("sheetIds",sheetIds);
        queryMap.put("sheetResult",sheetResult);
        int count = 0;
        if (StringUtils.isNotBlank(sheetIds) && StringUtils.isNotBlank(sheetResult)) {
             count = ocrmFClComplaintSheetMapper.saveData(queryMap);
        }
        return count;
    }



}
