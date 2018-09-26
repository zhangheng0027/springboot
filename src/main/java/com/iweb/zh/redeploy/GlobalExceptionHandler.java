package com.iweb.zh.redeploy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.iweb.zh.model.JsonResult;


/**
 * 
 * @author ZH
 * 对异常进行拦截 处理
 *
 */
@SuppressWarnings("rawtypes")
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

	
	private final static Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
	
	@ExceptionHandler(MissingServletRequestParameterException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public JsonResult handleHttpMessageNotReadableException(
	    MissingServletRequestParameterException ex) {
	    logger.error("缺少请求参数，{}", ex.getMessage());
	    return new JsonResult("501", "缺少必要的请求参数");
	}
	
	
	@ExceptionHandler(NullPointerException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public JsonResult handleTypeMismatchException(NullPointerException ex) {
        logger.error("空指针异常，{}", ex.getMessage());
        return new JsonResult("502", "空指针异常了");
    }
	
	
	
	
	@ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public JsonResult handleUnexpectedServer(Exception ex) {
        logger.error("系统异常：", ex);
        return new JsonResult("500", "系统发生异常，请联系管理员");
    }
}
