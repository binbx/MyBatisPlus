package com.binbx.mybatisplus.pojo;

import lombok.Data;

/**
 * @Description:
 * @ClassName: Product
 * @Author: bxie
 * @Date: 2022/3/7
 */
@Data
public class Product {

    private Integer id;

    private String name;

    private Integer price;

    private Integer version;
}
