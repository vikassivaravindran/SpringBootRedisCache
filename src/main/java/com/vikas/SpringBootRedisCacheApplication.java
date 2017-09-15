package com.vikas;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
public class SpringBootRedisCacheApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRedisCacheApplication.class, args);
	}
}

@Configuration
@EnableSwagger2
class AdditionalConfig{
       

       @Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())  
          .select()                                  
          .apis(RequestHandlerSelectors.basePackage("com.vikas"))              
          .paths(PathSelectors.any())                          
          .build();                                           
    }
       private ApiInfo apiInfo() {
              return new ApiInfoBuilder().title("BOOK API WITH REDIS CACHE")
                           .description("BOOK API WITH REDIS CACHE reference for developers")
                           .contact("vikas.sivaravindran@accenture.com").license("BOOK API License")
                           .licenseUrl("vikas.sivaravindran@accenture.com").version("1.0").build();
       }
}
