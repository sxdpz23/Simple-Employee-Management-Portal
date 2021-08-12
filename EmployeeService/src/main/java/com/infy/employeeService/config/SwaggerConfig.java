package com.infy.employeeService.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/// Link for accessing project swagger-UI ====> http://localhost:3333/e-service/swagger-ui.html

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.infy.employeeService.api")).paths(PathSelectors.any())
				.build().apiInfo(metaData());
	}

	private ApiInfo metaData() {
		return new ApiInfo("Employee Service App API", "Employee Service App API", "1.0", "Terms Of Service",
				new Contact("Employee Service App API", "", "admin@infy.com"), "Employee Service App API", "");
	}

}
