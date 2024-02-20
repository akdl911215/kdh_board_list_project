package com.jh.kdh_project.entity;

import jakarta.persistence.*;
import lombok.*;
import org.checkerframework.checker.compilermsgs.qual.UnknownCompilerMessageKey;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@ToString(exclude = "board")
public class Comment extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_code")
    private int commentCode;

    @Column(name = "content")
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_code")
    private Board board;

    @Column(name = "delete_date", nullable = true)
    private LocalDateTime deleteDate;
}
