package com.javacode.springboot_program.exception;

import com.javacode.springboot_program.utils.JsonData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 异常处理器
 *
 * @author shkstart
 * @create 2022-01-08 16:40
 */
@RestControllerAdvice
public class CustomExceptionHandler {
    private final static Logger log = LoggerFactory.getLogger(CustomExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public JsonData error(Exception e) {
        log.error("【也可以记录一下日志信息：全局异常日志记录】"+e.getMessage());
        if (e instanceof ExceptionClass) {
            ExceptionClass exceptionClass = (ExceptionClass) e;
            return JsonData.buildErroe(exceptionClass.getCode(), exceptionClass.getMsg());
        } else {
            return JsonData.buildErroe("全局异常通知：未知异常");
        }
    }
}
