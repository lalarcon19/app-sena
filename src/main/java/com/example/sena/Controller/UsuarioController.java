package com.example.sena.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sena.Dto.UsuarioDTORequest;
import com.example.sena.Dto.UsuarioDTOResponse;
import com.example.sena.Service.Impl.UsuarioImpl;

@RestController
@RequestMapping("users")
public class UsuarioController {
	Logger logger = LoggerFactory.getLogger(UsuarioController.class);

	@Autowired
	UsuarioImpl userimpl;

	@PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> createUser(@RequestBody UsuarioDTORequest usuarioDTORequest) {

		logger.info("----HttpRequest Create User ----");
		UsuarioDTOResponse response = userimpl.createUser(usuarioDTORequest);
		logger.info("----Final de la peticion ----");

		return ResponseEntity.ok(response);

	}

	@GetMapping("/read")
	public ResponseEntity<Object> readUser(@PathVariable Long id) {

		return null;

	}

	@PutMapping("/update")
	public ResponseEntity<Object> updateUser(@RequestBody UsuarioDTORequest usuarioDTORequest) {
		return null;

	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deleteUser(@PathVariable Long id) {
		return null;
	}

}
