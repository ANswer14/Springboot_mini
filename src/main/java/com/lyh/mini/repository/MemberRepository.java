package com.lyh.mini.repository;

import com.lyh.mini.domain.Member;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface MemberRepository extends CrudRepository<Member, String> {
    Optional<Member> findByMemberID(String ID);
}
