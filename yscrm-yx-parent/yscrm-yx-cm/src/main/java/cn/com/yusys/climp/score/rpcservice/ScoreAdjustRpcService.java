package cn.com.yusys.climp.score.rpcservice;

import cn.com.yusys.climp.qypool.domain.LoyAcOrderExAttr;
import cn.com.yusys.climp.score.domain.ScoreExch;
import cn.com.yusys.climp.score.repository.mapper.ScoreAdjustMapper;
import cn.com.yusys.climp.score.service.ScoreAdjustService;
import cn.com.yusys.climp.utils.NullUtil;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import com.yusys.streaminghub.rpc.IRpcService;
import com.yusys.streaminghub.rpc.RpcRequest;
import com.yusys.streaminghub.rpc.RpcResponse;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service("SERVICE_CODE=CYBQUERY_0001_000005")
public class ScoreAdjustRpcService implements IRpcService {
    JSONObject jsp = new JSONObject();
    @Autowired
    private ScoreAdjustService scoreAdjustService;
    @Autowired
    private ScoreAdjustMapper scoreAdjustMapper;
    @Override
    public void doService(RpcRequest request, RpcResponse response) throws Exception {
        jsp.put("error_code","000000");
        jsp.put("error_msg","CRM兑换成功");
        Map<String,Object> requestBody = request.getBody();
        ResultDto<ScoreExch> rs = null;
        if (ifContinue(requestBody)){
            ScoreExch scoreExch = getScoreExch(requestBody);
            rs = scoreAdjustService.scoreExch(scoreExch);
            if (rs.getCode() != 0 && rs.getCode() == -1){
                String[] str = rs.getMessage().split("@");
                jsp.put("error_code",str[0]);
                jsp.put("error_msg",str[1]);
            }
        }
        fill(rs,requestBody,response);
    }

    private void fill(ResultDto<ScoreExch> rs, Map<String,Object> requestBody, RpcResponse response) {
        response.getHeader().put("ERROR_CODE",jsp.get("error_code"));
        response.getHeader().put("ERROR_MSG",jsp.get("error_msg"));
        Map<String, Object> responseBody = response.getBody();
        responseBody.put("systemId",requestBody.get("SYSTEM_ID"));
        responseBody.put("custId",requestBody.get("CUST_ID"));
        responseBody.put("ecifCustId",rs.getData().getCustId());
        responseBody.put("serviceDescTmp","");
    }

    private ScoreExch getScoreExch(Map<String, Object> requestBody) {
        ScoreExch scoreExch = new ScoreExch();
        scoreExch.setOnline(true);
        scoreExch.setSystemId((String) requestBody.get("SYSTEM_ID"));
        scoreExch.setNdsCustId((String) requestBody.get("CUST_ID"));
        scoreExch.setOrderCode((String) requestBody.get("ORDER_CODE"));
        scoreExch.setCommodityCode((String) requestBody.get("SERVICE_NO"));
        scoreExch.setChangeCount(Integer.parseInt((String) requestBody.get("CHANGE_COUNT")));
        scoreExch.setOrderChannel((String) requestBody.get("ORDER_CHANNEL"));
        scoreExch.setOperatorOrg((String) requestBody.get("OPERATE_ORG"));
        scoreExch.setOperatorCode((String) requestBody.get("OPERATOR_CODE"));
        scoreExch.setAppAccount((String) requestBody.get("APP_ACCOUNT"));
        scoreExch.setOrderDesc((String) requestBody.get("ORDER_DESC"));
        List<Map<String,Object>> list = (List<Map<String, Object>>) requestBody.get("EXTEND_ARR");
        List<LoyAcOrderExAttr> loyAcOrderExAttrs = new ArrayList<>();
        list.forEach(map -> {
            LoyAcOrderExAttr loyAcOrderExAttr = new LoyAcOrderExAttr();
            loyAcOrderExAttr.setAttrId(scoreAdjustMapper.getAttrId((String) map.get("ATTBE_CODE")));
            loyAcOrderExAttr.setAttrName((String) map.get("ATTBE_NAME"));
            loyAcOrderExAttr.setAttrDesc((String) map.get("ATTBE_DESC"));
            loyAcOrderExAttr.setAttrRemark((String) map.get("ATTBE_REMARK"));
            loyAcOrderExAttrs.add(loyAcOrderExAttr);
        });
        scoreExch.setExtendArr(loyAcOrderExAttrs);
        return scoreExch;
    }

    private boolean ifContinue(Map<String, Object> requestBody) {
        if (NullUtil.isNull(requestBody.get("SYSTEM_ID"))){
            jsp.put("error_code","1001");
            jsp.put("error_msg","源系统名称报文格式不符合规范");
            return false;
        }else if (NullUtil.isNull(requestBody.get("CUST_ID"))){
            jsp.put("error_code","1001");
            jsp.put("error_msg","源系统客户号报文格式不符合规范");
            return false;
        }else if (NullUtil.isNull(requestBody.get("ORDER_CODE"))){
            jsp.put("error_code","1001");
            jsp.put("error_msg","订单编号报文格式不符合规范");
            return false;
        }else if (NullUtil.isNull(requestBody.get("SERVICE_NO"))){
            jsp.put("error_code","1001");
            jsp.put("error_msg","礼遇编号报文格式不符合规范");
            return false;
        }else if (NullUtil.isNull(requestBody.get("CHANGE_COUNT"))){
            jsp.put("error_code","1001");
            jsp.put("error_msg","兑换数量报文格式不符合规范");
            return false;
        }else if (NullUtil.isNull(requestBody.get("ORDER_CHANNEL"))){
            jsp.put("error_code","1001");
            jsp.put("error_msg","兑换渠道报文格式不符合规范");
            return false;
        }else if (NullUtil.isNull(requestBody.get("ORDER_DT"))){
            jsp.put("error_code","1001");
            jsp.put("error_msg","订单日期报文格式不符合规范");
            return false;
        }else if (NullUtil.isNullString(requestBody.get("SYSTEM_ID"))){
            jsp.put("error_code","1002");
            jsp.put("error_msg","源系统名称输入内容不允许为空");
            return false;
        }else if (NullUtil.isNullString(requestBody.get("CUST_ID"))){
            jsp.put("error_code","1002");
            jsp.put("error_msg","源系统客户号输入内容不允许为空");
            return false;
        }else if (NullUtil.isNullString(requestBody.get("ORDER_CODE"))){
            jsp.put("error_code","1002");
            jsp.put("error_msg","订单编号输入内容不允许为空");
            return false;
        }else if (NullUtil.isNullString(requestBody.get("SERVICE_NO"))){
            jsp.put("error_code","1002");
            jsp.put("error_msg","礼遇编号输入内容不允许为空");
            return false;
        }else if (NullUtil.isNullString(requestBody.get("CHANGE_COUNT"))){
            jsp.put("error_code","1002");
            jsp.put("error_msg","兑换数量输入内容不允许为空");
            return false;
        }else if (NullUtil.isNullString(requestBody.get("ORDER_CHANNEL"))){
            jsp.put("error_code","1002");
            jsp.put("error_msg","兑换渠道输入内容不允许为空");
            return false;
        }else if (NullUtil.isNullString(requestBody.get("ORDER_DT"))){
            jsp.put("error_code","1002");
            jsp.put("error_msg","订单日期输入内容不允许为空");
            return false;
        }
        return true;
    }

}
