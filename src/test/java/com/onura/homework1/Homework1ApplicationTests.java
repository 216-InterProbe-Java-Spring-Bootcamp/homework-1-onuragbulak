package com.onura.homework1;

import com.onura.homework1.repository.ProductCommentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Homework1ApplicationTests {

	@Autowired
	ProductCommentRepository productCommentRepository;


	@Test
	void contextLoads() {
	}

}
