package com.bin_bx.mybatis_plus;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bin_bx.mybatis_plus.mapper.ProductMapper;
import com.bin_bx.mybatis_plus.mapper.UserMapper;
import com.bin_bx.mybatis_plus.pojo.Product;
import com.bin_bx.mybatis_plus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description: 分页插件测试
 * @ClassName: MyBatisPlusPluginsTest
 * @Author: bxie
 * @Date: 2022/3/7
 */
@SpringBootTest
public class MyBatisPlusPluginsTest {

    @Resource
    private UserMapper userMapper;
    @Resource
    private ProductMapper productMapper;

    //SELECT uid AS id,user_name AS name,age,email,is_deleted FROM t_user WHERE is_deleted=0 LIMIT ?,?
    @Test
    public void testPage(){
        //设置分页参数
        Page<User> page = new Page<>(1, 2);
        userMapper.selectPage(page, null);
        //获取分页数据
        List<User> list = page.getRecords();
        list.forEach(System.out::println);
        System.out.println("当前页："+page.getCurrent());
        System.out.println("每页显示的条数："+page.getSize());
        System.out.println("总记录数："+page.getTotal());
        System.out.println("总页数："+page.getPages());
        System.out.println("是否有上一页："+page.hasPrevious());
        System.out.println("是否有下一页："+page.hasNext());
    }

    //select uid,user_name,age,email from t_user where age > ? LIMIT ?
    @Test
    public void testPageVo(){
        //设置分页参数
        Page<User> page = new Page<>(1, 2);
        userMapper.selectPageVo(page, 20);
        //获取分页数据
        List<User> list = page.getRecords();
        list.forEach(System.out::println);
        System.out.println("当前页："+page.getCurrent());
        System.out.println("每页显示的条数："+page.getSize());
        System.out.println("总记录数："+page.getTotal());
        System.out.println("总页数："+page.getPages());
        System.out.println("是否有上一页："+page.hasPrevious());
        System.out.println("是否有下一页："+page.hasNext());
    }

    //乐观锁
    @Test
    public void testProduct01(){
        //1、小李查询商品价格
        Product productLi = productMapper.selectById(1L);
        System.out.println("小李查询的商品价格："+productLi.getPrice());

        //2、小王查询商品价格
        Product productWang = productMapper.selectById(1L);
        System.out.println("小王查询的商品价格："+ productWang.getPrice());

        //3、小李将商品价格加了50元，存入了数据库
        productLi.setPrice(productLi.getPrice()+50);
        int result1 = productMapper.updateById(productLi);
        System.out.println("小李修改结果：" + result1);

        //4、小王将商品减了30元，存入了数据库
        productWang.setPrice(productWang.getPrice()-30);
        int result2 = productMapper.updateById(productWang);
        System.out.println("小王修改结果：" + result2);
        if(result2 == 0){
            //操作失败，重试
            Product productNew = productMapper.selectById(1);
            productNew.setPrice(productNew.getPrice()-30);
            productMapper.updateById(productNew);
        }

        // 最后的结果，老板查询商品价格  价格覆盖，最后的结果：70
        Product productLaoban = productMapper.selectById(1);
        System.out.println("老板查询的商品价格："+productLaoban.getPrice());
    }
}
