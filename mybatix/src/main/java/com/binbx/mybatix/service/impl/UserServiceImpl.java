package com.binbx.mybatix.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.binbx.mybatix.pojo.User;
import com.binbx.mybatix.service.UserService;
import com.binbx.mybatix.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author bxie
* @description 针对表【t_user】的数据库操作Service实现
* @createDate 2022-03-07 22:20:50
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




