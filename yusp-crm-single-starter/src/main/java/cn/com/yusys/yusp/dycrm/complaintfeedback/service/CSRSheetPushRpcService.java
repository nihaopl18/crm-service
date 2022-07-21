package cn.com.yusys.yusp.dycrm.complaintfeedback.service;

import cn.com.yusys.yusp.dycrm.complaintfeedback.domain.CustomerInformationDTO;
import cn.com.yusys.yusp.dycrm.complaintfeedback.repository.mapper.CSRSheetPushOperateMapper;
import com.yusys.streaminghub.rpc.IRpcService;
import com.yusys.streaminghub.rpc.RpcRequest;
import com.yusys.streaminghub.rpc.RpcResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
@Service("SERVICE_CODE=CUST_COMPL_001")
public class CSRSheetPushRpcService implements IRpcService {
    //日期格式化 17位
    public static final SimpleDateFormat TIMESTAMPF = new SimpleDateFormat("yyyyMMddHHmmssSSS");
    //日期格式化 14位
    public static final SimpleDateFormat TIMESTAMPF14 = new SimpleDateFormat("yyyyMMddHHmmss");
    //日期格式化 8位
    public static final SimpleDateFormat TIMESTAMPF8 = new SimpleDateFormat("yyyyMMdd");

    private static SimpleDateFormat sf = new SimpleDateFormat(

            "yyyy-MM-dd HH:mm:ss");
    private static final Logger log = LoggerFactory.getLogger(CSRSheetPushRpcService.class);

    @Autowired
    private CSRSheetPushOperateMapper csrSheetPushOperateMapper;

    @Override
    public void doService(RpcRequest request, RpcResponse response) throws Exception {
        CustomerInformationDTO customerInformationDTO = new CustomerInformationDTO();
        Map<String, String> requestHeader = request.getHeader();
        customerInformationDTO.setServiceCode(notNull(requestHeader.get("SERVICE_CODE")));//交易代码
        customerInformationDTO.setUpdatedSystemId(notNull(requestHeader.get("UPDATED_SYSTEM_ID")));//更新系统号
        customerInformationDTO.setSrcUpdatedTs(notNull(requestHeader.get("SRC_UPDATED_TS")));//交易处理时间
        customerInformationDTO.setUpdatedUser(notNull(requestHeader.get("UPDATED_USER")));//操作客户经理编号
        customerInformationDTO.setUpdatedUnit(notNull(requestHeader.get("UPDATED_UNIT")));//操作分行
        customerInformationDTO.setFlowId(notNull(requestHeader.get("FLOW_ID")));//流水号

        //获取请求体值
        Map<String, Object> requestBody = request.getBody();
        customerInformationDTO.setSheetId(notNull(requestBody.get("SHEET_ID")));//工单
        customerInformationDTO.setCustName(notNull(requestBody.get("NAME"))); //客户姓名
        customerInformationDTO.setCardnbr(notNull(requestBody.get("CARDNBR")));//卡号或账号
        customerInformationDTO.setKeytype( notNull(requestBody.get("KEYTYPE")));//证件类型
        customerInformationDTO.setCustid(notNull(requestBody.get("CUSTID")));//证件号码
        customerInformationDTO.setMobilephone(notNull(requestBody.get("MOBILEPHONE")));//预留手机号码
        customerInformationDTO.setCallnum(notNull(requestBody.get("CALLNUM")));//来电号码
        customerInformationDTO.setGreyflag(notNull(requestBody.get("GREYFLAG")));//灰名单标识
        customerInformationDTO.setCustcategory(notNull(requestBody.get("CUSTCATEGORY")));//客户类别
        customerInformationDTO.setGender(notNull(requestBody.get("GENDER")));//客户性别
        customerInformationDTO.setTsContent(notNull(requestBody.get("TS_CONTENT")));//投诉内容
        customerInformationDTO.setTsDepart(notNull(requestBody.get("TS_DEPART")));//投诉所属机构
        customerInformationDTO.setTsType(notNull(requestBody.get("TS_TYPE")));//投诉/查询类型
        customerInformationDTO.setTsBusiness(notNull(requestBody.get("TS_BUSINESS")));//所涉及业务
        customerInformationDTO.setTsChannel(notNull(requestBody.get("TS_CHANNEL")));//渠道
        customerInformationDTO.setTsNote(notNull(requestBody.get("TS_NOTE")));//备注
        customerInformationDTO.setDirectorOpinion(notNull(requestBody.get("DIRECTOR_OPINION")));//分行投诉主任意见
        customerInformationDTO.setEndDate(notNull(requestBody.get("END_DATE")));//结案日期
        customerInformationDTO.setIssueCountry(notNull(requestBody.get("ISSUE_COUNTRY")));//签发国家
        customerInformationDTO.setComplainReason(notNull(requestBody.get("COMPLAIN_REASON")));//投诉原因



        //判断校验值
        isExist(request,customerInformationDTO);

        if ("000000".equals(customerInformationDTO.getErrorCode()) && "CRM查询成功".equals(customerInformationDTO.getErrorMsg())){
            //根据三证合一查询ecif客户号
            String ecifCustNo = queryEcifNo(customerInformationDTO);

            if ("".equals(ecifCustNo)|| ecifCustNo == null ){
                customerInformationDTO.setErrorCode("1004");
                customerInformationDTO.setErrorMsg("客户不存在");
            }else {
                //查询该ECIF客户号有无组办客户经理
                customerInformationDTO.setCustEcifNo(ecifCustNo);
                String cust_mgr_no = queryCustMgrNo(customerInformationDTO);
                if ("".equals(cust_mgr_no) || cust_mgr_no == null){
                    customerInformationDTO.setErrorCode("1006");
                    customerInformationDTO.setErrorMsg("主办客户经理不存在");
                }else {

                    if(sheetIdIsExist(customerInformationDTO)){
                        //覆盖工单
                        coverSheet(customerInformationDTO);
                    }else{
                        //2.工单信息处理
                        sheetPushHandle(customerInformationDTO);

                    }
                }
            }
        }

        fill(response,customerInformationDTO);

    }

    /**
     * 返回组装报文
     * @param response
     * @param customerInformationDTO
     */
    private void fill(RpcResponse response, CustomerInformationDTO customerInformationDTO) {
        Map<String, String> responseHeader = response.getHeader();
        responseHeader.put("SERVICE_CODE",customerInformationDTO.getServiceCode());
        responseHeader.put("UPDATED_SYSTEM_ID", customerInformationDTO.getUpdatedSystemId());
        responseHeader.put("SRC_CREATE_TS", customerInformationDTO.getSrcUpdatedTs());
        responseHeader.put("SRC_UPDATED_TS", TIMESTAMPF.format(new Date()));
        responseHeader.put("UPDATED_USER", customerInformationDTO.getUpdatedUser());
        responseHeader.put("UPDATED_UNIT", customerInformationDTO.getUpdatedUnit());
        responseHeader.put("FLOW_ID", customerInformationDTO.getFlowId());
        responseHeader.put("ERROR_CODE", customerInformationDTO.getErrorCode());
        responseHeader.put("ERROR_MSG", customerInformationDTO.getErrorMsg());
    }

    /**
     * 将工单推送
     * @param customerInformationDTO
     */
    public void sheetPushHandle(CustomerInformationDTO customerInformationDTO) {
        String createTime = sf.format(new Date());
        customerInformationDTO.setCreatetime(createTime);
        Map<String, Object> map = new HashMap<>();
        map.put("createTime",createTime);
        //TODO 完整带参
        int flag = csrSheetPushOperateMapper.sheetPushHandleTest(customerInformationDTO);
        if (flag > 0) {
            log.info("投诉工单推送成功");
            customerInformationDTO.setErrorCode("000000");
            customerInformationDTO.setErrorMsg("CRM投诉工单推送成功");
        } else {

            customerInformationDTO.setErrorCode("1005");
            customerInformationDTO.setErrorMsg("系统内部异常");
            log.info("CRM投诉工单推送失败");

        }
    }


    /**
     * 将工单覆盖
     * @param customerInformationDTO
     */
    public void coverSheet(CustomerInformationDTO customerInformationDTO) {
        String createTime = sf.format(new Date());
        customerInformationDTO.setCreatetime(createTime);

        int flag = csrSheetPushOperateMapper.coverSheetTest(customerInformationDTO);
        if (flag > 0) {

            log.info("投诉工单再次推送成功");
            customerInformationDTO.setErrorCode("000000");
            customerInformationDTO.setErrorMsg("CRM投诉工单再次推送成功");
        } else {
            customerInformationDTO.setErrorCode("1005");
            customerInformationDTO.setErrorMsg("系统内部异常");

            log.info("CRM投诉工单再次推送失败");

        }

    }


    /**
     * 根据工单ID查询是否已经推送过
     * @param customerInformationDTO
     * @return
     */
    public boolean sheetIdIsExist(CustomerInformationDTO customerInformationDTO) {
        boolean exist = false;
        int num = 0;
        Map<String, Object> map = new HashMap<>();
        num = csrSheetPushOperateMapper.sheetIdIsExistTest(customerInformationDTO);
        if (num>0){
            exist = true;
        }
        return exist;
    }

    /**
     * 避免出现"null"
     * @param obj
     * @return
     */
    public static String notNull(Object obj) {
        if (obj == null)
            return "";
        return obj.toString();

    }

    /**
     * 根据ECIF客户号查询主办客户经理
     * @param customerInformationDTO
     * @return
     */
    public String queryCustMgrNo(CustomerInformationDTO customerInformationDTO) {
        Map<String, Object> map = new HashMap<>();
        map.put("ecifCustNo",customerInformationDTO.getCustEcifNo());
        Map<String, Object> result = csrSheetPushOperateMapper.queryCustMgrNo(map);
        String cust_mgr_no = "";
        if (result!=null){
            cust_mgr_no =(String) result.get("custMgrNo");

            String cust_mgr_org_no = (String)result.get("custMgrOrgNo");

            String cust_mgr_nm = (String)result.get("custMgrNm");

            customerInformationDTO.setCustMgrNo(cust_mgr_no);

            customerInformationDTO.setCustMgrNm(cust_mgr_nm);

            customerInformationDTO.setCustMgrOrgNo(cust_mgr_org_no);

        }
        return cust_mgr_no;
    }

    /**
     * 根据三证合一查询ecif客户号
     * @param customerInformationDTO
     * @return
     */
    public String queryEcifNo(CustomerInformationDTO customerInformationDTO) {
        Map<String, Object> resultMap = csrSheetPushOperateMapper.queryEcifNoByCust(customerInformationDTO);
        String ecifCustNo = resultMap!=null ? (String) resultMap.get("custId"):"";
        return ecifCustNo;
    }

    /**
     * //判断校验值
     * @param request
     */
    public  void isExist(RpcRequest request,CustomerInformationDTO customerInformationDTO) {
        Map<String, String> header = request.getHeader();
        Map<String, Object> requestBody = request.getBody();

        // 判断报文头节点是否存在
        if (header.get("SERVICE_CODE") == null) {
            customerInformationDTO.setErrorCode("1001");
            customerInformationDTO.setErrorMsg("SERVICE_CODE报文格式不符合规范");

        }else if (header.get("SRC_UPDATED_TS") == null) {
            customerInformationDTO.setErrorCode("1001");
            customerInformationDTO.setErrorMsg("SRC_UPDATED_TS报文格式不符合规范");

        } else if (header.get("FLOW_ID") == null) {
            customerInformationDTO.setErrorCode("1001");
            customerInformationDTO.setErrorMsg("FLOW_ID报文格式不符合规范");


        }// 校验报文头值不为空
        else if (header.get("SERVICE_CODE") == null || "".equals(header.get("SERVICE_CODE"))) {
            customerInformationDTO.setErrorCode("1002");
            customerInformationDTO.setErrorMsg("交易代码输入内容不允许为空");

        }else if (header.get("SRC_UPDATED_TS") == null || "".equals(header.get("SRC_UPDATED_TS"))) {
            customerInformationDTO.setErrorCode("1002");
            customerInformationDTO.setErrorMsg("交易处理时间输入内容不允许为空");


        } else if (header.get("FLOW_ID") == null || "".equals(header.get("FLOW_ID"))) {
            customerInformationDTO.setErrorCode("1002");
            customerInformationDTO.setErrorMsg("流水号输入内容不允许为空");


        } // 判断报文头体点是否存在
        else if (requestBody.get("SHEET_ID") == null) {
            customerInformationDTO.setErrorCode("1001");
            customerInformationDTO.setErrorMsg("工单编号报文格式不符合规范");

        }  // 对请求报文体必输字段做校验
        else if ("".equals(requestBody.get("SHEET_ID"))) {
            customerInformationDTO.setErrorCode("1002");
            customerInformationDTO.setErrorMsg("工单编号输入内容不允许为空");

        } 
        else if (requestBody.get("CARDNBR") == null) {

            customerInformationDTO.setErrorCode("1001");
            customerInformationDTO.setErrorMsg("卡号或账号报文格式不符合规范");



        }else if (requestBody.get("NAME") == null) {

           customerInformationDTO.setErrorCode("1001");
            customerInformationDTO.setErrorMsg("客户姓名报文格式不符合规范");



        }else if (requestBody.get("KEYTYPE") == null) {

           customerInformationDTO.setErrorCode("1001");
            customerInformationDTO.setErrorMsg("证件类型报文格式不符合规范");



        }else if (requestBody.get("CUSTID") == null) {

           customerInformationDTO.setErrorCode("1001");
            customerInformationDTO.setErrorMsg("证件号码报文格式不符合规范");



        }else if (requestBody.get("MOBILEPHONE") == null) {

           customerInformationDTO.setErrorCode("1001");
            customerInformationDTO.setErrorMsg("预留手机号码报文格式不符合规范");



        }else if (requestBody.get("CALLNUM") == null) {

           customerInformationDTO.setErrorCode("1001");
            customerInformationDTO.setErrorMsg("来电号码报文格式不符合规范");



        }else if (requestBody.get("GREYFLAG") == null) {

           customerInformationDTO.setErrorCode("1001");
            customerInformationDTO.setErrorMsg("灰名单标识报文格式不符合规范");



        }else if (requestBody.get("CUSTCATEGORY") == null) {

           customerInformationDTO.setErrorCode("1001");
            customerInformationDTO.setErrorMsg("客户类别报文格式不符合规范");



        }else if (requestBody.get("GENDER") == null) {

           customerInformationDTO.setErrorCode("1001");
            customerInformationDTO.setErrorMsg("客户性别报文格式不符合规范");



        }else if (requestBody.get("TS_CONTENT") == null) {

           customerInformationDTO.setErrorCode("1001");
            customerInformationDTO.setErrorMsg("投诉内容报文格式不符合规范");



        }else if (requestBody.get("TS_DEPART") == null) {

           customerInformationDTO.setErrorCode("1001");
            customerInformationDTO.setErrorMsg("投诉所属机构报文格式不符合规范");



        }else if (requestBody.get("TS_TYPE") == null) {

           customerInformationDTO.setErrorCode("1001");
            customerInformationDTO.setErrorMsg("投诉或查询类型报文格式不符合规范");



        }else if (requestBody.get("TS_BUSINESS") == null) {

           customerInformationDTO.setErrorCode("1001");
            customerInformationDTO.setErrorMsg("所涉及业务报文格式不符合规范");



        }else if (requestBody.get("TS_CHANNEL") == null) {

           customerInformationDTO.setErrorCode("1001");
            customerInformationDTO.setErrorMsg("渠道报文格式不符合规范");



        }else if (requestBody.get("TS_NOTE") == null) {

           customerInformationDTO.setErrorCode("1001");
            customerInformationDTO.setErrorMsg("备注报文格式不符合规范");



        }else if (requestBody.get("DIRECTOR_OPINION") == null) {

           customerInformationDTO.setErrorCode("1001");
            customerInformationDTO.setErrorMsg("分行投诉主任意见报文格式不符合规范");



        }else if (requestBody.get("END_DATE") == null) {

           customerInformationDTO.setErrorCode("1001");
            customerInformationDTO.setErrorMsg("结案日期报文格式不符合规范");



        }else if (requestBody.get("ISSUE_COUNTRY") == null) {

           customerInformationDTO.setErrorCode("1001");
            customerInformationDTO.setErrorMsg("签发国家报文格式不符合规范");



        }else if (requestBody.get("COMPLAIN_REASON") == null) {

           customerInformationDTO.setErrorCode("1001");
            customerInformationDTO.setErrorMsg("投诉原因报文格式不符合规范");



        }  // 对请求报文体必输字段做校验

        else if ("".equals(requestBody.get("SHEET_ID"))) {

           customerInformationDTO.setErrorCode("1002");
            customerInformationDTO.setErrorMsg("工单编号不允许为空");



        }else if ("".equals(requestBody.get("KEYTYPE"))) {

           customerInformationDTO.setErrorCode("1002");
            customerInformationDTO.setErrorMsg("证件类型不允许为空");



        }else if ("".equals(requestBody.get("CUSTID"))) {

           customerInformationDTO.setErrorCode("1002");
            customerInformationDTO.setErrorMsg("证件号码不允许为空");



        }else if ("".equals(requestBody.get("ISSUE_COUNTRY"))) {

           customerInformationDTO.setErrorCode("1002");
            customerInformationDTO.setErrorMsg("签发国家不允许为空");



        }
    }
}
