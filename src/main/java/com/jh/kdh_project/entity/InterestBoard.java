package com.jh.kdh_project.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Table(name="interest_board")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class InterestBoard extends BaseEntity{

    @Id
    @Column(name="interest_code")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int interestCode;

    @Column(name="delete_date")
    private LocalDateTime deleteDate;

    @ManyToOne
    @JoinColumn(name="board_code")
    private Board board;

    @ManyToOne
    @JoinColumn(name="user_code")
    private User user;

    public void changeBoard(Board board) {
        this.board = board;
    }

    public void changeUser(User user) {
        this.user = user;
    }

    public void changeDeleteDate(LocalDateTime deleteDate) {
        this.deleteDate = deleteDate;
    }

    public void changeReplyDeleteDate(LocalDateTime deleteDate) {this.deleteDate=deleteDate;}
}
