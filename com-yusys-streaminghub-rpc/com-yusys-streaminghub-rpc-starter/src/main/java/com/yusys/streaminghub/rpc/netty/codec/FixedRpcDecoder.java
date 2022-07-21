package com.yusys.streaminghub.rpc.netty.codec;

import com.yusys.streaminghub.rpc.RpcRequest;
import com.yusys.streaminghub.rpc.RpcResponse;
import com.yusys.streaminghub.rpc.netty.IRpcDecoder;
import com.yusys.streaminghub.rpc.util.UtilRpc;
import io.netty.channel.ChannelHandlerContext;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

public class FixedRpcDecoder extends ResponseToByte implements IRpcDecoder {
    @Override
    public void decode(byte[] bytes, List<Object> outList, ChannelHandlerContext channelHandlerContext) throws Exception {
        String message = new String(bytes, UtilRpc.ENCODING);
        message = message.substring(UtilRpc.HEAD_FLAG.length());//跳过flag，3字节
        String messageLenStr = message.substring(0, UtilRpc.HDRDESCLEN);
        long messageCharCount = Long.valueOf(messageLenStr);
        message = message.substring(UtilRpc.HDRDESCLEN);
        String bb = String.format("%s1%s", UtilRpc.S_SEPARATION, UtilRpc.S_SEPARATION);
        int bbPos = message.indexOf(bb);
        if (bbPos <= 0) {
            doError(channelHandlerContext);
            return;
        }
        String headerStr = message.substring(0, bbPos);
        int headerItemCount = Integer.valueOf(headerStr);
        if (headerItemCount > messageCharCount) {
            doError( channelHandlerContext);
            return;
        }

        message = message.substring(bbPos + bb.length());
        String[] arryStr = message.split(UtilRpc.S_SEPARATION);

        RpcRequest request = new RpcRequest("fixed");
        Map<String,String>header=request.getHeader();//定长模式的客端报文头中的报文头字段和体字段中间无区分，因此全放到报文头中。
        for (int i = 0; i < headerItemCount; i++) {
            String k = arryStr[i];
            int vPos = i + headerItemCount;
            //头和体是成对的，但如果体的项数不够头多，为了向下兼容侦错误，即arryStr长度不是headerCharCount的2倍，则视头的值为空
            String v = vPos < arryStr.length ? arryStr[vPos] : "";
            header.put(k, v);
        }

        outList.add(request);
    }

    private void doError(ChannelHandlerContext channelHandlerContext) throws UnsupportedEncodingException {
        RpcResponse jsb = new RpcResponse();
        jsb.getHeader().put("error_no", "1001");
        jsb.getHeader().put("error_info", "报文格式不符合规范");
        byte[] bytes = translateFixedResponse(jsb);
        channelHandlerContext.writeAndFlush(bytes);
        channelHandlerContext.close();
    }

   /*
    private void parseReqMsg(String msg) throws Exception {
        String remark_back = "";
        String cust_id = "";
        String service_code = "";
        String updated_system_id = "";
        String src_updated_ts = "";
        String flow_id = "";
        String updated_user = "";

        String cust_type ="";

        String[] arryStr = new String[] {};
        arryStr = msg.split(s);
        if (arryStr.length < 10) {
            jsb.put("error_no", "1001");
            jsb.put("error_info", "报文格式不符合规范");

            jsb.put("SERVICE_CODE", service_code);
            jsb.put("FLOW_ID", flow_id);
            jsb.put("UPDATED_USER", updated_user);

            jsb.put("nds_cust_no", ndscustno);
            jsb.put("grade", grade == 0 ? "" : grade);
            jsb.put("eff_date", eff_date);
            jsb.put("score", score == 0 ? "" : score);
            jsb.put("eva_date", eva_date);

        } else {
            // 交易代码
            //由于报文增加了字段，按照位置排序，在报文字段中加了一个，则这里报文值均需要加一
            if (arryStr.length > 13) {
                service_code = arryStr[13];
            }
            if (arryStr.length > 14) {
                updated_system_id = arryStr[14];
            }
            if (arryStr.length > 15) {
                src_updated_ts = arryStr[15];
            }
            if (arryStr.length > 16) {
                updated_user = arryStr[16];
            }

            // 发起方流水号
            if (arryStr.length > 18) {
                flow_id = arryStr[18];
            }

            // 客户号
            if (arryStr.length > 21) {
                cust_id = arryStr[21];
            }

            //查询风险评估类型:1理财风评，2基金风评
            if (arryStr.length > 22) {
                remark_back = arryStr[22];
            }
            //客户类型 1个人 2 对公
            if (arryStr.length > 23) {
                cust_type = arryStr[23];
            }

            jsb.put("nds_cust_no", ndscustno);
            jsb.put("grade", grade == 0 ? "" : grade);
            jsb.put("eff_date", eff_date);
            jsb.put("score", score == 0 ? "" : score);
            jsb.put("eva_date", eva_date);
            jsb.put("channel", channel);
            //modify 20150323 lchyx0016 增加是否面簽字段
            jsb.put("counter_eva_flag", counter_eva_flag);
            jsb.put("if_experience", if_experience);
            jsb.put("aum_grade_cd",aum_grade_cd);
            jsb.put("arg_patry_type",arg_patry_type);
            jsb.put("is_staff_flag",is_staff_flag);
            jsb.put("BIRTH_DT",birth_dt);
            jsb.put("INVEST_TERM",invest_term);
            jsb.put("client_source", client_source);

            jsb.put("cust_type_note", cust_type_note);
            jsb.put("is_lower_note", is_lower_note);
            jsb.put("occ_code_note",occ_code_note);

            jsb.put("SERVICE_CODE", service_code);
            jsb.put("FLOW_ID", flow_id);
            if (updated_user == null || "".equals(updated_user)) {
                jsb.put("UPDATED_USER", "");
            }
            jsb.put("UPDATED_USER", updated_user);

            jsb.put("CUST_ID", cust_id);
            jsb.put("REMARK_BACK1", remark_back);

            jsb.put("CUST_TYPE", cust_type);

            if (isExist(msg)) {
                if (service_code == null || "".equals(service_code)) {
                    jsb.put("error_no", "1002");
                    jsb.put("error_info", "交易代码输入为空");
                } else if (updated_system_id == null
                        || "".equals(updated_system_id)) {
                    jsb.put("error_no", "1002");
                    jsb.put("error_info", "更新系统号输入为空");
                } else if (src_updated_ts == null || "".equals(src_updated_ts)) {
                    jsb.put("error_no", "1002");
                    jsb.put("error_info", "更新处理时间输入为空");
                } else if ("".equals(flow_id) || flow_id == null) {
                    jsb.put("error_no", "1002");
                    jsb.put("error_info", "流水号输入为空");
                } else if (cust_id == null || "".equals(cust_id)) {
                    jsb.put("error_no", "1002");
                    jsb.put("error_info", "客户号输入为空");
                } else {
                    jsb.put("nds_cust_no", cust_id);//保存NDS客户号
                    // 根据CUST_ID查询客户风险评估结果--NDS客户号
                    //TODO  20181130 适应微信的修改
                    String ecif_cust_no = "";
                    if("WEICHAT".equals(updated_system_id)){
                        String custDecode = AESHelper.decodeByKey(desKey,jsb.get("CUST_ID").toString());
                        log.info("WEICHAT加密数据："+jsb.get("CUST_ID").toString()+"====解密后数据:"+custDecode);

                        String[] certFactors = custDecode.split("\\^");
                        ecif_cust_no = selEcifByCertFactors(certFactors[0], certFactors[1], certFactors[2]);

                    }else{
                        // 根据CUST_ID查询客户风险评估结果--NDS客户号
                        ecif_cust_no = selEcifCust(cust_id);
                    }

                    if(ecif_cust_no != null && !"".equals(ecif_cust_no)){
                        selRiskVeaInfo(ecif_cust_no,remark_back,cust_type);
                        //modify 20150323 lchyx0016  增加是否面簽字段
                        getCounterEva(ecif_cust_no,remark_back);

                        //lchszdev091  ADD查询客户风险评估接口增加"AUM评级"、"员工标识"字段
                        getCustAumGrade(ecif_cust_no);

                        getArgCustPartyType(ecif_cust_no);

                        //lchszdev091 Add 20160111 查询风险评估接口增加"客户生日"、“两地通客户标识”字段
                        getCustBirthDt(ecif_cust_no,cust_type);
                    }

                    //通过风险评估等级判断是否查询到客户风险评估信息
                    if (null == jsb.get("grade").toString()
                            || "".equals(jsb.get("grade").toString())) {
                        jsb.put("error_no", "1006");
                        jsb.put("error_info", "未查询到客户风险评估信息");
                    } else {
                        jsb.put("error_no", "000000");
                        jsb.put("error_info", "CRM查询成功");
                    }
                }
            }
        }

    }

    */
}
