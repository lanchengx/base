package com.example.service.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.dao.user.UUserDao;
import com.example.model.user.UUser;
import com.example.service.user.service.UUserService;
import org.springframework.stereotype.Service;

/**
 * 用户表(UUser)表服务实现类
 *
 * @author lanchengx
 * @since 2020-07-25 17:25:33
 */
@Service
public class UUserServiceImpl extends ServiceImpl<UUserDao, UUser> implements UUserService {

}