package com.jh.kdh_project.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="department")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@Builder
public class Department {

    @Id
    @Column(name="dept_code")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int deptCode;

    @Column(name="dept_name")
    private String deptName;

}
