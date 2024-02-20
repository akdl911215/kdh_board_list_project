package com.jh.kdh_project.repository;

import com.jh.kdh_project.entity.Board;
import com.jh.kdh_project.entity.BoardTypeList;
import com.jh.kdh_project.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
public class BoardRepositoryTests {

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private BoardTypeRepository boardTypeRepository;

    @Test
    public void testListPage() {
    }

    @Test
    public void insertBoards() {

        IntStream.rangeClosed(1, 100).forEach(i -> {

            Integer userId = (int)(Math.random() * 99) + 2;
            User user = User.builder().userCode(userId).build();

            Integer boardTypeCode = (int)(Math.random() * 3) + 1;
            Optional<BoardTypeList> boardTypeList = boardTypeRepository.findById(boardTypeCode);
            BoardTypeList boardType = boardTypeList.get();

            Board board = Board.builder()
                    .title("title" + i)
                    .content("content" + i)
                    .viewCount(userId)
                    .boardType(boardType)
                    .user(user)
                    .build();

            boardRepository.save(board);
        });
    }
}
