package com.bin_bx.mybatis_plus.pojo;

import com.baomidou.mybatisplus.annotation.*;
import com.bin_bx.mybatis_plus.enums.SexEnum;
import lombok.Data;

/**
 * @Description:
 * @ClassName: User
 * @Author: bxie
 * @Date: 2022/3/6
 */
@Data
//@TableName("t_user") //设置实体类所对应的表名
public class User {

    /**
     * @TableId:将属性所对应的字段指定为主键
     *     @TableId注解的value属性: 用于指定主键的字段
     *     @TableId注解的type属性: 设置主键生成策略
     */
    //@TableId(value = "uid", type = IdType.AUTO)
    @TableId("uid")
    private Long id;

    //指定属性所对应的字段名
    @TableField("user_name")
    private String name;

    private Integer age;

    private String email;

    private SexEnum sex;

    @TableLogic  //表示当前逻辑删除的字段
    private Integer isDeleted;
}
