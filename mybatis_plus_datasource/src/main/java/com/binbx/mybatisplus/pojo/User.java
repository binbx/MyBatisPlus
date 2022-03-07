package com.binbx.mybatisplus.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Description:
 * @ClassName: User
 * @Author: bxie
 * @Date: 2022/3/7
 */
@Data
@TableName("t_user") //指定当前操作表的名字
public class User {

    @TableId  //指定当前主键
    private Integer uid;

    private String userName;

    private Integer age;

    private Integer sex;

    private String email;

    private Integer isDeleted;
}
