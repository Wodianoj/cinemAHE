package com.example.cinemahe.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecConfig extends WebSecurityConfigurerAdapter
{
    private static final String COMMON_PASSWORD = "H@slo123";

    protected void configure(final AuthenticationManagerBuilder auth) throws Exception
    {
        auth.inMemoryAuthentication()
                .withUser("bbb").password(passwordEncoder().encode(COMMON_PASSWORD))
                .roles("USER")
                .and()
                .withUser("aaa").password(passwordEncoder().encode(COMMON_PASSWORD))
                .roles("USER")
                .and()
                .withUser("misu15@wp.pl").password(passwordEncoder().encode(COMMON_PASSWORD))
                .roles("USER")
                .and()
                .withUser("nika17@gov.pl").password(passwordEncoder().encode(COMMON_PASSWORD))
                .roles("USER")
                .and()
                .withUser("czesia@vp.pl").password(passwordEncoder().encode(COMMON_PASSWORD))
                .roles("USER");
    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception
    {
        http
                .authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }

    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }
}