package com.oauth.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class OAuthSwaggerConfiguration {

/**
	 * @ Swagger UI URL 		: http://localhost:8083/swagger-ui.html
	 * @ Swagger api docs URL 	: http://localhost:8083/v2/api-docs
     */

	@Value("${swagger.enabled}")
	private boolean swaggerEnabled; 
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).enable(swaggerEnabled).select()
				.apis(RequestHandlerSelectors.any()).paths(PathSelectors.any())
				.build();
	}
}