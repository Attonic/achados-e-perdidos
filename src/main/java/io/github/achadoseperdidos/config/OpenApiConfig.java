package io.github.achadoseperdidos.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenApi() {

        final String schemeName = "barearAuth";

        return new OpenAPI()
                .info(
                        new Info()
                                .title("Achados e Perdidos")
                                .description("Api para achados e perdidos")
                                .version("0.0.1")

                ).addSecurityItem(new SecurityRequirement().addList(schemeName))
                .components(
                        new Components()
                                .addSecuritySchemes(schemeName, new SecurityScheme()
                                        .name(schemeName)
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer")
                                        .bearerFormat("JWT")
                                        .description("JWT Token")
                                )

                );


    }

}
