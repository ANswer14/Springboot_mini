package com.lyh.mini.service;

import com.lyh.mini.domain.Member;
import com.lyh.mini.domain.RegisterMemberForm;
import com.lyh.mini.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MemberService {

    private final MemberRepository MEMBERREPOSITORY;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public MemberService(MemberRepository MEMBERREPOSITORY, BCryptPasswordEncoder passwordEncoder) {
        this.MEMBERREPOSITORY = MEMBERREPOSITORY;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public Boolean register(RegisterMemberForm registeringMember) {
        try {

            ValidationCheck(registeringMember.getId());
            Member member = new Member();
            member.setMemberID(registeringMember.getId());
            member.setMemberNM(registeringMember.getName());
            member.setMemberPW(passwordEncoder.encode(registeringMember.getPassword1()));
            MEMBERREPOSITORY.save(member);
            return false;
        } catch (IllegalStateException e) {
            return true;
        }
    }


    public void ValidationCheck(String id) {
        MEMBERREPOSITORY.findByMemberID(id).ifPresent(m -> {
            throw new IllegalStateException();
        });
    }

//    public String PWEncoder(String password) {
//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        return passwordEncoder.encode(password);
//    }

}
