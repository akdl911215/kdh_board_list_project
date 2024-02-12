package com.jh.kdh_project.dto;

import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class InterestBoardDTO {

    private int interestCode;
    private int boardCode;
    private int userCode;
    private String userName;
    private String teamName;
    private String deptName;
    private String title;
    private String content;
    private int viewCount;
    private LocalDateTime registerDate;
    private LocalDateTime updateDate;
    private LocalDateTime deleteDate;
}
