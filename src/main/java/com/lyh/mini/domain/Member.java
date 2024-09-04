package com.lyh.mini.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="MEMBER_TB")
public class Member {
    @Id
    @Column(name="member_id")
    private String memberID;
    @Column(name="member_nm")
    private String memberNM;
    @Column(name="member_pw")
    private String memberPW;
}
