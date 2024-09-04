package com.lyh.mini.service;

import com.lyh.mini.domain.Member;
import com.lyh.mini.domain.RegisterMemberForm;
import com.lyh.mini.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

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
    public void register(String name, String id, String password1, String password2, Model model) {
        try {

            ValidationCheck(id);
            RegisterMemberForm registeringMember = new RegisterMemberForm();
            registeringMember.setId(id);
            registeringMember.setName(name);
            registeringMember.setPassword1(password1);
            registeringMember.setPassword2(password2);
            if (password1 != password2) {
                throw new IllegalStateException("비밀번호가 다릅니다");
            }
            Member member = new Member();
            member.setMemberID(id);
            member.setMemberNM(name);
            member.setMemberPW(passwordEncoder.encode(password1));
            MEMBERREPOSITORY.save(member);
            model.addAttribute("result", "성공!");
        } catch (IllegalStateException e) {
            model.addAttribute("result", "실패!");
        }
    }


    public void ValidationCheck(String id) {
        MEMBERREPOSITORY.findByMemberID(id).ifPresent(m -> {
            throw new IllegalStateException("중복되는 id가 있습니다.!");
        });
    }

//    public String PWEncoder(String password) {
//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        return passwordEncoder.encode(password);
//    }

}
