package com.example.web.user.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.model.user.UUser;
import com.example.service.user.service.UUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 用户表(UUser)表控制层
 *
 * @author lanchengx
 * @since 2020-07-25 17:29:04
 */
@Api(tags = "用户表_控制层")
@RestController
@RequestMapping("uUser")
public class UUserController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private UUserService uUserService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param uUser 查询实体
     * @return 所有数据
     */
    @GetMapping
    @ApiOperation("分页查询所有数据")
    public R selectAll(Page<UUser> page, UUser uUser) {
        return success(this.uUserService.page(page, new QueryWrapper<>(uUser)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    @ApiOperation("通过主键查询单条数据")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.uUserService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param uUser 实体对象
     * @return 新增结果
     */
    @PostMapping
    @ApiOperation("新增数据")
    public R insert(@RequestBody UUser uUser) {
        return success(this.uUserService.save(uUser));
    }

    /**
     * 修改数据
     *
     * @param uUser 实体对象
     * @return 修改结果
     */
    @PutMapping
    @ApiOperation("修改数据")
    public R update(@RequestBody UUser uUser) {
        return success(this.uUserService.updateById(uUser));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    @ApiOperation("删除数据")
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.uUserService.removeByIds(idList));
    }
}