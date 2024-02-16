package com.jh.kdh_project.service;

import com.jh.kdh_project.dto.BoardDTO;
import com.jh.kdh_project.dto.PageRequestDTO;
import com.jh.kdh_project.dto.PageResultDTO;
import com.jh.kdh_project.dto.UserDTO;
import com.jh.kdh_project.entity.Board;
import com.jh.kdh_project.entity.User;
import org.apache.coyote.BadRequestException;

public interface BoardService {

    BoardDTO update(BoardDTO boardDTO, UserDTO userDTO);

    BoardDTO register(BoardDTO boardDTO, UserDTO userDTO);

    BoardDTO read(Integer boardCode);

    PageResultDTO<BoardDTO, Board> getList(PageRequestDTO pageRequestDTO);

    BoardDTO remove(Integer boardCode);

    default Board updateDtoToEntity(BoardDTO boardDTO, UserDTO userDTO) {
        User user = User.builder()
                .userCode(userDTO.getUserCode())
                .build();

        Board board = Board.builder()
                .boardCode(boardDTO.getBoardCode())
                .title(boardDTO.getTitle())
                .content(boardDTO.getContent())
                .viewCount(boardDTO.getViewCount())
                .boardType(boardDTO.getBoardTypeCode())
                .user(user)
                .build();

        return board;
    }

    default Board registerDtoToEntity(BoardDTO boardDTO, UserDTO userDTO) {
        User user = User.builder()
                .userCode(userDTO.getUserCode())
                .build();

        Board board = Board.builder()
                .title(boardDTO.getTitle())
                .content(boardDTO.getContent())
                .viewCount(boardDTO.getViewCount())
                .boardType(boardDTO.getBoardTypeCode())
                .user(user)
                .build();

        return board;
    }

    default BoardDTO updateEntityToDto(Board board) {
        BoardDTO dto = BoardDTO.builder()
                .boardCode(board.getBoardCode())
                .title(board.getTitle())
                .content(board.getContent())
                .registerDate(board.getRegisterDate())
                .deleteDate(board.getDeleteDate())
                .updateDate(board.getUpdateDate())
                .userRank(board.getUser().getUserRank())
                .userName(board.getUser().getUserName())
                .userCode(board.getUser().getUserCode())
                .boardTypeCode(board.getBoardType())
                .build();

        return dto;
    }

    default BoardDTO registerEntityToDto(Board board) {
        BoardDTO dto = BoardDTO.builder()
                .title(board.getTitle())
                .content(board.getContent())
                .viewCount(board.getViewCount())
                .registerDate(board.getRegisterDate())
                .deleteDate(board.getDeleteDate())
                .updateDate(board.getUpdateDate())
                .userRank(board.getUser().getUserRank())
                .userName(board.getUser().getUserName())
//                .teamName(board.getUser().getTeam().getTeamName())
                .userCode(board.getUser().getUserCode())
                .boardTypeCode(board.getBoardType())
                .build();

        return dto;
    }

    default BoardDTO entityToDto(Board entity) {
        BoardDTO boardDTO = BoardDTO.builder()
                .boardCode(entity.getBoardCode())
                .title(entity.getTitle())
                .content(entity.getContent())
                .viewCount(entity.getViewCount())
                .registerDate(entity.getRegisterDate())
                .updateDate(entity.getUpdateDate())
                .deleteDate(entity.getDeleteDate())
                .userRank(entity.getUser().getUserRank())
                .userName(entity.getUser().getUserName())
                .deptName(entity.getUser().getTeam().getDepartment().getDeptName())
                .teamName(entity.getUser().getTeam().getTeamName())
                .userCode(entity.getUser().getUserCode())
                .boardTypeCode(entity.getBoardType())
                .build();

        return boardDTO;
    }

}
