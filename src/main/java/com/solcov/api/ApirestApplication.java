package com.solcov.api;

import com.solcov.api.security.JWTAuthorizationFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@SpringBootApplication
public class ApirestApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApirestApplication.class, args);
    }

    @EnableWebSecurity
    @Configuration
    class WebSecurityConfig extends WebSecurityConfigurerAdapter {

        private final String[] DOCUMENTATION_LIST = {
                "/swagger-resources/**",
                "/swagger-ui.html",
                "/v2/api-docs",
                "/webjars/**"
        };


        private final String[] CLIENT_LIST_POST = {
                "/menu-order",
                "/order",
                "/memory"
        };



        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.cors().and().csrf().disable()
                    .addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
                    .authorizeRequests()
                    .antMatchers(HttpMethod.GET, DOCUMENTATION_LIST).permitAll()
                    .antMatchers(HttpMethod.POST, "/login").permitAll()
                    .antMatchers(HttpMethod.GET, "/menu").permitAll()
                    .antMatchers(HttpMethod.GET, "/memory").permitAll()
                    .antMatchers(HttpMethod.POST, CLIENT_LIST_POST).permitAll()
                    .anyRequest().authenticated();
        }
    }
}