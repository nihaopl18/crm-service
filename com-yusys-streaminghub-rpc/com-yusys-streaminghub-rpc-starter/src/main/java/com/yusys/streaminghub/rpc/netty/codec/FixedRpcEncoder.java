package com.yusys.streaminghub.rpc.netty.codec;

import com.yusys.streaminghub.rpc.RpcResponse;
import com.yusys.streaminghub.rpc.netty.IRpcEncoder;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;

public class FixedRpcEncoder extends ResponseToByte implements IRpcEncoder {


    @Override
    public void encode(RpcResponse response, ByteBuf byteBuf, ChannelHandlerContext channelHandlerContext) throws Exception {
        byte[] bytes = translateFixedResponse(response);

        byteBuf.writeBytes(bytes);
    }

}
  /*
     // 组装返回报文
 private String sendRespMsg() throws IOException {

  String headMsg;
  String hsb2 = new String("");
  String bsb2 = new String("");
  // 拼装报文头
  String hsb = new String("");
  hsb = hsb.concat(s).concat("1").concat(s);

  String hsb1 = new String("");
  hsb1 = hsb1.concat("SERVICE_CODE").concat(s)
    .concat("UPDATED_SYSTEM_ID").concat(s).concat("SRC_CREATE_TS")
    .concat(s).concat("SRC_UPDATED_TS").concat(s)
    .concat("UPDATED_USER").concat(s).concat("UPDATED_UNIT")
    .concat(s).concat("FLOW_ID").concat(s).concat("ERROR_CODE")
    .concat(s).concat("ERROR_MSG");

  // 拼装报文体
  hsb2 = hsb2.concat(s).concat("CUST_ID").concat(s)
    .concat("EVALUATE_RESULT").concat(s).concat("EVA_DATE")
    .concat(s).concat("USEFUL_LIFE_DATE").concat(s)
    .concat("ACCOUNT").concat(s).concat("REMARK_BACK1").concat(s)
    .concat("EVA_CHANNEL").concat(s).concat("COUNTER_EVA_FLAG").concat(s).concat("IF_EXPERIENCE").concat(s).
    //lchszdev091 ADD 20151218 客户风险评估结果增加"AUM评级"、"员工标识"字段
    concat("AUM_GRADE_CD").concat(s).concat("IS_STAFF_FLAG")
      //lchszdev091 Add 20160111 客户风险评估结果增加"生日"、"投资年限字段"
     //lchszdev091 Add  20160302 客户风险评估结果增加“两地通标识”字段
    .concat(s).concat("BIRTH_DT").concat(s).concat("INVEST_TERM").concat(s).concat("CLIENT_SOURCE").concat(s)
    .concat("CUST_TYPE").concat(s).concat("IS_LOWEST_FLAG").concat(s).concat("CODE_OCCUPATION");

  headMsg = hsb1.concat(hsb2);

  String[] arryStr = new String[] {};
  arryStr = headMsg.split(s);
  int i = arryStr.length;
  String len = extendZero(String.valueOf(i), 2);

  // 报文头值
  String bsb1 = new String("");
  bsb1 = bsb1.concat(jsb.get("SERVICE_CODE").toString()).concat(s)
    .concat("").concat(s).concat("").concat(s).concat("").concat(s)
    .concat("").concat(s).concat("").concat(s)
    .concat(jsb.get("FLOW_ID").toString()).concat(s)
    .concat(jsb.get("error_no").toString()).concat(s)
    .concat(jsb.get("error_info").toString()).concat(s);

  // 报文体值
  //增加查询为机构时返回客户类别
  String aumGrade = jsb.get("aum_grade_cd").toString();

  if("2".equals(jsb.get("cust_type_note").toString())){
   aumGrade = jsb.get("arg_patry_type").toString();
  }

  bsb2 = bsb2.concat(jsb.get("nds_cust_no").toString()).concat(s)
    .concat(jsb.get("grade").toString()).concat(s)
    .concat(jsb.get("eva_date").toString()).concat(s)
    .concat(jsb.get("eff_date").toString()).concat(s)
    .concat(jsb.get("score").toString()).concat(s).concat(jsb.get("REMARK_BACK1").toString())//mdify by lchszdev110 20170606修改为风险评估类型
    .concat(s).concat(jsb.get("channel").toString()).concat(s)
    .concat(jsb.get("counter_eva_flag").toString()).concat(s)
    .concat(jsb.get("if_experience").toString()).concat(s)
    //lchszdev091 ADD 20151218 客户风险评估结果增加“AUM评级”、“员工标识”字段
    .concat(aumGrade).concat(s).concat(jsb.get("is_staff_flag").toString()).concat(s)
    //lchszdev091 ADD 20151218 客户风险评估结果增加“客户生日”、“投资年限”字段
    //lchszdev091 ADD 20160302 客户风险评估结果增加“两地通标识”字段
    .concat(jsb.get("BIRTH_DT").toString()).concat(s).concat(jsb.get("INVEST_TERM").toString()).concat(s)
    .concat(jsb.get("client_source").toString()).concat(s)
    .concat(jsb.get("cust_type_note").toString()).concat(s)
    .concat(jsb.get("is_lower_note").toString()).concat(s)
    .concat(jsb.get("occ_code_note").toString()).concat(s);

  String bodyMsg = bsb1.concat(bsb2);

  // 长度
  String respMsg = len.concat(hsb).concat(headMsg).concat(s)
    .concat(bodyMsg);
  String msgLength = null;

  msgLength = extendZero(
    String.valueOf(respMsg.getBytes(ENCODING).length), HDRDESCLEN);

  String headFlag = "F009";

  respMsg = headFlag.concat(msgLength).concat(respMsg);

  log.info("【返回报文】:" + respMsg);
  return respMsg;
 }
     */