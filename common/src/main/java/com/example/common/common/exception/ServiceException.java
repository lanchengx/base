package com.example.common.common.exception;

import com.example.common.common.enums.ResponseCodeEnum;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Objects;

/**
 * @author
 */
public class ServiceException extends RuntimeException {

    private Log log =      LogFactory.getLog(ServiceException.class);
    private Integer           code;
    private String            message;
    private Throwable         throwable;

    public ServiceException(String message) {
        super(message);
        this.setCode(ResponseCodeEnum.FAILED.getCode());
        this.setMessage(message);
    }

    public ServiceException(Integer code, String message) {
        super(message);
        this.setCode(code);
        this.setMessage(message);
    }

    public ServiceException(Throwable throwable) {
        super(throwable);
        this.throwable = throwable;
        this.message = throwable.getMessage();
        this.setCode(ResponseCodeEnum.FAILED.getCode());
    }

    public ServiceException(Integer code, Throwable throwable) {
        super(throwable);
        this.setCode(code);
        this.throwable = throwable;
        this.message = throwable.getMessage();
    }

    public ServiceException(String message, Throwable throwable) {
        super(message, throwable);
        this.setCode(ResponseCodeEnum.FAILED.getCode());
    }

    public ServiceException(Integer code, String message, Throwable throwable) {
        super(message, throwable);
        this.setCode(code);
        this.setMessage(message);
    }


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}