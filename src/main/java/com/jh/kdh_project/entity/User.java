package com.jh.kdh_project.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name="user")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@Builder
public class User {

    @Id
    @Column(name="user_code")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userCode;

    @Column(name="user_name")
    private String userName;

    @Column(name="user_pw")
    private String userPw;

    @Column(name="user_rank")
    private String userRank;

    @Column(name="email")
    private String email;

    @Column(name="phone")
    private String phone;

    @Column(name="end_date")
    private Date endDate;

    @Column(name="resign_date")
    private Date resignDate;

    @ManyToOne
    @JoinColumn(name="team_code")
    private Team team;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="off_code")
    private DayOff dayOff;
}