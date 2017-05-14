package com.andy.util;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.activation.DataSource;
import javax.inject.Inject;

/**
 * Created by Andrew on 22.03.2017.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Inject
    BasicDataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin().and().authorizeRequests().antMatchers("/**").access("hasRole('ROLE_MANAGER')").and().csrf().disable();
        /*http.formLogin().defaultSuccessUrl("/managers/manager").and().authorizeRequests().antMatchers("/managers*//**")
                .access("hasRole('ROLE_MANAGER')");*/
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource)
        .usersByUsernameQuery("select manager_login, manager_password, true from manager where manager_login = ?")
        .authoritiesByUsernameQuery("select manager_login, manager_role from manager where manager_login = ?");

        auth.jdbcAuthentication().dataSource(dataSource)
        .usersByUsernameQuery("select developer_login, developer_password, true from developer where developer_login = ?")
        .authoritiesByUsernameQuery("select developer_login, developer_role from developer where developer_login = ?");
        //пароли не закодированны
    }
}
