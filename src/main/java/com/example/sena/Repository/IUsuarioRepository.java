package com.example.sena.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.sena.Entity.Usuario;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {

}
