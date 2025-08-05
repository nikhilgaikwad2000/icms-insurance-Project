package com.icms.insurance.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class SwaggerConfig {
    public OpenAPI customOpenApi() {
        return new OpenAPI().
                info(new Info()
                        .title("ICMS Insurance Project API")
                        .version("1.0.0")
                        .description("Swagger documentation for ICMS Insurance Modules (User, Policy, ED, Claim)")


                );




    }
    @Bean
    public GroupedOpenApi userApi(){
           return GroupedOpenApi.builder()
                   .group("User Module")
                   .pathsToMatch("/api/auth/**")
                   .build();
    }



    @Bean
    public GroupedOpenApi policyApi() {
        return GroupedOpenApi.builder()
                .group("Policy Module")
                .pathsToMatch("/api/admin/**")
                .build();
    }

    @Bean
    public GroupedOpenApi eligibilityApi() {
        return GroupedOpenApi.builder()
                .group("Eligibility Module")
                .pathsToMatch("/api/eligibility/**")
                .build();
    }

    @Bean
    public GroupedOpenApi claimApi() {
        return GroupedOpenApi.builder()
                .group("Claim Module")
                .pathsToMatch("/api/claims/**")
                .build();
    }



}
