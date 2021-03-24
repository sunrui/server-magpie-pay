package com.honeysense.magpie.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 通用异常捕获
 */
@ControllerAdvice
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class GlobalExceptionHandler {
    @ExceptionHandler(MagpieException.class)
    @ResponseBody
    public MagpieException statExceptionHandler(MagpieException e) {
        e.printStackTrace();
        return e;
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public MagpieException defaultExceptionHandler(Exception e) {
        e.printStackTrace();
        return new MagpieException(e.getMessage());
    }
}
