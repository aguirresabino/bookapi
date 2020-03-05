package io.github.aguirresabino.bookapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2)
        .produces(Collections.singleton("application/json"))
        .consumes(Collections.singleton("application/json"))
        .select()
        .apis(RequestHandlerSelectors.basePackage("io.github.aguirresabino.bookapi.controllers"))
        .paths(PathSelectors.any())
        .build();
  }
}
