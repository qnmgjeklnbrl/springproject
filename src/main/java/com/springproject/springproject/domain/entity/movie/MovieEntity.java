package com.springproject.springproject.domain.entity.movie;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;

import com.springproject.springproject.domain.entity.screen_movie.ScreenMovieEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="movie")
@NoArgsConstructor@AllArgsConstructor@Getter@Setter@Builder@ToString
public class MovieEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int mono;
    @Column(nullable =false)
    private String moname;
    @OneToMany(mappedBy = "movieEntity" ) 
    @Builder.Default 
    private List<ScreenMovieEntity> screenMovieEntities = new ArrayList<>();
}
