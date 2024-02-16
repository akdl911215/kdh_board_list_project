package com.jh.kdh_project.service;

import com.jh.kdh_project._common.exception.NotFoundException;
import com.jh.kdh_project.dto.BoardDTO;
import com.jh.kdh_project.dto.PageRequestDTO;
import com.jh.kdh_project.dto.PageResultDTO;
import com.jh.kdh_project.dto.UserDTO;
import com.jh.kdh_project.entity.Board;
import com.jh.kdh_project.entity.QBoard;
import com.jh.kdh_project.repository.BoardRepository;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.function.Function;


@Service
@Log4j2
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;

    @Override
    public BoardDTO remove(Integer boardCode) {

        Optional<Board> board = boardRepository.findById(boardCode);

        if (!board.isPresent()) {
            throw new NotFoundException("NOTFOUND BOARD");
        }

        Board entity = board.get();

        LocalDateTime dateTime = LocalDateTime.now();
        entity.changeBoardDeletedAt(dateTime);
        System.out.println("entity : " + entity);

        Board convertBoard = boardRepository.save(entity);
        System.out.println("convertBoard : " + convertBoard);

        BoardDTO response = entityToDto(convertBoard);
        System.out.println("response : " + response);
        return response;
    }

    @Override
    public BoardDTO read(Integer boardCode) throws NotFoundException {

        Optional<Board> board = boardRepository.findById(boardCode);

        if (!board.isPresent()) {
            throw new NotFoundException("NOTFOUND BOARD");
        }

        Board entity = board.get();

        return entityToDto(entity);
    }

    @Override
    public BoardDTO update(BoardDTO boardDTO, UserDTO userDTO) {

        Board entity = updateDtoToEntity(boardDTO, userDTO);

        boardRepository.save(entity);

        BoardDTO convertDto = updateEntityToDto(entity);

        return convertDto;
    }

    @Override
    public BoardDTO register(BoardDTO boardDTO, UserDTO userDTO) {

        Board entity = registerDtoToEntity(boardDTO, userDTO);

        boardRepository.save(entity);

        BoardDTO convertDto = registerEntityToDto(entity);

        return convertDto;
    }

    @Override
    public PageResultDTO<BoardDTO, Board> getList(PageRequestDTO pageRequestDTO) {

        Pageable pageable = pageRequestDTO.getPageable(Sort.by("boardCode").descending());

        BooleanBuilder booleanBuilder = getSearch(pageRequestDTO);

        Page<Board> result = boardRepository.findAll(booleanBuilder, pageable); // Querydsl 사용

        Function<Board, BoardDTO> fn = (entity -> entityToDto(entity));

        return new PageResultDTO<>(result, fn);
    }


    private BooleanBuilder getSearch(PageRequestDTO pageRequestDTO) {
        // Querydsl 처리

        String type = pageRequestDTO.getType();

        BooleanBuilder booleanBuilder = new BooleanBuilder();

        QBoard qBoard = QBoard.board;

        String keyword = pageRequestDTO.getKeyword();

        BooleanExpression expression = qBoard.boardCode.gt(0);
        // boardCode > 0

        booleanBuilder.and(expression);

        if (type == null || type.trim().length() == 0) {

            // 검색 조건이 없는 경우
            return booleanBuilder;
        }

        // 검색 조건을 작성하기
        BooleanBuilder conditionBuilder = new BooleanBuilder();

        if (type.contains("t")) { // 제목
            conditionBuilder.or(qBoard.title.contains(keyword));
        }
        if (type.contains("c")) { // 내용
            conditionBuilder.or(qBoard.title.contains(keyword));
        }
        if (type.contains("w")) { // 작성자
            conditionBuilder.or(qBoard.title.contains(keyword));
        }

        // 모든 조건 통합
        booleanBuilder.and(conditionBuilder);

        return booleanBuilder;
    }
}
