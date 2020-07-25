package com.example.web.user.controller;

import com.example.common.common.base.model.ResultModel;
import com.example.model.user.UUser;
import com.example.service.user.service.UUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author
 * @description 用户接口
 */
@RestController
@Api(tags = "用户接口")
@RequestMapping("user")
public class DemoController {
    @Autowired
    private UUserService userService;

    @ApiOperation("添加用户")
    @PostMapping("/addUser")
    public UUser addUser(@RequestBody @Valid UUser user) {
        userService.save(user);
        return user;
    }

    @ApiOperation("获得单个用户")
    @GetMapping("/getUser")
    public UUser getUser() {
        UUser user = new UUser();
        user.setId(1);
        user.setAccount("12345678");
        user.setPassword("12345678");
        user.setEmail("123@qq.com");
        return user;
    }
    @ApiOperation("获得单个用户")
    @GetMapping("/getUser_1")
    public ResultModel getUser_1() {
        UUser user = new UUser();
        user.setId(1);
        user.setAccount("12345678");
        user.setPassword("12345678");
        user.setEmail("123@qq.com");
        return ResultModel.ok(user);
    }

}
