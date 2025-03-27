package com.blogApplication.blogApplication;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
public class BlogApplicationTests {

	@Test
	public void contextLoads() {
		// Test will pass if the application context loads successfully
	}
}