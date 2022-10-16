package com.board.test.service;

import com.board.test.boardDto.BoardDto;
import com.board.test.model.Board;
import com.board.test.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service @RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional
    public Long update(Long boardId, BoardDto boardDto) {

        Board board = boardRepository.findById(boardId).orElseThrow(
                () -> new NullPointerException("no contents available")
        );
        board.updateBoard(boardDto);
        return board.getId();
    }
}
