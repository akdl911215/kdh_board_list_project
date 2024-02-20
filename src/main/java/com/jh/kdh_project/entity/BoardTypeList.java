package com.jh.kdh_project.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="board_type_list")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class BoardTypeList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int boardTypeCode;

    @Column(name="board_type")
    private String boardType;
}