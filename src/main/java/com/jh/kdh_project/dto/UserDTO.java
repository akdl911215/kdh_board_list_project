package com.jh.kdh_project.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class UserDTO {

    private int userCode;
    private String userName;
    private String userRank;
    private String teamName;
    private String deptName;
}

