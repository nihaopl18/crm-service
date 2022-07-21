package cn.com.yusys.yscimc.operation.controller;

import cn.com.yusys.yscimc.operation.constant.ChannelCodeEnum;
import cn.com.yusys.yscimc.operation.constant.ChannelErrorCodeEnum;
import cn.com.yusys.yscimc.operation.constant.InterfaceConstants;
import cn.com.yusys.yscimc.operation.constant.TransCodeAndInterface;
import cn.com.yusys.yscimc.operation.domain.dto.DoRequestDto;
import cn.com.yusys.yscimc.operation.domain.dto.Sign;
import cn.com.yusys.yscimc.operation.support.DateUtil;
import cn.com.yusys.yscimc.operation.support.SignValueUtils;
import cn.com.yusys.yscimc.operation.support.SpringBootBeanUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.support.AopUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

/**
 * 对外统一接口
 * @author zhangyt12
 * @date 2022/1/11 11:12
 */
@RestController
@RequestMapping("/api/trans")
@Validated
public class TransUnifyInterfaceController {

    private static final Logger log = LoggerFactory.getLogger(TransUnifyInterfaceController.class);

    private final SignValueUtils signValueUtils;

    public TransUnifyInterfaceController(SignValueUtils signValueUtils) {
        this.signValueUtils = signValueUtils;
    }

    @RequestMapping(value = "/doRequest", method = RequestMethod.POST)
    public DoRequestDto operateInfo(@RequestBody @NotNull DoRequestDto doRequestDto) throws Exception {

        String data;

        try {
            if (null == doRequestDto || StringUtils.isEmpty(doRequestDto.getData())) {
                log.error("请求报文为空");
                data = createErrorData("-1", "-1", ChannelErrorCodeEnum.PARAMS_NULL.getCode());
                return createReturnVo(data);
            }

            Gson gson = new GsonBuilder()
                    .setDateFormat("yyyy-MM-dd HH:mm:ss")
                    .serializeNulls()
                    .create();
            HashMap<String, Object> reqData = gson.fromJson(doRequestDto.getData(), HashMap.class);
//            String interfaceSerialNo = StringUtils.getUUID();
//            reqData.put("interfaceSerialNo", interfaceSerialNo);

            //验签
//			boolean signCheck = signValueUtils.checkSignValue(doRequestDto.getSign().getSignValue(), doRequestDto.getData());
            boolean signCheck = true;

            if (!signCheck) {
                data = createErrorData("-1", "-1", ChannelErrorCodeEnum.SIGN_FAIL.getCode());
                String reqSignValue = signValueUtils.getSignValue(doRequestDto.getData());
                DoRequestDto reqVo = createReturnVo(data);
                reqVo.setReqSignValue(reqSignValue);
                return reqVo;
            }

            //参数检查
            String checkParam = verifyRequestField(reqData);
            if (StringUtils.isEmpty(checkParam)) {
                data = createErrorData(reqData.get("trans_Code").toString(), reqData.get("channel_Code").toString(), checkParam);
                return createReturnVo(data);
            }

            //通过反射调用的方式发起跳转
            String transcode = reqData.get("trans_Code").toString();
            String tName = TransCodeAndInterface.getTypeByCode(transcode).getInterfaceName();
            String methodName = TransCodeAndInterface.getTypeByCode(transcode).getMethod();
            Object cls = SpringBootBeanUtil.getBean(tName);

            // 获取代理对象中的目标对象
            Class target = AopUtils.getTargetClass(cls);
            // 获取目标对象的方法，为什么获取目标对象的方法：只有目标对象才能通过 DefaultParameterNameDiscoverer 获取参数的方法名，代理对象由于可能被JDK或CGLIB代理导致获取不到参数名
            Method targetMethod = SpringBootBeanUtil.getMethod(target, methodName);
            //跳转返回结果
            Object actionResult = targetMethod.invoke(SpringBootBeanUtil.getBean(tName), doRequestDto.getData());
            if (actionResult == null) {
                return createReturnVo("success");
            }
            return createReturnVo(gson.toJson(actionResult));
        } catch (Exception ex) {
            log.error("请求出错：{}", ex.getMessage(), ex);
            data = createErrorData("-1", "-1", ChannelErrorCodeEnum.ERROR.getCode());
            return createReturnVo(data);
        }
    }

    /**
     * 必输项验证
     *
     * @param data
     * @return
     */
    public String verifyRequestField(Map<String, Object> data) {
        //交易码
        if (null == data.get("transCode") || data.get("transCode").equals("")) {
            return ChannelErrorCodeEnum.TRANSCODE_NULL.getCode();
        }
        //交易渠道
        if (null == data.get("channelCode") || data.get("channelCode").equals("")) {
            return ChannelErrorCodeEnum.CHNLCODE_NULL.getCode();
        }

        ChannelCodeEnum channel = ChannelCodeEnum.getByCode(data.get("channelCode").toString());
        if (channel == null) {
            return ChannelErrorCodeEnum.CHNLCODE_ERR.getCode();
        }

        try {
            TransCodeAndInterface.getTypeByCode("transCode");
        } catch (Exception e) {
            return ChannelErrorCodeEnum.TRANSCODE_ERR.getCode();
        }

        //请求时间校验
        if (null == data.get("reqTime") || data.get("reqTime").equals("")) {
            return ChannelErrorCodeEnum.REQ_TIME_NULL.getCode();
        }
        if (!DateUtil.isValidDate(data.get("reqTime").toString())) {
             return ChannelErrorCodeEnum.REQ_TIME_ERR.getCode();
        }
        return null;
    }

    private String createErrorData(String transcode, String chnlCode, String errorCode) throws JsonProcessingException {
        Map<String, Object> info = new HashMap<>();
        info.put(InterfaceConstants.HEAD_TRANSCODE, transcode);
        info.put(InterfaceConstants.HEAD_CHNL_CODE, chnlCode);
        info.put(InterfaceConstants.HEAD_BACK_TIME, LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        info.put(InterfaceConstants.HEAD_ERROR_CODE, !StringUtils.isEmpty(errorCode) ? errorCode : ChannelErrorCodeEnum.SUCCESS.getCode());
        info.put(InterfaceConstants.HEAD_ERROR_INFO, ChannelErrorCodeEnum.getTypeByCode(errorCode, "language?"));
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(info);
    }


    private DoRequestDto createReturnVo(String data) throws Exception {
        String signValue = signValueUtils.getSignValue(data);
        DoRequestDto vo = new DoRequestDto();
        vo.setData(data);
        Sign sign = new Sign();
        sign.setSignType("1");
        sign.setSignValue(signValue);
        vo.setSign(sign);
        return vo;
    }
}