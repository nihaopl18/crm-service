package com.yusys.streaminghub.app.result;

public class SignException extends RuntimeException{

    /**
     * 错误码
     */
    private String code;

    /**
     * 错误信息
     */
    private String message;


    public SignException(String cause) {
        super(ResultCode.USER_SIGN_CHECK.message());
        this.code = ResultCode.USER_SIGN_CHECK.code();
        this.message = String.format("%s。%s",ResultCode.USER_SIGN_CHECK.message(), cause);
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
