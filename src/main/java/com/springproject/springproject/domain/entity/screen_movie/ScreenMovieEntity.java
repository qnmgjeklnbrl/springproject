package com.springproject.springproject.domain.entity.screen_movie;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;

import com.springproject.springproject.domain.entity.movie.MovieEntity;
import com.springproject.springproject.domain.entity.reservation.ReservationEntity;
import com.springproject.springproject.domain.entity.screen.ScreenEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="screen_movie")
@NoArgsConstructor@AllArgsConstructor@Getter@Setter@Builder@ToString
public class ScreenMovieEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int smno;
    
    @ManyToOne
    @JoinColumn(name="sno")
    @ToString.Exclude 
    private ScreenEntity screenEntity;
    @ManyToOne
    @JoinColumn(name="mono")
    @ToString.Exclude 
    private MovieEntity movieEntity;
    
    @OneToMany(mappedBy = "screenmovieEntity" ) 
    @Builder.Default 
    private List<ReservationEntity> reservationEntities = new ArrayList<>();
}
