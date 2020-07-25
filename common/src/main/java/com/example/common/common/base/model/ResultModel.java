package com.example.common.common.base.model;


import com.example.common.common.enums.ResponseCodeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 自定义返回结果
 * 
 * @author
 * @date 2015/7/14.
 */
@Data
@ApiModel("响应结果对象")
public class ResultModel<T> {

	@ApiModelProperty(value = "状态码", notes = "默认100是成功")
	private int code;


	@ApiModelProperty(value = "响应信息", notes = "来说明响应情况")
	private String message;


	@ApiModelProperty(value = "响应的具体数据")
	private T content;


	public ResultModel() {

	}

	public ResultModel(int code, String msg) {
		this.code = code;
		this.message = msg;
	}

	public ResultModel(int code, String msg, T content) {
		this.code = code;
		this.message = msg;
		this.content = content;
	}

	public ResultModel(ResponseCodeEnum codeEnum) {
		this.code = codeEnum.getCode();
		this.message = codeEnum.getMsg();
	}

	public ResultModel(ResponseCodeEnum codeEnum, T content) {
		this.code = codeEnum.getCode();
		this.message = codeEnum.getMsg();
		this.content = content;
	}

	public static ResultModel ok() {
		return new ResultModel(ResponseCodeEnum.SUCCESS);
	}

	public static ResultModel ok(Object content) {
		return new ResultModel(ResponseCodeEnum.SUCCESS, content);
	}

	public static ResultModel fail(int code, String message) {
		return new ResultModel(code, message);
	}

	public static ResultModel fail(String message) {
		return new ResultModel(ResponseCodeEnum.FAILED.getCode(), message);
	}


}
