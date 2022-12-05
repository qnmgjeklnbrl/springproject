package com.springproject.springproject.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.springproject.springproject.service.Memberservice;


@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired
    private Memberservice memberService;

    @Override // 인증(로그인) 관련 메소드 재정의
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService( memberService ).passwordEncoder( new BCryptPasswordEncoder() );
        // memberService 에서  UserDetailsService 구현체
            // loadUserByUsername 구현
    }

    @Override // http 관련 시리큐티 재정의
    protected void configure(HttpSecurity http) throws Exception {
        http
            .formLogin()
                .loginPage("/member/login")
                .loginProcessingUrl("/member/getmember")
                .defaultSuccessUrl("/")
                .failureUrl("/")
                .usernameParameter("mid")
                .passwordParameter("mpassword")
            .and()
                .logout()
                    .logoutRequestMatcher(new AntPathRequestMatcher("/member/logout"))
                    .logoutSuccessUrl("/")
                    .invalidateHttpSession(true)
            .and()
                .csrf()
                    .ignoringAntMatchers("/member/getmember")
                    .ignoringAntMatchers("/member/setmember")
            .and()
                .oauth2Login()
                .userInfoEndpoint()
                .userService(memberService);


       
    }
}

