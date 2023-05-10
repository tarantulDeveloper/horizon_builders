package com.horizonbuilders.server.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Horizon Builders - Construction Company",
                version = "1.0",
                contact = @Contact(
                        name = "Bekzhan Satiev", email = "tarantuldeveloper@gmail.com"
                ),
                description = """
                        Restfull server with access and refresh tokens. Access token is valid
                        for 30 min, refresh - 2 hours.
                        """
        )
)
public class SwaggerConfig {
    @Bean
    public OpenAPI customizeOpenAPI() {
        final String securitySchemeName = "Bearer_Token_Authorization";

        return new OpenAPI()
                .addSecurityItem(new SecurityRequirement()
                        .addList(securitySchemeName))
                .components(new Components()
                        .addSecuritySchemes(securitySchemeName, new SecurityScheme()
                                .name(securitySchemeName)
                                .type(SecurityScheme.Type.HTTP)
                                .description("Just paste your access token here.")
                                .scheme("Bearer")
                                .bearerFormat("JWT")));
    }
}
