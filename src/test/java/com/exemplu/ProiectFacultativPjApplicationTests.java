package com.exemplu;

import com.exemplu.entity.User;
import com.exemplu.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class ProiectFacultativPjApplicationTests {
	@Autowired
	private UserService userService;

	@Test
	public void testPasswordMatching() {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String rawPassword = "password123";
		String encodedPassword = encoder.encode(rawPassword);

		assertTrue(encoder.matches(rawPassword, encodedPassword));
	}


}
