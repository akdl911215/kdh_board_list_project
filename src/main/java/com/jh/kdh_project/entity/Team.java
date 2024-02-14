package com.jh.kdh_project.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="team")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@Builder
public class Team extends BaseEntity {

    @Id
    @Column(name="team_code")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int teamCode;

    @ManyToOne()
    @JoinColumn(name="dept_code")
    private Department department;

    @Column(name="team_name")
    private String teamName;
}
