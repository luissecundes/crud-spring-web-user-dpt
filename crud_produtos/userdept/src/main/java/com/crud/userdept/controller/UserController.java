package com.crud.userdept.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.crud.userdept.entities.User;
import com.crud.userdept.repositories.UserRepository;

@RestController
@RequestMapping(value = "/users")
public class UserController {

	@Autowired
	private UserRepository repository;

	@GetMapping
	public List<User> findAll() {
		List<User> result = repository.findAll();
		return result;
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id) {
		Optional<User> userOptional = repository.findById(id);

		if (userOptional.isPresent()) {
			User result = userOptional.get();
			return ResponseEntity.ok(result);
		} else {
			String response = "VACILOU! Não tem ninguém com esse ID...";
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
		}
	}

	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User user) {
		User result = repository.save(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(result);
	}

	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable Long id) {
		repository.deleteById(id);
	}
}
