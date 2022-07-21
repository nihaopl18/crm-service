//package cn.com.yusys.yusp.admin.aop;
//
//import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
//import cn.com.yusys.yusp.commons.web.rest.exception.YuspException;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.dao.ConcurrencyFailureException;
//import org.springframework.dao.DuplicateKeyException;
//import org.springframework.http.HttpStatus;
//import org.springframework.jdbc.BadSqlGrammarException;
//import org.springframework.validation.FieldError;
//import org.springframework.web.HttpRequestMethodNotSupportedException;
//import org.springframework.web.bind.MethodArgumentNotValidException;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.ResponseStatus;
//
//import java.util.List;
//
//@ControllerAdvice
//public class CustomizedExceptionTranslator {
//    private final Logger logger = LoggerFactory.getLogger(CustomizedExceptionTranslator.class);
//
//    /**
//     * @方法名称: handlerMyException
//     * @方法描述: 拦截SpringMvc有效性校验
//     * @参数与返回说明:
//     * @算法描述:
//     */
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    @ResponseStatus(HttpStatus.OK)
//    @ResponseBody
//    public ResultDto handlerMyException(MethodArgumentNotValidException ex) {
//        logger.error("MethodArgumentNotValidException ，Message:{}", ex.getMessage());
//        List<FieldError> errors = ex.getBindingResult().getFieldErrors();
//        StringBuilder message = new StringBuilder();
//        for (FieldError error : errors) {
//            message.append(error.getField() + ":" + error.getDefaultMessage() + "  ");
//        }
//
////        ResultDto dto = new ResultDto(503, message.toString(),
////                MessageConstans.MSG_LEVEL_ERROR);
//        ResultDto dto = new ResultDto();
//        dto.setCode(503);
//        dto.setMessage(message.toString());
//        return dto;
//    }
//
//    @ExceptionHandler(ConcurrencyFailureException.class)
//    @ResponseStatus(HttpStatus.CONFLICT)
//    @ResponseBody
//    public ResultDto processConcurrencyError(ConcurrencyFailureException ex) {
//        return new ResultDto();
//    }
//
//    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
//    @ResponseBody
//    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
//    public ResultDto processMethodNotSupportedException(HttpRequestMethodNotSupportedException ex) {
//        return new ResultDto();
//    }
//
//    /**
//     * @方法名称: processBusiException
//     * @方法描述: 拦截自定义业务异常
//     * @参数与返回说明:
//     * @算法描述:
//     */
//    @SuppressWarnings("unchecked")
//    @ExceptionHandler(YuspException.class)
//    @ResponseStatus(HttpStatus.OK)
//    @ResponseBody
//    public ResultDto processBusiException(YuspException ex) {
//        ResultDto dto = new ResultDto();
//
////        if (StringUtil.isNumeric(ex.getCode())) {
////            dto = new ResultDto(Integer.parseInt(ex.getCode()), ex.getMsg(), ex.getLevel());
////        } else {
////            dto = new ResultDto(MessageConstants.RET_CODE_INTERNAL_SERVER_ERROR, "[" + ex.getCode() + "]" + ex.getMsg(),
////                    ex.getLevel());
////        }
//        return dto;
//    }
//
//    /**
//     * @方法名称: processBusiException
//     * @方法描述: 唯一索引异常拦截
//     * @参数与返回说明:
//     * @算法描述:
//     */
//    @ExceptionHandler(DuplicateKeyException.class)
//    @ResponseStatus(HttpStatus.OK)
//    @ResponseBody
//    public ResultDto processPkError(DuplicateKeyException ex) {
//        logger.error("DuplicateKeyException Advice，Message:{}", ex.getMessage());
//        ResultDto dto = new ResultDto();
//        return dto;
//    }
//
//    @ExceptionHandler(Exception.class)
//    @ResponseBody
//    public ResultDto processRuntimeException(Exception ex) {
//        logger.error("Exception Advice，Code:{}，Message:{}", HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
//        ResultDto errorDto = new ResultDto();
//        return errorDto;
//    }
//
//    @ExceptionHandler(BadSqlGrammarException.class)
//    @ResponseBody
//    public ResultDto badSqlGrammarExceptionHandler(Exception ex) {
//        logger.error("Exception Advice，Code:{}，Message:{}", HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
//        ResultDto errorDto = new ResultDto();
//        return errorDto;
//    }
//}
