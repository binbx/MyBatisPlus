package com.binbx.mybatisplus.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.binbx.mybatisplus.mapper.ProductMapper;
import com.binbx.mybatisplus.pojo.Product;
import com.binbx.mybatisplus.service.ProductService;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @ClassName: ProductServiceImpl
 * @Author: bxie
 * @Date: 2022/3/7
 */
@Service
@DS("slave_1")
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {
}
