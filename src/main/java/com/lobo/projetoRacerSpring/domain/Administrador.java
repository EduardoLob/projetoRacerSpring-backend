package com.lobo.projetoRacerSpring.domain;

import javax.persistence.Entity;

import com.lobo.projetoRacerSpring.domain.enums.Perfil;

@Entity
public class Administrador extends Pessoa {
	private static final long serialVersionUID = 1L;

	public Administrador() {
		super();
		addPerfil(Perfil.USUARIO);
	}

	public Administrador(Integer id, String nome, String cpf, String email, String senha) {
		super(id, nome, cpf, email, senha);
		addPerfil(Perfil.USUARIO);
	}

	
	
}