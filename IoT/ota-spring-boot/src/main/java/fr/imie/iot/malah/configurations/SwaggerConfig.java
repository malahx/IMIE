package fr.imie.iot.malah.configurations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.time.ZonedDateTime;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

    @Value("${app.version}")
    private String appVersion;

    @Value("${app.name}")
    private String appName;

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("fr.imie.malah"))
                .build()
                .directModelSubstitute(ZonedDateTime.class, String.class);
    }

}
