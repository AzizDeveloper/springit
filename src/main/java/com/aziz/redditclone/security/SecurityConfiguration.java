package com.aziz.redditclone.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private UserDetailsServiceImpl userDetailsService;


    public SecurityConfiguration(UserDetailsServiceImpl userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests()
                .requestMatchers(EndpointRequest.to("info")).permitAll()
                .requestMatchers(EndpointRequest.toAnyEndpoint()).hasRole("ADMIN")
                .antMatchers("/actuator/").hasRole("ADMIN")
                .antMatchers("/").permitAll()
                .antMatchers("/link/submit").hasRole("USER")
                .antMatchers("/h2-console/**").permitAll()
            .and()
            .formLogin()
            .and()
            .csrf().disable()
            .headers().frameOptions().disable();
    }
//                .requestMatchers(EndpointRequest.to("info")).permitAll()
//                .requestMatchers(EndpointRequest.toAnyEndpoint()).hasRole("ACTUATOR")
//                .antMatchers("/actuator/").hasRole("ACTUATOR")
//                .antMatchers("/link/submit").hasRole("USER")
//                .antMatchers("/link/**").permitAll()
//                .antMatchers("/").permitAll()
//                .antMatchers("/h2-console/**").permitAll()
//                .and()
//                .formLogin()
//                .and()
//                .csrf().disable()
//                .headers().frameOptions().disable();

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }
}

