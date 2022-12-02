package com.springproject.springproject.domain.entity.screen_movie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScreenMovieRepository extends JpaRepository<ScreenMovieEntity,Integer> {
    
}
