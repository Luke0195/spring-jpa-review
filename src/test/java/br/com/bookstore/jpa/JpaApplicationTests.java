package br.com.bookstore.jpa;

import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;


import br.com.bookstore.jpa.JpaApplication;

@SpringBootTest
@SpringBootConfiguration
class JpaApplicationTests {

	@Test
	void contextLoads() {
		JpaApplication.main(new String[]{});
	}

}
