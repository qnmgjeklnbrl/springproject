package com.springproject.springproject.domain.dto;

import org.springframework.security.core.userdetails.UserDetails;

import com.springproject.springproject.domain.entity.member.MemberEntity;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;



import java.util.Collection;
import java.util.Map;
import java.util.Set;
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter @ToString @Builder
public class MemberDto implements UserDetails {

    private int mno;
    private String mid;
    private String mpassword;
    private String mphone;
    private String mname;
    private String memail;
    private String mrol;
    private Set<GrantedAuthority> authorities;

    public MemberEntity toEntity(){
        return MemberEntity.builder()
        .mno(this.mno)
        .mid(this.mid)
        .mpassword(this.mpassword)
        .mphone(this.mphone)
        .mname(this.mname)
        .memail(this.memail)
        .mrol(this.mrol)
        .build();


    }

    public void setAuthorities(Set<GrantedAuthority>authorities){
        this.authorities=authorities;

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // TODO Auto-generated method stub
        return this.authorities;
    }
    @Override
    public String getPassword() {
        // TODO Auto-generated method stub
        return this.mpassword;
    }
    @Override
    public String getUsername() {
        // TODO Auto-generated method stub
        return this.mid;
    }
    @Override
    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }
    @Override
    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        return true;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }
    @Override
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        return true;
    }
}
