package com.springproject.springproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springproject.springproject.domain.dto.MemberDto;
import com.springproject.springproject.service.Memberservice;

@RestController
@RequestMapping("/member")
public class MemberController {
    @Autowired
    private Memberservice memberservice;

    @PostMapping("/setmember")
    public int setmember(@RequestBody MemberDto memberDto){ 
 

        int result = memberservice.setmember(memberDto);
        return result;


    }
}
