package com.horizonbuilders.server.config;

import com.horizonbuilders.server.jwt.AuthEntryPoint;
import com.horizonbuilders.server.jwt.JwtAuthenticationProvider;
import com.horizonbuilders.server.jwt.JwtFilter;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@EnableMethodSecurity
@Configuration
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AppSecurityConfiguration {

    final JwtAuthenticationProvider jwtAuthenticationProvider;
    final JwtFilter jwtFilter;
    final AuthEntryPoint authEntryPoint;

    private static final String[] WHITELIST = {
            //swagger
            "/swagger-resources/**",
            "/api-docs/**",
            "/v3/api-docs/**",
            "/webjars/**",

            //errors
            "/error/**",

            //endpoints\
            "/api/authenticate/**",
            "/api/refresh-token/**",
            "/test/**"


    };

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeHttpRequests(request -> request
                        .requestMatchers(WHITELIST).permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/purchase-request/**").permitAll()
                        .requestMatchers("/api/purchase-request/**").hasAnyAuthority("ADMIN","SUPERVISOR")
                        .requestMatchers(HttpMethod.GET, "/api/news/**").permitAll()
                        .requestMatchers("/api/news/**").hasAuthority("ADMIN")
                        .anyRequest().authenticated())
                .exceptionHandling().authenticationEntryPoint(authEntryPoint)
                .and()
                .authenticationProvider(jwtAuthenticationProvider)
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return web -> web
                .ignoring()
                .requestMatchers("/actuator/**");
    }

}
