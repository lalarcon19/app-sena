package com.example.sena.Service;

import org.springframework.stereotype.Service;

import com.credibanco.dependencia.dto.UserDTORequest;
import com.credibanco.dependencia.dto.UserDTOResponse;

@Service
public interface UsuarioService  {
	UserDTOResponse createUser (UserDTORequest usuarioDTORequest) ;
	UserDTOResponse readUser (Long id);
	UserDTOResponse updateUser (Long id, UserDTORequest usuarioDTORequest);
	UserDTOResponse deleteUser (Long id );
	
}

