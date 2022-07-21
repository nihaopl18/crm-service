package cn.com.yusys.yusp.dycrm.complaintfeedback.service;

import cn.com.yusys.yusp.dycrm.complaintfeedback.domain.CustomerInformationDTO;
import cn.com.yusys.yusp.dycrm.complaintfeedback.domain.OcrmFClComplaintSheet;
import cn.com.yusys.yusp.dycrm.complaintfeedback.repository.mapper.OcrmFClComplaintSheetMapper;
import com.yusys.streaminghub.rpc.IRpcService;
import com.yusys.streaminghub.rpc.RpcRequest;
import com.yusys.streaminghub.rpc.RpcResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
@Service("SERVICE_CODE=CUST_COMPL_002")
public class CSRSheetQueryRpcService implements IRpcService {

    //日期格式化 17位
    public static final SimpleDateFormat TIMESTAMPF = new SimpleDateFormat("yyyyMMddHHmmssSSS");
    //日期格式化 14位
    public static final SimpleDateFormat TIMESTAMPF14 = new SimpleDateFormat("yyyyMMddHHmmss");
    //日期格式化 8位
    public static final SimpleDateFormat TIMESTAMPF8 = new SimpleDateFormat("yyyyMMdd");

    private static final Logger log = LoggerFactory.getLogger(CSRSheetQueryRpcService.class);


    @Autowired
    private OcrmFClComplaintSheetMapper ocrmFClComplaintSheetMapper;

    @Override
    public void doService(RpcRequest request, RpcResponse response) throws Exception {
        CustomerInformationDTO customerInformationDTO = new CustomerInformationDTO();
        //判断报文节点是否存在
        isExist(request,customerInformationDTO);
        
        //获取请求报文头
        Map<String, String> header = request.getHeader();
        customerInformationDTO.setServiceCode(notNull(header.get("SERVICE_CODE")));//交易代码
        customerInformationDTO.setUpdatedSystemId(notNull(header.get("UPDATED_SYSTEM_ID")));//更新系统号
        customerInformationDTO.setSrcUpdatedTs(notNull(header.get("SRC_UPDATED_TS")));//交易处理时间
        customerInformationDTO.setUpdatedUser(notNull(header.get("UPDATED_USER")));//操作客户经理编号
        customerInformationDTO.setUpdatedUnit(notNull(header.get("UPDATED_UNIT")));//操作分行
        customerInformationDTO.setFlowId(notNull(header.get("FLOW_ID")));//流水号

        //获取请求体
        Map<String, Object> requestBody = request.getBody();
        String sheetId = requestBody.get("SHEET_ID").toString(); //工单编号
        //CustomerInformationDTO resultCustomerInformation = new CustomerInformationDTO();
        try {
            CustomerInformationDTO result  = ocrmFClComplaintSheetMapper.sheetQueryHandleTest(sheetId);
            if (result == null){
                customerInformationDTO.setErrorCode("1007");
                customerInformationDTO.setErrorMsg("工单编码不存在");

            }else {
                if ("0".equals(result.getHandleState())){
                    customerInformationDTO.setErrorCode("1008");
                    customerInformationDTO.setErrorMsg("该投诉订单正在处理当中");
                }else {
                    customerInformationDTO.setErrorCode("000000");
                    customerInformationDTO.setErrorMsg("CRM查询工单信息成功");
                }
            }
            customerInformationDTO.setSheetId(result == null ? "" : notNull(result.getSheetId()));
            customerInformationDTO.setCustEcifNo(result == null ? "" : notNull(result.getCustEcifNo()));
            customerInformationDTO.setCustName(result == null ? "" : notNull(result.getCustName()));
            customerInformationDTO.setCustcategory(result == null ? "" : notNull(result.getCustcategory()));
            customerInformationDTO.setCustMgrNo(result == null ? "" : notNull(result.getCustMgrNo()));
            customerInformationDTO.setCustMgrNm(result == null ? "" : notNull(result.getCustMgrNm()));
            customerInformationDTO.setTsContent(result == null ? "" : notNull(result.getTsContent()));
            customerInformationDTO.setSheetResult(result == null ? "" : notNull(result.getSheetResult()));
            customerInformationDTO.setHandleState(result == null ? "" : notNull(result.getHandleState()));

        }catch (Exception e){
            customerInformationDTO.setErrorCode("1005");
            customerInformationDTO.setErrorMsg("系统内部异常");
            log.info(e.getMessage(),e);
        }

        /*resultCustomerInformation.setServiceCode(customerInformationDTO.getServiceCode());//交易代码
        resultCustomerInformation.setUpdatedSystemId(customerInformationDTO.getUpdatedSystemId());//更新系统号
        resultCustomerInformation.setSrcUpdatedTs(customerInformationDTO.getSrcUpdatedTs());//交易处理时间
        resultCustomerInformation.setUpdatedUser(customerInformationDTO.getUpdatedUser());//操作客户经理编号
        resultCustomerInformation.setUpdatedUnit(customerInformationDTO.getUpdatedUnit());//操作分行
        resultCustomerInformation.setFlowId(customerInformationDTO.getFlowId());//流水号*/
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
        Map<String, String> responseBody = response.getBody();

            responseBody.put("sheetId",customerInformationDTO.getSheetId());
            responseBody.put("custEcifNo",customerInformationDTO.getCustEcifNo());
            responseBody.put("custName",customerInformationDTO.getCustName());
            responseBody.put("customerType",customerInformationDTO.getCustcategory());
            responseBody.put("custMgrNo",customerInformationDTO.getCustMgrNo());
            responseBody.put("custMgrNm",customerInformationDTO.getCustMgrNm());
            responseBody.put("custMgrOrgNo",customerInformationDTO.getCustMgrOrgNo());
            responseBody.put("sheetContent",customerInformationDTO.getTsContent());
            responseBody.put("sheetResult",customerInformationDTO.getSheetResult());

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
     * 获取报文头节是否存在
     */
    public static void isExist(RpcRequest request,CustomerInformationDTO customerInformationDTO) {
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
    }
}
