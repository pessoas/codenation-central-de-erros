package br.com.codenation.centraldeerros.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket apis() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("br.com.codenation.centraldeerros"))
                .paths(PathSelectors.any())
                .build()
                .globalOperationParameters(Collections.singletonList(new ParameterBuilder()
                    .name("Authorization")
                    .description("Bearer token")
                    .modelRef(new ModelRef("string"))
                    .parameterType("header")
                    .required(true)
                    .build()))
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Central de erros",
                "API para centralização de erros",
                "1.0",
                "Termos de serviço",
                new Contact("Renato Pessoa", "https://github.com/pessoas", "renatopessoaneto@gmail.com"),
                "Licença",
                "Url da licença",
                new ArrayList<>()
        );
    }

}
