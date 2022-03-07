package com.binbx.mybatisplus.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.binbx.mybatisplus.mapper.UserMapper;
import com.binbx.mybatisplus.pojo.User;
import com.binbx.mybatisplus.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @ClassName: UserServiceImpl
 * @Author: bxie
 * @Date: 2022/3/7
 */
@Service
@DS("master")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
