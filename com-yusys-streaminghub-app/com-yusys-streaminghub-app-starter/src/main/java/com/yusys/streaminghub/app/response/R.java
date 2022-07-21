package com.yusys.streaminghub.app.response;

import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import com.yusys.streaminghub.app.result.ResultCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.util.StringUtils;

import java.io.Serializable;

@ApiModel(value = "返回结果实体类", description = "结果实体类")
public class R implements Serializable {

  private static final long serialVersionUID = 1L;

  @ApiModelProperty(value = "返回码")
  private String code;

  @ApiModelProperty(value = "返回消息")
  private String message;
  @ApiModelProperty(value = "数据如果是列表，则表示数目")
  private long total;
  @ApiModelProperty(value = "返回数据")
  private Object data;

  private R() {

  }

  public R(ResultCode resultCode, Object data) {
    this.code = resultCode.code();
    this.message = resultCode.message();
    this.data = data;
  }

  private void setResultCode(ResultCode resultCode) {
    this.code = resultCode.code();
    this.message = resultCode.message();
  }

  // 返回成功
  public static R success() {
    R result = new R();
    result.setResultCode(ResultCode.SUCCESS);
    return result;
  }
  // 返回成功
  public static R success(Object data) {
    R result = new R();
    result.setResultCode(ResultCode.SUCCESS);
    result.setData(data);
    return result;
  }
  // 返回成功
  public static R successCRM(ResultDto dto) {
    R result = new R();
    result.setResultCode(StringUtils.isEmpty(dto.getCode())?ResultCode.SUCCESS:ResultCode.SYSTEM_CRM_ERROR);
    result.setData(dto.getData());
    result.setTotal(dto.getTotal());
    result.setMessage(StringUtils.isEmpty(dto.getMessage())?ResultCode.SUCCESS.message():dto.getMessage());
    return result;
  }
  // 返回失败
  public static R fail(String code, String message) {
    R result = new R();
    result.setCode(code);
    result.setMessage(message);
    return result;
  }
  // 返回失败
  public static R fail(String code, String message,String exception) {
    R result = new R();
    result.setCode(code);
    result.setMessage(message);
    result.setData(exception);
    return result;
  }
  // 返回失败
  public static R fail(ResultCode resultCode) {
    R result = new R();
    result.setResultCode(resultCode);
    return result;
  }

  public long getTotal() {
    return total;
  }

  public void setTotal(long total) {
    this.total = total;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Object getData() {
    return data;
  }

  public void setData(Object data) {
    this.data = data;
  }
}
