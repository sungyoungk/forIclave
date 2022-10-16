package com.board.test.boardDto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class BoardDto {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardId;

    private String title;
    private String content;

    public BoardDto(Long boardId, String title, String content) {
        this.boardId = boardId;
        this.title = title;
        this.content = content;

    }
}
