package com.board.test;

import com.board.test.model.Board;
import com.board.test.repository.BoardRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class TestApplicationTests {

	@Autowired
	BoardRepository boardRepository;

	@Test
	@DisplayName("select Test")
	void isNotNull(){
		//given

		//when
		List<Board> boards = boardRepository.findAll();

		//then
		Assertions.assertThat(boards).isNotNull();
	}

	@Test
	@DisplayName("board size test")
	void howLarge(){
		//given

		//when
		List<Board> boards = boardRepository.findAll();

		//then
		Assertions.assertThat(boards).isNotNull().hasSize(3);
	}
}
