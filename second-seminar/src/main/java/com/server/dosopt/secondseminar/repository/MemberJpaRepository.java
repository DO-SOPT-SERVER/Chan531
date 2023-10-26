package com.server.dosopt.secondseminar.repository;

import com.server.dosopt.secondseminar.domain.entity.Member;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberJpaRepository extends JpaRepository<Member, Long> {
    default Member findByIdOrThrow(Long id) {
        return findById(id).orElseThrow(
                () -> new EntityNotFoundException("존재하지 않는 회원입니다."));
    }
}
