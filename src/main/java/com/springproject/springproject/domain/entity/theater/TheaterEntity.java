package com.springproject.springproject.domain.entity.theater;

import java.util.ArrayList;
import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.springproject.springproject.domain.dto.TheaterDto;
import com.springproject.springproject.domain.entity.BaseEntity;
import com.springproject.springproject.domain.entity.screen.ScreenEntity;

import lombok.*;
@Entity
@Table(name="theater")
@NoArgsConstructor@AllArgsConstructor@Getter@Setter@Builder@ToString
public class TheaterEntity  extends BaseEntity{
    @Id 
    @GeneratedValue( strategy = GenerationType.IDENTITY ) 
    private int tno;
    @Column
    private String tname;
    @OneToMany(mappedBy = "theaterEntity" ) 
    @Builder.Default 
    private List<ScreenEntity> screenEntities = new  ArrayList<>();


    public TheaterDto toDto(){

        return TheaterDto.builder()
            .tno(this.tno)
            .tname(this.tname)
            .build();

    }


    
}
