package com.lyh.mini.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name="MEMBER_TB")
public class Member {
    @Id
    @Column(name="member_id")
    private String username;
    @Column(name="member_nm")
    private String memberNM;
    @Column(name="member_pw")
    private String password;
    @Column(name="member_role")
    private String memberRole;
}
