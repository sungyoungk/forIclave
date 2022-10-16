package com.board.test.model;

import com.board.test.boardDto.BoardDto;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity @Table(name = "board")
@NoArgsConstructor @Getter
@ToString
public class Board extends TimeStamped {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id")
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String content;

    // 생성자
    private Board(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public static Board of(String title, String content) {
        return new Board(title, content);
    }

    // 게시글 수정 메소드
    public void updateBoard(BoardDto boardDto) {
        this.title = boardDto.getTitle();
        this.content = boardDto.getContent();
    }




}
