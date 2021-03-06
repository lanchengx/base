package com.example.model.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;


/**
 * 用户表(UUser)表实体类
 *
 * @author lanchengx
 * @since 2020-07-25 17:19:09
 */

@Getter
@Setter
@Accessors(chain = true)
@ApiModel("用户表_条件对象")
public class UUserParams implements Serializable  {

    private static final long serialVersionUID = 486297600294358217L;

    @ApiModelProperty("id")
    @NotNull(message = "用户id不能为空")
    private Integer id;
    
    @ApiModelProperty("账户")
    @NotNull(message = "用户账号不能为空")
    @Size(min = 6, max = 11, message = "账号长度必须是6-11个字符")
    private String account;  
    
    @ApiModelProperty("密码")
    @NotNull(message = "用户密码不能为空")
    @Size(min = 6, max = 11, message = "密码长度必须是6-16个字符")
    private String password;  
    
    @ApiModelProperty("邮箱")
    @NotNull(message = "用户邮箱不能为空")
    @Email(message = "邮箱格式不正确")
    private String email;  
    

   

}