package com.theironyard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.naming.AuthenticationException;

/**
 * Created by graceconnelly on 2/22/17.
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
            .authorizeRequests()
                .antMatchers().permitAll()
                .antMatchers("/nothing")
                    .hasRole("COUNSELOR")
                .antMatchers("/nothing")
                    .hasRole("ADMIN")
                .and()
                    .formLogin()
                .and()
                    .logout()
                    .invalidateHttpSession(true)

         ;
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("Kim")
                .password(System.getenv("KIMPW"))
                .roles("COUNSELOR","ADMIN")
                .and()
                .withUser("Ben")
                .password("pants").roles("Pants");
    }
}
