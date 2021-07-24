package com.mall.mallfirstedtion.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author wangzhe
 * @ClassName Swagger2Config
 * @create 2021-07-23 15:57
 * @description
 * @Api 用于修饰Controller类，生成Controller相关文档信息
 * @ApiOperation 用于修饰Controller类中的方法，生成接口方法相关文档信息
 * @ApiParam 用于修饰接口中的参数，生成接口参数相关文档信息
 * @ApiModelProperty 用于修饰实体类的属性，当实体类是请求参数或返回结果时，直接生成相关文档信息
 * @ApiIgnore 忽略某类/某方法/参数的文档
 * @Version 1.0
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {
    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2).
                apiInfo(apiinfo()).
                //通过select()函数返回一个ApiSelectorBuilder实例,用来控制哪些接口暴露swagger来展现
                select()
                //为当前包下的controller生成API文档
                .apis(RequestHandlerSelectors.basePackage("com.mall.mallfirstedtion.controller"))
                //为有@Api注解的Controller生成API文档
//                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                //为有@ApiOperation注解的方法生成API文档
//                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any()).build();
    }
/**
 * 展示该api的基本信息
 * @Date 16:13 2021/7/23
 *@return  springfox.documentation.service.ApiInfo
 **/
    private ApiInfo apiinfo() {
        return new ApiInfoBuilder()
                .title("SwaggerUI演示")
                .description("firstmall")
                //.contact("com")
                //.version("1.0")
                //.build();
        .contact(new Contact("macro",null,null))
                .version("1.0")
                .build();
    }

}
