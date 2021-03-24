package com.honeysense.magpie.common.exception;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

/**
 * 统一内部异常
 */
@Getter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class MagpieException extends RuntimeException {
    public MagpieException(String message) {
        super(message);
    }

    @JsonIgnore
    @Override
    public String getLocalizedMessage() {
        return super.getLocalizedMessage();
    }

    @JsonIgnore
    @Override
    public StackTraceElement[] getStackTrace() {
        return super.getStackTrace();
    }

    @JsonIgnore
    @Override
    public synchronized Throwable getCause() {
        return super.getCause();
    }

    public static void triggerParseFailed() {
//        throw new SpiderException("parse failed");
    }
}
