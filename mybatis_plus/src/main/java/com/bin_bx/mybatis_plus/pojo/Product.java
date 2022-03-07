package com.bin_bx.mybatis_plus.pojo;

import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

/**
 * @Description:
 * @ClassName: Product
 * @Author: bxie
 * @Date: 2022/3/6
 */
@Data
public class Product {

    private Long id;
    private String name;
    private Integer price;
    @Version //标识乐观锁版本号字段
    private Integer version;
}
