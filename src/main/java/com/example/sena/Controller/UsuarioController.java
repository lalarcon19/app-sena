package com.example.sena.Controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.credibanco.dependencia.dto.UserDTORequest;
import com.credibanco.dependencia.dto.UserDTOResponse;
import com.example.sena.Service.UsuarioService;

@RestController
@RequestMapping("users")
public class UsuarioController {
	Logger logger = LoggerFactory.getLogger(UsuarioController.class);

	@Autowired
	UsuarioService usuarioService;

	@PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> createUser(@RequestBody UserDTORequest usuarioDTORequest) {
		Map<String,Object> res = new HashMap<>();
		logger.info("----HttpRequest Create User ----");
		UserDTOResponse response = usuarioService.createUser(usuarioDTORequest);
		res.put("data", response);
		logger.info("----Final de la peticion ----");
		return new ResponseEntity<>(res, HttpStatus.CREATED);

	}

	@GetMapping("/read/{id}")
	public ResponseEntity<Map<String, Object>> readUser(@PathVariable Long id) {
		Map<String,Object> res = new HashMap<>();
		UserDTOResponse userResponse = this.usuarioService.readUser(id);
			if(userResponse != null) {
			res.put("data", userResponse);
			return new ResponseEntity<>(res, HttpStatus.OK);
		}
		res.put("message", "user not found");
		return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);

	}

	@PutMapping("/update")
	public ResponseEntity<Object> updateUser(@RequestBody UserDTORequest usuarioDTORequest) {
		return null;

	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity <Object> deleteUser(@PathVariable Long id) {
		try {
			UserDTOResponse res = usuarioService.deleteUser(id);
			return new ResponseEntity<>(res, HttpStatus.OK);	
			
	}catch(Exception e) {
		logger.info("-----Hubo un error-----");
		
	}
		return null;
	}

}
