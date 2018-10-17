package com.jesse.jesseweb.auth;

import com.jesse.jesseweb.integration.IntegrationAuthenticationFilter;
import com.jesse.jesseweb.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @author Jesse
 */

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true) //开启security注解
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    //@Autowired
    //private MyUserDetailsService myUserDetailsService;
    @Autowired
    private IntegrationAuthenticationFilter integrationAuthenticationFilter;
    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.addFilterBefore(integrationAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .authorizeRequests()
                .antMatchers("/thirdparty/**", "/register/**", "/user").permitAll()
                .antMatchers("/register").permitAll()
                .antMatchers("/oauth/**").permitAll()
                .antMatchers("/edit").hasRole("admin") //spring security 默认权限前面自带ROLE_前缀
                .anyRequest()
                .fullyAuthenticated()//完整权限可以访问(和authenticated()区别是 authenticated()包括remember-me用户)
                .and()
                .formLogin()
                .loginPage("/login") //跳转的登录页
                .failureUrl("/login?error")     //登录失败页面
                .defaultSuccessUrl("/index")    //登录成功跳转页面
                .usernameParameter("username") //默认为username
                .loginProcessingUrl("/login") //登录时的请求 其实默认就是/login 只有填写了这个 security才会去将该提交请求拦截并进入 验证
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/logout")
                .deleteCookies("remember-me")
                .logoutSuccessUrl("/")
                .permitAll()
                .and()
                .csrf().disable();
    }

    /*@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        *//*auth
                .userDetailsService(userDetailsService);*//*
        auth
                .inMemoryAuthentication().passwordEncoder()
                .withUser("2")
                .password("2")
                .roles("USER");
    }*/

    /*@Bean
    @Override
    public UserDetailsService userDetailsService() {

        UserDetails user =
                org.springframework.security.core.userdetails.User.withDefaultPasswordEncoder()
                        .username("user")
                        .password("password")
                        .roles("USER")
                        .build();

        return new InMemoryUserDetailsManager(user);
    }*/
    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/img/**", "/css/**", "/js/**");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(NoOpPasswordEncoder.getInstance());
        /*auth
                .inMemoryAuthentication()
                .withUser("2")
                .password("2")
                .roles("USER");*/
    }


    /*@Override
    protected UserDetailsService userDetailsService() {
        return super.userDetailsService();
    }*/
}
