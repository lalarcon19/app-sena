package com.example.sena.Service;

import com.example.sena.Dto.UsuarioDTORequest;
import com.example.sena.Dto.UsuarioDTOResponse;

public interface UsuarioService  {

	
	UsuarioDTOResponse createUser (UsuarioDTORequest usuarioDTORequest) ;
	UsuarioDTOResponse readUser (Long id);
	UsuarioDTOResponse update (UsuarioDTORequest usuarioDTORequest);
	UsuarioDTOResponse deleteUser (Long id );
	
	
	
}

