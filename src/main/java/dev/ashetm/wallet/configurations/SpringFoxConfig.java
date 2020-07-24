package dev.ashetm.wallet.configurations;

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

@Configuration
@EnableSwagger2
public class SpringFoxConfig {
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("dev.ashetm.wallet"))
				.paths(PathSelectors.any())
				.build()
				.pathMapping("/")
				.apiInfo(metadata());
	}

	private ApiInfo metadata() {
		return new ApiInfoBuilder()
				.title("AsheTM Wallet Back End API")
				.contact(contact())
				.build();
	}

	private Contact contact() {
		return new Contact("DAWOUD Haitham", "", "contact@ashetm.com");
	}

}
