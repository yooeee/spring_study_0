package com.example.spring_study_0.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.spring_study_0.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long>{

    Member findByEmail(String email);
    
}
