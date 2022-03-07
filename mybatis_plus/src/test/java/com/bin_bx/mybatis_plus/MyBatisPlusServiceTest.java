package com.bin_bx.mybatis_plus;

import com.bin_bx.mybatis_plus.pojo.User;
import com.bin_bx.mybatis_plus.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @ClassName: MyBatisPlusServiceTest
 * @Author: bxie
 * @Date: 2022/3/6
 */
@SpringBootTest
public class MyBatisPlusServiceTest {

    @Resource
    private UserService userService;

    //查询总记录数  //SELECT COUNT( * ) FROM user
    @Test
    public void testGetCount(){
        long count = userService.count();
        System.out.println("总记录数：" + count);
    }

    //批量添加  //INSERT INTO user ( id, name, age ) VALUES ( ?, ?, ? )
    @Test
    public void testInsertMore(){
        List<User> list = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            User user = new User();
            user.setName("ybc"+i);
            user.setAge(20+i);
            list.add(user);
        }
        boolean b = userService.saveBatch(list);
        System.out.println(b);
    }
}
