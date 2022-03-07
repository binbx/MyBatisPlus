package com.bin_bx.mybatis_plus;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

/**
 * @Description: MyBatis Plus代码生成器
 * @ClassName: FastAutoGeneratorTest
 * @Author: bxie
 * @Date: 2022/3/7
 */
public class FastAutoGeneratorTest {
    public static void main(String[] args) {

        FastAutoGenerator.create("jdbc:mysql://47.99.81.201:3306/mybatis_plus", "root", "root")
                .globalConfig(builder -> {
                    builder.author("bin_bx") // 设置作者
//                            .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .outputDir("E://mybatis_plus"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.bin_bx") // 设置父包名
                            .moduleName("mybatis_plus") // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml, "E://mybatis_plus")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("t_user") // 设置需要生成的表名
                            .addTablePrefix("t_", "c_"); // 设置过滤表前缀
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();

    }
}
