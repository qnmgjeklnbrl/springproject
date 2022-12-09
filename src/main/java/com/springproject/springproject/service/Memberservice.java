package com.springproject.springproject.service;

import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.springproject.springproject.domain.dto.MemberDto;
import com.springproject.springproject.domain.entity.member.MemberEntity;
import com.springproject.springproject.domain.entity.member.MemberRepository;

@Service
public class Memberservice  implements UserDetailsService{
    @Autowired
    private MemberRepository memberRepository;

    

    @Override
    public UserDetails loadUserByUsername(String mid) throws UsernameNotFoundException {
        // TODO Auto-generated method stub
       
        MemberEntity memberEntity = memberRepository.findByMid(mid)
            .orElseThrow(()-> new UsernameNotFoundException("존재하지 않는 아이디 입니다."));
        Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(
            new SimpleGrantedAuthority(memberEntity.getMrol())
        );
        MemberDto memberDto = memberEntity.toDto();
        memberDto.setAuthorities(authorities);

        
        System.out.println(memberDto);
        return memberDto;
    }

    @Transactional
    public int setmember(MemberDto memberDto ){
        // 암호화 : 해시함수 사용하는 암호화 기법중 하나 [ BCrypt ]
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        memberDto.setMpassword( passwordEncoder.encode( memberDto.getPassword() ) );
        // 1. DAO 처리 [ insert ]
        MemberEntity entity = memberRepository.save( memberDto.toEntity() );
            // memberRepository.save( 엔티티 객체 ) : 해당 엔티티 객체가 insert 생성된 엔티티객체 반환
        // 회원 등급 넣어주기
        entity.setMrol("user");

     
        return entity.getMno();
    }
    
}
