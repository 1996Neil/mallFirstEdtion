package com.mall.mallfirstedtion.config;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author wangzhe
 * @ClassName MybatisConfig
 * @create 2021-07-17 11:50
 * @description 用于配置动态生成的mapper接口
 * @Version 1.0
 */
@Configuration
@MapperScan("com.mall.mallfirstedtion.mbg.mapper")
public class MybatisConfig {
}
