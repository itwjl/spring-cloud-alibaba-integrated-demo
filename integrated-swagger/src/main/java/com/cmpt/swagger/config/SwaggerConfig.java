package com.cmpt.swagger.config;

import org.springframework.boot.actuate.autoconfigure.endpoint.web.CorsEndpointProperties;
import org.springframework.boot.actuate.autoconfigure.endpoint.web.WebEndpointProperties;
import org.springframework.boot.actuate.autoconfigure.web.server.ManagementPortType;
import org.springframework.boot.actuate.endpoint.ExposableEndpoint;
import org.springframework.boot.actuate.endpoint.web.*;
import org.springframework.boot.actuate.endpoint.web.annotation.ControllerEndpointsSupplier;
import org.springframework.boot.actuate.endpoint.web.annotation.ServletEndpointsSupplier;
import org.springframework.boot.actuate.endpoint.web.servlet.WebMvcEndpointHandlerMapping;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import org.springframework.util.StringUtils;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Configuration
@EnableOpenApi
public class SwaggerConfig {

    @Bean
    public Docket initDocket(Environment env) {

        //设置要暴漏接口文档的配置环境
        //设置要显示的Swagger环境
        Profiles profile = Profiles.of("test","dev");
        //获取项目的环境：
        //通过environment.acceptsProfiles判断是否处在自己设定的环境当中
        boolean flag = env.acceptsProfiles(profile);
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                .enable(flag)//是否启动swagger 默认为true ,如果为false，则Swagger不能再浏览器中访问
                .select()
                //RequestHandlerSelectors,配置要扫描接口的方式
                .apis(RequestHandlerSelectors.basePackage("com.cmpt")) //指定要扫描的包
//                .apis(RequestHandlerSelectors.any())   //扫描全部
                //.apis(RequestHandlerSelectors.none()):不扫描
                //.apis(RequestHandlerSelectors.withClassAnnotation(RestController.class)):扫描类上的注解，参数是一个注解的反射对象
                //.apis(RequestHandlerSelectors.withMethodAnnotation(GetMapping.class)):扫描方法上的注解
//                .apis(RequestHandlerSelectors.basePackage("com.zhao.controller"))
                //paths()过滤什么路径(url)
                //paths(PathSelectors.ant("/zhao/**")) 就是在localhost:8080/zhao  后面的路径
//                .paths(PathSelectors.ant("/zhao/**"))
//                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build()
                //右上角 组（有几个Docket，有几个组）
                .groupName("第一组");
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("第一组的Swagger3-接口文档")
                .description("第一组")
                .contact(new Contact("第一组", "https://blog.csdn.net/qq_57581439?type=blog", "XXXX@qq.com "))
                .version("V1.0")
//                .license("Apache 2.0")
                .build();
    }

    @Bean
    public WebMvcEndpointHandlerMapping webEndpointServletHandlerMapping(WebEndpointsSupplier webEndpointsSupplier,
                                                                         ServletEndpointsSupplier servletEndpointsSupplier, ControllerEndpointsSupplier controllerEndpointsSupplier,
                                                                         EndpointMediaTypes endpointMediaTypes, CorsEndpointProperties corsProperties,
                                                                         WebEndpointProperties webEndpointProperties, Environment environment) {
        List<ExposableEndpoint<?>> allEndpoints = new ArrayList<>();
        Collection<ExposableWebEndpoint> webEndpoints = webEndpointsSupplier.getEndpoints();
        allEndpoints.addAll(webEndpoints);
        allEndpoints.addAll(servletEndpointsSupplier.getEndpoints());
        allEndpoints.addAll(controllerEndpointsSupplier.getEndpoints());
        String basePath = webEndpointProperties.getBasePath();
        EndpointMapping endpointMapping = new EndpointMapping(basePath);
        boolean shouldRegisterLinksMapping =
                webEndpointProperties.getDiscovery().isEnabled() && (StringUtils.hasText(basePath)
                        || ManagementPortType.get(environment).equals(ManagementPortType.DIFFERENT));
        return new WebMvcEndpointHandlerMapping(endpointMapping, webEndpoints, endpointMediaTypes,
                corsProperties.toCorsConfiguration(), new EndpointLinksResolver(allEndpoints, basePath),
                shouldRegisterLinksMapping, null);
    }
}
