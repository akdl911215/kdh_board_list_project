package com.jh.kdh_project.dto;

import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class BoardCommentDTO {

    private int commentCode;
    private String commentContent;
    private LocalDateTime registerDate;
    private String deptName;
    private String teamName;
    private String userName;
    private String userRank;
    private int boardCode;
}

