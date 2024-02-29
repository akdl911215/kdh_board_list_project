package com.jh.kdh_project.controller;

import com.jh.kdh_project.dto.BoardDTO;
import com.jh.kdh_project.dto.PageRequestDTO;
import com.jh.kdh_project.dto.PageResultDTO;
import com.jh.kdh_project.dto.UserDTO;
import com.jh.kdh_project.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/board")
@Log4j2
@RequiredArgsConstructor
@CrossOrigin("/*")
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/list")
    private PageResultDTO list(PageRequestDTO pageRequestDTO) {
        log.info("list pageRequestDTO : " + pageRequestDTO);

        PageResultDTO pageResultDTO = boardService.getList(pageRequestDTO);
        log.info("pageResultDTO : " + pageResultDTO);

        return pageResultDTO;
    }

    @PostMapping("/register")
    private BoardDTO register(@RequestBody BoardDTO boardDTO, UserDTO userDTO) {
        log.info("register boardDTO : " + boardDTO + " / userDTO : " + userDTO);

        BoardDTO response = boardService.register(boardDTO, userDTO);
        log.info("response : " + response);

        return response;
    }

    @PatchMapping("/update")
    private BoardDTO update(@RequestBody BoardDTO boardDTO, UserDTO userDTO) {
        log.info("boardDTO : " + boardDTO + " / userDTO : " + userDTO);

        BoardDTO response = boardService.update(boardDTO, userDTO);
        log.info("response : " + response);

        return response;
    }

    @PatchMapping("/remove")
    private BoardDTO remove(@RequestBody Integer id) {
        log.info("remove id : " + id);

        BoardDTO boardDTO = boardService.remove(id);
        log.info("boardDTO : " + boardDTO);

        return boardDTO;
    }

    @GetMapping("/read/{id}")
    private BoardDTO read(@PathVariable("id") Integer id) {
        log.info("read id : " + id);

        BoardDTO response = boardService.read(id);
        log.info("response!!!! : " + response);

        return response;
    }
}
