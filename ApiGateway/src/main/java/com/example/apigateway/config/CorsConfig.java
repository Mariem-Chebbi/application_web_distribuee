package com.example.apigateway.config;



import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.reactive.config.CorsRegistry;
import org.springframework.web.reactive.config.WebFluxConfigurer;

    @Configuration
    public class CorsConfig implements WebFluxConfigurer {

        @Override
        public void addCorsMappings(CorsRegistry registry) {
            registry.addMapping("/**")
                    .allowedOrigins()
                    .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                    .allowedHeaders("Content-Type", "Access-Control-Allow-Headers", "Authorization", "X-Requested-With")
                    .allowCredentials(true);
        }
    }



