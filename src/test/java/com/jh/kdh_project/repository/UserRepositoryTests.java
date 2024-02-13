package com.jh.kdh_project.repository;

import com.jh.kdh_project.entity.DayOff;
import com.jh.kdh_project.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

@SpringBootTest
public class UserRepositoryTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void insertUsers() {

        IntStream.rangeClosed(1, 100).forEach(i -> {
            User user = User.builder()
                    .userName("name" + i)
                    .userPw("111")
                    .userRank("A" + i)
                    .build();

            userRepository.save(user);
        });
    }
}
