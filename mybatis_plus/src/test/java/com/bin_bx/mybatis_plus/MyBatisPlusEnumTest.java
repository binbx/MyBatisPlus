package com.bin_bx.mybatis_plus;

import com.bin_bx.mybatis_plus.enums.SexEnum;
import com.bin_bx.mybatis_plus.mapper.UserMapper;
import com.bin_bx.mybatis_plus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @Description: 测试枚举类型
 * @ClassName: MyBatisPlusEnumTest
 * @Author: bxie
 * @Date: 2022/3/7
 */
@SpringBootTest
public class MyBatisPlusEnumTest {

    @Resource
    private UserMapper userMapper;

    //添加一条数据
    //INSERT INTO t_user ( user_name, age, sex ) VALUES ( ?, ?, ? )
    @Test
    public void test(){
        User user = new User();
        user.setName("admin");
        user.setAge(33);
        user.setSex(SexEnum.MALE);
        int result = userMapper.insert(user);
        System.out.println("result:"+result);
    }
}
