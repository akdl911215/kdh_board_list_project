package com.jh.kdh_project.dto;

import com.jh.kdh_project.entity.BoardTypeList;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BoardDTO {

    private int boardCode;
    private String title;
    private String content;
    private int viewCount;
    private LocalDateTime registerDate;
    private LocalDateTime updateDate;
    private LocalDateTime deleteDate;
    private String userRank;
    private String userName;
    private String deptName;
    private String teamName;
    private int userCode;
    private BoardTypeList boardTypeCode;
}
