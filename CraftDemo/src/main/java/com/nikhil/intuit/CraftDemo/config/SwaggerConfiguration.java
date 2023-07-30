package com.nikhil.intuit.CraftDemo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import io.swagger.v3.oas.models.servers.ServerVariable;
import io.swagger.v3.oas.models.servers.ServerVariables;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfiguration {
    @Bean
    @Primary
    public OpenAPI OpenAPIConfiguration(@Value("${springdoc.version}") String docVersion,
                                        @Value("${server.port}") String serverPort) {

        return new OpenAPI()
                .info(new Info().title("Interaction Service").version(docVersion)
                        .description("Collection of all Interaction Service Requests"))

                .addServersItem(
                        new Server().url("{protocol}://{host}:{port}/{path}")
                                .description("Interaction Service Server's URL")
                                .variables(new ServerVariables()
                                        .addServerVariable("protocol",
                                                new ServerVariable()._default("http").addEnumItem("http")
                                                        .addEnumItem("https"))
                                        .addServerVariable("host", new ServerVariable()._default("localhost"))
                                        .addServerVariable("port", new ServerVariable()._default(serverPort))
                                        .addServerVariable("path", new ServerVariable()._default(""))));

    }
    @Bean
    public GroupedOpenApi interactionServiceApi() {
        return GroupedOpenApi.builder().group("").pathsToMatch("/**").build();
    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("URL Shortening Service API Documentation")
                .description("API documentation for the URL Shortening Service")
                .version("1.0")
                .build();
    }

}
