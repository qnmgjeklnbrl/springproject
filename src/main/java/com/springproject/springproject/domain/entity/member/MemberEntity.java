package com.springproject.springproject.domain.entity.member;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.ArrayList;

import com.springproject.springproject.domain.dto.MemberDto;
import com.springproject.springproject.domain.entity.BaseEntity;
import com.springproject.springproject.domain.entity.reservation.ReservationEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="member")
@NoArgsConstructor@AllArgsConstructor@Getter@Setter@Builder@ToString
public class MemberEntity extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int mno;
    @Column( nullable = false )
    private String mid;
    @Column( nullable = false )
    private String mpassword;
    @Column( nullable = false )
    private String mphone;
    @Column( nullable = false )
    private String mname;
    @Column( nullable = false )
    private String memail;
    @Column 
    private String mrol;

    @OneToMany(mappedBy = "memberEntity" ) 
    @Builder.Default 
    private List<ReservationEntity> reservationEntities = new ArrayList<>();



    public MemberDto toDto(){

        return MemberDto.builder()

            .mno(this.mno)
            .mid(this.mid)
            .mpassword(this.mpassword)
            .mphone(this.mphone)
            .mname(this.mname)
            .memail(this.memail)
            .mrol(this.mrol)
            .build();



    }
}
