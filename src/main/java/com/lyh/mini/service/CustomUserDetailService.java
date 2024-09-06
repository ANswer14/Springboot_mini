package com.lyh.mini.service;

import com.lyh.mini.domain.Member;
import com.lyh.mini.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private MemberRepository MEMBERREPOSITORY;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member member = MEMBERREPOSITORY.findByUsername(username).get();
        Set<String> set = new HashSet<>();
        set.add(member.getMemberRole());
        if(member.getUsername() == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new org.springframework.security.core.userdetails.User(
                member.getUsername(),
                member.getPassword(),
                new ArrayList<>()
        );
    }

}
