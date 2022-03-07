package com.bin_bx.mybatis_plus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bin_bx.mybatis_plus.mapper.UserMapper;
import com.bin_bx.mybatis_plus.pojo.User;
import com.bin_bx.mybatis_plus.service.UserService;
import org.springframework.stereotype.Service;

/**
 * ServiceImpl实现了IService，提供了IService中基础功能的实现
 * 若ServiceImpl无法满足业务需求，则可以使用自定的UserService定义方法，并在实现类中实现
 *          其中第一个参数是当前要操作mapper接口的类型 UserMapper
 *              第二个参数是当前要操作的实体类的类型User
 *
 * @ClassName: UserServiceImpl
 * @Author: bxie
 * @Date: 2022/3/6
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {


}
