package com.jh.kdh_project.service;

import com.jh.kdh_project.dto.BoardDTO;
import com.jh.kdh_project.dto.PageRequestDTO;
import com.jh.kdh_project.dto.PageResultDTO;
import com.jh.kdh_project.dto.UserDTO;
import com.jh.kdh_project.entity.Board;
import com.jh.kdh_project.entity.BoardType;
import com.jh.kdh_project.entity.User;
import com.jh.kdh_project.repository.BoardTypeRepository;
import com.jh.kdh_project.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@SpringBootTest
public class BoardServiceTests {

    @Autowired
    private BoardService boardService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BoardTypeRepository boardTypeRepository;

    @Transactional
    @Test
    public void testRemove() {

        Integer boardCode = 106;

        BoardDTO response = boardService.remove(boardCode);
        System.out.println(response);
    }

    @Transactional
    @Test
    public void testSearch() {
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
                .page(1)
                .size(10)
                .type("c")
                .keyword("1")
                .build();

        PageResultDTO<BoardDTO, Board> resultDTO = boardService.getList(pageRequestDTO);

        System.out.println("PREV : " + resultDTO.isPrev());
        System.out.println("NEXT : " + resultDTO.isNext());
        System.out.println("TOTAL : " + resultDTO.getTotalPage());

        System.out.println("-----------------------------------");
        for (BoardDTO boardDTO: resultDTO.getDtoList()) {
            System.out.println(boardDTO);
        }
        System.out.println("-----------------------------------");

        resultDTO.getPageList().forEach(i -> System.out.println(i));
    }

    @Transactional
    @Test
    public void testList() {

        PageRequestDTO pageRequestDTO = PageRequestDTO.builder().page(1).size(10).build();

        PageResultDTO<BoardDTO, Board> resultDTO = boardService.getList(pageRequestDTO);

        System.out.println("PREV : " + resultDTO.isPrev());
        System.out.println("NEXT : " + resultDTO.isNext());
        System.out.println("TOTAL : " + resultDTO.getTotalPage());

        System.out.println("-----------------------------------");
        for (BoardDTO boardDTO: resultDTO.getDtoList()) {
            System.out.println(boardDTO);
        }
        System.out.println("-----------------------------------");

        resultDTO.getPageList().forEach(i -> System.out.println(i));
    }

    @Transactional
    @Test
    public void testRead() {
        Integer boardCode = 10;
        BoardDTO response = boardService.read(boardCode);
        System.out.println(response);

    }

    @Test
    public void testUpdate() {
        Integer userCode = 66;
        Optional<User> result = userRepository.findById(userCode);

        if (result.isPresent()) {
            User user = result.get();

            UserDTO userDTO = UserDTO.builder()
                    .userCode(user.getUserCode())
                    .userRank(user.getUserRank())
                    .deptName(user.getTeam().getDepartment().getDeptName())
                    .teamName(user.getTeam().getTeamName())
                    .userName(user.getUserName())
                    .build();

            Optional<BoardType> boardType = boardTypeRepository.findById(1);
            BoardType type = boardType.get();

            BoardDTO boardDTO = BoardDTO.builder()
                    .boardCode(1)
                    .title("update title")
                    .content("update content")
                    .viewCount(userCode)
                    .userName(user.getUserName())
                    .userRank(user.getUserRank())
                    .userCode(user.getUserCode())
                    .deptName(user.getTeam().getDepartment().getDeptName())
                    .teamName(user.getTeam().getTeamName())
                    .boardTypeCode(type)
                    .build();

            BoardDTO response = boardService.update(boardDTO, userDTO);
            System.out.println(response);
        }
    }

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

            Optional<BoardType> boardType = boardTypeRepository.findById(1);
            BoardType type = boardType.get();

            BoardDTO boardDTO = BoardDTO.builder()
                    .title("sample title")
                    .content("sample content")
                    .viewCount(userId)
                    .userName(user.getUserName())
                    .userRank(user.getUserRank())
                    .userCode(user.getUserCode())
                    .deptName(userDTO.getDeptName())
                    .teamName(userDTO.getTeamName())
                    .boardTypeCode(type)
                    .build();

            BoardDTO response = boardService.register(boardDTO, userDTO);
            System.out.println(response);
        }

    }
}
