package com.springproject.springproject.domain.entity.reservation;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

import com.springproject.springproject.domain.entity.member.MemberEntity;
import com.springproject.springproject.domain.entity.screen_movie.ScreenMovieEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="reservation")
@NoArgsConstructor@AllArgsConstructor@Getter@Setter@Builder@ToString
public class ReservationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rno;
    
    @ManyToOne
    @JoinColumn(name="mno")
    @ToString.Exclude 
    private MemberEntity memberEntity;
    @ManyToOne
    @JoinColumn(name="smno")
    @ToString.Exclude 
    private ScreenMovieEntity screenmovieEntity;
   
}
