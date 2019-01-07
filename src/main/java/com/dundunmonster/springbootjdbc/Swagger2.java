/*
* 文件名: com.dundunmonster.springbootjdbc
* 文件编号: 
* 版权: Copyright (c) 2019, YAN Co.Ltd. and/or its affiliates. All rights reserved.Use is subject to license terms.
* 描述: 
* 创建人: ghaoxiang
* 创建时间: 2019年01月07日 10:03
* 修改人:
* 修改时间: 2019年01月07日 10:03
* 修改变更号: 
* 修改内容: 
*/
package com.dundunmonster.springbootjdbc;

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
 * @author ghaoxiang
 * @version V1.0
 * @Title Swagger2
 * @Description
 * @date 2019年01月07日 10:03
 * @since V1.0
 */
@Configuration
@EnableSwagger2
public class Swagger2 {

    /**
     * 创建用户API文档
     * @return
     */
    @Bean
    public Docket createRestCusApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("cus")
                .apiInfo(createCusApiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.dundunmonster.springbootjdbc.cus"))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * 创建客户API信息
     * @return
     */
    private ApiInfo createCusApiInfo(){
        return new ApiInfoBuilder()
                .title("处理客户信息相关接口")
                .description("以下接口只操作客户信息")
                .contact(new Contact("ghaoxiangzZ","https://github.com/ghaoxiangzZ","784390929@qq.com"))
                .version("1.0")
                .build();
    }
}
