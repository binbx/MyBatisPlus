package com.bin_bx.mybatis_plus;

import com.bin_bx.mybatis_plus.mapper.UserMapper;
import com.bin_bx.mybatis_plus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @ClassName: MyBatisPlusTest
 * @Author: bxie
 * @Date: 2022/3/6
 */
@SpringBootTest
public class MyBatisPlusTest {

    @Resource //@Autowired
    private UserMapper userMapper;

    //查询所有数据
    @Test
    public void testSelectList(){
        //通过条件构造器查询一个list集合，若没有条件，则可以设置null为参数
        List<User> list = userMapper.selectList(null);
        list.forEach(System.out::println);
    }

    //添加
    @Test
    public void testInsert(){
        User user = new User();
        user.setName("张三");
        user.setAge(23);
        user.setEmail("zhangsan@agg.com");
        userMapper.insert(user);
        System.out.println("id： " + user.getId());  //获取主键id
    }


    //删除
    @Test
    public void testDelete(){
        //根据id删除
//        userMapper.deleteById(1500449270128443393L); //超过int范围，加L表示lang类型数据

        //根据Map集合中所设置的条件来进行删除 //DELETE FROM user WHERE name = ? AND age = ?
//        Map<String, Object> map = new HashMap<>();
//        map.put("name","张三");
//        map.put("age",23);
//        userMapper.deleteByMap(map);

        //通过多个id实现批量删除  //DELETE FROM user WHERE id IN ( ? , ? , ? )
        List<Long> list = Arrays.asList(1L, 2L, 3L);
        int result = userMapper.deleteBatchIds(list);
        System.out.println("result: "+result);
    }

    //修改
    @Test
    public void testUpdate(){
        //根据id来进行修改
        User user = new User();
        user.setId(4L);
        user.setName("李四");
        user.setEmail("lisi@agg.com");
        userMapper.updateById(user);
    }

    //查询
    @Test
    public void testSelect(){
        //根据id查询用户信息  //SELECT id,name,age,email FROM user WHERE id=?
//        User user = userMapper.selectById(1L);
//        System.out.println(user);

        //根据多个id查询多个用户信息  //SELECT id,name,age,email FROM user WHERE id IN ( ? , ? , ? )
//        List<Long> list = Arrays.asList(1L, 2L, 3L);
//        List<User> users = userMapper.selectBatchIds(list);
//        users.forEach(System.out::println);

        //根据map集合中的条件查询用户信息  //SELECT id,name,age,email FROM user WHERE name = ? AND age = ?
//        Map<String, Object> map = new HashMap<>();
//        map.put("name", "Jack");
//        map.put("age", 20);
//        List<User> users = userMapper.selectByMap(map);
//        users.forEach(System.out::println);

        //查询所有数据  //SELECT id,name,age,email FROM user
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);

//        Map<String, Object> map = userMapper.selectMapById(1L);
//        System.out.println(map);
    }

}
