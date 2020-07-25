package com.example.common.common.enums;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

/**
 * @author
 * @description 响应码枚举
 */
@Getter
public enum ResponseCodeEnum {

    SUCCESS(100, "操作成功"),

    FAILED(90, "操作失败"),

    ILLEGAL_ARGUMENT(91, "请求参数错误!"),

    NEED_LOGIN(92, "登录超时,请重新登录!"),

    DATABASE_ERROR(93,"数据库异常,请稍后重试!"),

    ERROR(94, "未知错误");

    private int code;
    private String msg;

    ResponseCodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
