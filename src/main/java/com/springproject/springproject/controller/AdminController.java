package com.springproject.springproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springproject.springproject.domain.dto.TheaterDto;
import com.springproject.springproject.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    AdminService adminService;


    //영화관 등록
    @PostMapping("/settname")
    public boolean setTheater(@RequestBody TheaterDto theaterDto){

        return adminService.setTheater(theaterDto);

    }

    
}
