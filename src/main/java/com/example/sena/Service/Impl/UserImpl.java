package com.example.sena.Service.Impl;

import java.util.Optional;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.credibanco.dependencia.dto.UserDTORequest;
import com.credibanco.dependencia.dto.UserDTOResponse;
import com.example.sena.Entity.Usuario;
import com.example.sena.Repository.IUserRepository;
import com.example.sena.Service.UsuarioService;
import static com.credibanco.dependencia.Utils.NumberCard.convertNumber;

@Service
public class UserImpl implements UsuarioService{
	Logger logger = LoggerFactory.getLogger(UserImpl.class);
  
	@Autowired
	IUserRepository userRepo;
	
     
	@Override
	public UserDTOResponse createUser(UserDTORequest usuarioDTORequest) {
		UserDTOResponse response = new UserDTOResponse();
		Usuario entity = new Usuario();
		
		try {
			
			logger.info("---llego al service--");		
			entity.setId(usuarioDTORequest.getId());
			entity.setUserName(usuarioDTORequest.getUserName());
			entity.setPassword(usuarioDTORequest.getPassword());
			entity.setCardNumber(convertNumber(usuarioDTORequest));
			entity = userRepo.save(entity);
			
			logger.info("--Registro en base de datos--");
			
			response.setId(entity.getId());
			response.setUserName(entity.getUserName());
			response.setPassword(entity.getPassword());
			response.setCardNumber(entity.getCardNumber());
			logger.info("--termino al proceso del service");
			System.out.println(response.getId());
			return response;
			
			
		} catch(Exception e) {
			logger.error("----Error al crear un nuevo usuario");
		}
		
		return null;
	}
		

	@Override
	public UserDTOResponse readUser(Long id) {
		UserDTOResponse userResponse = new UserDTOResponse();
		Usuario user= userRepo.getUserById(id);
	try {	
		if(user.getId() == id) {
	        userResponse.setId(user.getId());	 
	        userResponse.setUserName(user.getUserName());
	        userResponse.setPassword(user.getPassword());
	        userResponse.setCardNumber(user.getCardNumber());
		}
		return userResponse;
		
	}catch (Exception e){
		logger.info("no se encontro usuario"+ e);
	
	}
	return null;
	}

	@Override
	public UserDTOResponse updateUser(Long id, UserDTORequest usuarioDTORequest) {
		UserDTOResponse userDTOResponse= new UserDTOResponse();
		Usuario user= userRepo.getUserById(id);
	
		try {
	        if(user.getId() == id) {
	        user.setId(usuarioDTORequest.getId());
	        user.setUserName(usuarioDTORequest.getUserName());
	        user.setPassword(usuarioDTORequest.getPassword());
	        
	        userRepo.save(user);
	        logger.info("----Se actualizo en la base de datos---");	        
	        userDTOResponse.setId(user.getId());
	        userDTOResponse.setUserName(user.getUserName());
	        userDTOResponse.setPassword(user.getPassword());
	        logger.info("----El usuario se actualizo----");
	        return userDTOResponse;
	        }
	            
		} catch(Exception e) {
	        logger.info("----No se actualizo el usuario" +e);
	    }
			
		return null;
	}
	@Override
	public UserDTOResponse deleteUser(Long id) {

		UserDTOResponse response = new UserDTOResponse();
		try {
			logger.info("-------Entro a la base de datos------- ");
			Optional<Usuario> usuarioDelete = userRepo.findById(id);

			if (usuarioDelete != null) {
				userRepo.deleteById(id);
			}
			logger.info("-----El ususario ha sido eliminado-------- ");

		} catch (Exception e) {
			logger.info("-----Error----" + e);
		}
		return null;
	}
	

	
}
