package com.jh.kdh_project.service;

import com.jh.kdh_project.dto.BoardDTO;
import com.jh.kdh_project.dto.UserDTO;
import com.jh.kdh_project.entity.User;
import com.jh.kdh_project.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class BoardServiceTests {

    @Autowired
    private BoardService boardService;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testRegister() {

        Integer userId = (int)(Math.random() * 99) + 2;
        Optional<User> result = userRepository.findById(userId);

        if (result.isPresent()) {
            User user = result.get();
            System.out.println("user : " + user);
            System.out.println("user.getTeam() : " + user.getTeam());
            System.out.println("user.getTeam().getDepartment().getDeptName() : " + user.getTeam().getDepartment().getDeptName());
            System.out.println("user.getTeam().getTeamName() : " + user.getTeam().getTeamName());

            UserDTO userDTO = UserDTO.builder()
                    .userCode(user.getUserCode())
                    .userRank(user.getUserRank())
                    .deptName(user.getTeam().getDepartment().getDeptName())
                    .teamName(user.getTeam().getTeamName())
                    .userName(user.getUserName())
                    .build();

            BoardDTO boardDTO = BoardDTO.builder()
                    .title("sample title")
                    .content("sample content")
                    .viewCount(userId)
                    .userName(user.getUserName())
                    .userRank(user.getUserRank())
                    .userCode(user.getUserCode())
                    .deptName(userDTO.getDeptName())
                    .teamName(userDTO.getTeamName())
                    .boardTypeCode(1)
                    .build();

            BoardDTO response = boardService.register(boardDTO, userDTO);
            System.out.println(response);
        }

    }
}
