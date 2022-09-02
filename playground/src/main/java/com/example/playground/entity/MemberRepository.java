package com.example.playground.entity;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

  Member save(Member member);

  Optional<Member> findById(Long id);

}
