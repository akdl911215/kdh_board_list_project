package com.jh.kdh_project.repository;

import com.jh.kdh_project.entity.BoardType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BoardTypeRepositoryTests {

    @Autowired
    private BoardTypeRepository boardTypeRepository;

    @Test
    public void insertBoardType() {

        String[] boardType = {"boardType1", "boardType2", "boardType3"};

        for (int i = 0; i < 3; ++i) {
            BoardType entity = BoardType.builder()
                    .boardType(boardType[i])
                    .build();

            boardTypeRepository.save(entity);
        }
    }
}
