package com.springproject.springproject.domain.entity.member;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity,Integer> {
    Optional<MemberEntity> findByMid(String mid);
}
