package com.lobo.projetoRacerSpring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lobo.projetoRacerSpring.domain.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

}
