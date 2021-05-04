package it.objectmethod.world.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.objectmethod.world.dto.LoginDTO;

@RestController
public class LoginController {

	@PostMapping("/login")
	public ResponseEntity<LoginDTO> login(@RequestParam(name = "username", required = false) String username) {
		LoginDTO user = null;
		ResponseEntity<LoginDTO> response = null;
		if (username == null || username.trim().isEmpty()) {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {
			user = new LoginDTO();
			user.setUsername(username);
			response = new ResponseEntity<>(user, HttpStatus.OK);
		}
		return response;
	}
}
