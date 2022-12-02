package com.springproject.springproject.domain.entity.screen;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.springproject.springproject.domain.entity.screen_movie.ScreenMovieEntity;
import com.springproject.springproject.domain.entity.theater.TheaterEntity;

import java.util.ArrayList;
import java.util.List;

import lombok.*;
@Entity
@Table(name="screen")
@NoArgsConstructor@AllArgsConstructor@Getter@Setter@Builder@ToString
public class ScreenEntity {
    @Id 
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private int sno;
    @Column
    private int rno;
    @Column
    private int cno;
    @ManyToOne
    @JoinColumn(name="tno")
    @ToString.Exclude 
    private TheaterEntity theaterEntity;
    @OneToMany(mappedBy = "screenEntity" ) 
    @Builder.Default 
    private List<ScreenMovieEntity> screenMovieEntities = new ArrayList<>();
}
