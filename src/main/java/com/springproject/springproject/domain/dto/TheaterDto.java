package com.springproject.springproject.domain.dto;
import com.springproject.springproject.domain.entity.theater.TheaterEntity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class TheaterDto {
    private int tno;
    private String tname;


    public TheaterEntity toEntity(){

        return TheaterEntity.builder()
            .tno(this.tno)
            .tname(this.tname)
            .build();

    } 

}
