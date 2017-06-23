package com.vabram.hearthum.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 *
 * Created by brama051 on 28.2.2017..
 */
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    /*https://auth0.com/blog/securing-spring-boot-with-jwts/
    - securing REST API with JWT*/

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        /*auth.inMemoryAuthentication()
                .withUser("brama051").password("secret").roles("ADMIN");*/
    }

    protected void configure(HttpSecurity http) throws Exception {
        /*http.authorizeRequests()
                .antMatchers("/resources/ne*ne*", "/login**", "/register**").permitAll()
                .anyRequest().hasRole("ADMIN")
                .filterSecurityInterceptorOncePerRequest(false)
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/index.html", true)
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login.html?logout=true")
                .permitAll(true)
                .and()
                .csrf().disable();*/
    }
}
