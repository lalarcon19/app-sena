package com.example.sena.Service.Impl;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sena.Dto.UsuarioDTORequest;
import com.example.sena.Dto.UsuarioDTOResponse;
import com.example.sena.Entity.Usuario;
import com.example.sena.Repository.IUsuarioRepository;
import com.example.sena.Service.UsuarioService;

@Service
public class UsuarioImpl implements UsuarioService {
	Logger logger = LoggerFactory.getLogger(UsuarioImpl.class);

	@Autowired
	IUsuarioRepository userRepo;

	@Override
	public UsuarioDTOResponse createUser(UsuarioDTORequest usuarioDTORequest) {
		// TODO Auto-generated method stub
		logger.info("---llego al service--");

		Usuario entity = new Usuario();
		entity.setId(usuarioDTORequest.getId());
		entity.setUserName(usuarioDTORequest.getUserName());
		entity.setPassword(usuarioDTORequest.getPassword());
		entity = userRepo.save(entity);

		logger.info("--Registro en base de datos--");

		UsuarioDTOResponse response = new UsuarioDTOResponse();
		response.setId(entity.getId());
		response.setPassword(entity.getPassword());
		response.setUserName(entity.getUserName());
		logger.info("--termino al proceso del service");
		return response;
	}

	@Override
	public UsuarioDTOResponse readUser(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UsuarioDTOResponse update(UsuarioDTORequest usuarioDTORequest) {
		// TODO Auto-generated method stub
		return null;
	}

	// @Override
	// public UsuarioDTOResponse deleteUser(UsuarioDTORequest usuarioDTORequest) {
	// TODO Auto-generated method stub
	// return null;
	// }

	@Override
	public UsuarioDTOResponse deleteUser(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
