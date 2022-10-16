package com.board.test.controller;

import com.board.test.boardDto.BoardDto;
import com.board.test.model.Board;
import com.board.test.repository.BoardRepository;
import com.board.test.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;
    private final BoardRepository boardRepository;

    // 게시글 생성
    @PostMapping("/api/boards")
    public Board createBoard(@RequestBody BoardDto boardDto) {

        String title = boardDto.getTitle();
        String content = boardDto.getContent();

        Board board = Board.of(title, content);
        return boardRepository.save(board);
    }

    //게시글 목록 불러오기
    @GetMapping("/api/boards")
    public List<Board> getAllBoards() {
        return boardRepository.findAll();
    }

    //게시글 상세 보기
    @GetMapping("/api/boards/{boardId}")
    public Board getBoard(@PathVariable("boardId") Long boardId) {
        return boardRepository.findById(boardId).orElseThrow(
                () -> new IllegalArgumentException("no boards available")
        );
    }

    //게시글 수정
    @PatchMapping("/api/boards/{boardId}")
    public Board updateBoard(@PathVariable("boardId") Long boardId,
                             @RequestBody BoardDto boardDto) {
        boardService.update(boardId, boardDto);

        return boardRepository.findById(boardId).orElseThrow(
                () -> new IllegalArgumentException("noBoards available")
        );
    }

    //게시글 삭제
    @DeleteMapping("/api/boards/{boardId}")
    public Long deleteBoard(@PathVariable("boardId") Long boardId) {
        boardRepository.deleteById(boardId);
        return boardId;
    }
}
