package com.example.web.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author
 * @description swagger配置类
 */
@Configuration
@EnableSwagger2
@EnableKnife4j
@Import(BeanValidatorPluginsConfiguration.class)
public class SwaggerConfig {
    /**
     * 是否启用swagger文档
     */
    @Value("${swagger.enable}")
    private boolean enable;

    @Bean
    public Docket apiDocket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .enable(enable)
                .apiInfo(apiInfo())
                .select()
                // 这里配置要扫描的包,接口在哪个包就配置哪个包
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build();
    }
//    @Bean
//    public Docket modelDocket(){
//        return new Docket(DocumentationType.SWAGGER_2)
//                .enable(enable)
//                .groupName("model")
//                .apiInfo(apiInfo())
//                .select()
//                // 这里配置要扫描的包,接口在哪个包就配置哪个包
//                .apis(RequestHandlerSelectors.withClassAnnotation(ApiModel.class))
//                .paths(PathSelectors.any())
//                .build();
//    }


    public ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("参数校验和统一异常处理Demo")
                .description("用来演示参数校验和统一异常处理")
//                .termsOfServiceUrl("rudecrab.com")
                .contact(new Contact("RudeCrab", "", "rudecrab@foxmail.com"))
                .version("1.0")
                .build();
    }
}
