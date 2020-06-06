package com.javasree.ms.inventory.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter{

    @Autowired private Environment environment;

    public WebSecurity(Environment environment){
        this.environment = environment;
    }

    @Override
    public void configure(HttpSecurity http) throws Exception{
        http.csrf().disable();
        http.authorizeRequests().antMatchers("/**")
                .permitAll();
                //.hasIpAddress(this.environment.getProperty("my.gateway.ip"))
                //.access("hasIpAddress('"+this.environment.getProperty("my.gateway.ip")+"')")
                //.hasAnyRole("READ","WRITE")

                //http.authorizeRequests.antMatchers("/**").hasIpAddress(environment.getProperty("my.gatekeeper.ip"))


        http.headers().frameOptions().disable();
    }
}
