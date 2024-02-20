package com.jh.kdh_project.repository;

import com.jh.kdh_project.entity.BoardTypeList;
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
            BoardTypeList entity = BoardTypeList.builder()
                    .boardType(boardType[i])
                    .build();

            boardTypeRepository.save(entity);
        }
    }
}
