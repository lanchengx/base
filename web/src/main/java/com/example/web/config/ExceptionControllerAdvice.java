package com.example.web.config;

import com.example.common.common.base.model.ResultModel;
import com.example.common.common.enums.ResponseCodeEnum;
import com.example.common.common.exception.ServiceException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author
 * @description 全局异常处理
 */
@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(ServiceException.class)
    public ResultModel<String> ServiceExceptionHandler(ServiceException e) {
        return  ResultModel.fail(e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResultModel<String> MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        // 从异常对象中拿到ObjectError对象
        ObjectError objectError = e.getBindingResult().getAllErrors().get(0);
        // 然后提取错误提示信息进行返回
        return new ResultModel(ResponseCodeEnum.ILLEGAL_ARGUMENT, objectError.getDefaultMessage());
    }

}
