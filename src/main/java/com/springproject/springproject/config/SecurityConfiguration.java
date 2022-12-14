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

    @Override 
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService( memberService ).passwordEncoder( new BCryptPasswordEncoder() );
      
          
    }

    @Override 
    protected void configure(HttpSecurity http) throws Exception {
        http
                .formLogin()
                    .loginPage("/member/login")                     // 아이디와 비밀번호를 입력받을 URL [ 로그인 페이지  ]
                    .loginProcessingUrl("/member/getmember")        // 로그인을 처리할 URL [ 서비스 --> loadUserByUsername  ]
                    .defaultSuccessUrl("/")                         // 로그인 성공했을때 이동할 URL
                    .failureUrl("/member/login") // 로그인 실패시 이동할 URL
                    .usernameParameter("mid")                    // 아이디 변수명
                    .passwordParameter("mpassword")   
                    
                .and()  
                    .csrf()
                        .ignoringAntMatchers("/member/getmember")
                        .ignoringAntMatchers("/member/setmember") 
                        .ignoringAntMatchers("/admin/settname") ;

                

       
    }
}

