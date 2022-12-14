package com.springproject.springproject.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springproject.springproject.domain.dto.TheaterDto;
import com.springproject.springproject.domain.entity.movie.MovieRepository;
import com.springproject.springproject.domain.entity.screen.ScreenRepository;
import com.springproject.springproject.domain.entity.theater.TheaterEntity;
import com.springproject.springproject.domain.entity.theater.TheaterRepository;

@Service
public class AdminService {

    @Autowired
    TheaterRepository theaterRepository;
    @Autowired
    ScreenRepository screenRepository;
    @Autowired
    MovieRepository movieRepository;









    @Transactional
    public boolean setTheater(TheaterDto theaterDto){

        TheaterEntity theaterEntity = theaterRepository.save(theaterDto.toEntity());
        if(theaterEntity.getTno() !=0){return true;}
        else{return false;}



    }
    
}
