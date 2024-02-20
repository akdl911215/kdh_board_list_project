package com.jh.kdh_project.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString(exclude = "user")
@Builder
public class Board extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_code")
    private int boardCode;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "view_count")
    private int viewCount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_code")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_type_code")
    private BoardTypeList boardType;

    @Column(name = "delete_date", nullable = true)
    private LocalDateTime deleteDate;

    public void changeBoardCode(int boardCode) {
        this.boardCode = boardCode;
    }

    public void changeTitle(String title) {
        this.title = title;
    }

    public void changeContent(String content) {
        this.content = content;
    }

    public void changeViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    public void changeBoardDeletedAt(LocalDateTime deleteDate) { this.deleteDate = deleteDate; }

}