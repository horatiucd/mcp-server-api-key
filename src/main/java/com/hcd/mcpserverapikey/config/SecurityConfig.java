package com.hcd.mcpserverapikey.config;

import org.springaicommunity.mcp.security.server.apikey.memory.ApiKeyEntityImpl;
import org.springaicommunity.mcp.security.server.apikey.memory.InMemoryApiKeyEntityRepository;
import org.springaicommunity.mcp.security.server.config.McpApiKeyConfigurer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import java.util.List;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

    //"x-api-key": id.secret = api-key-id.api-key-secret
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http,
                                            @Value("${api.key.id}") String apiKeyId,
                                            @Value("${api.key.secret}") String apiKeySecret) throws Exception {
        var apiKey = ApiKeyEntityImpl.builder()
                .name("API key")
                .id(apiKeyId)
                .secret(apiKeySecret)
                .build();

        var apiKeyRepository = new InMemoryApiKeyEntityRepository<>(List.of(apiKey));

        return http.authorizeHttpRequests(auth -> auth.anyRequest().authenticated())
                .with(McpApiKeyConfigurer.mcpServerApiKey(),
                        apiKeyConfig ->
                                apiKeyConfig.apiKeyRepository(apiKeyRepository)
                                        .headerName("ninja-x-api-key"))
                .build();
    }
}
