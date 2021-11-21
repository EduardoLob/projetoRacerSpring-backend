package com.lobo.projetoRacerSpring.domain;

import java.util.stream.Collectors;

import javax.persistence.Entity;

import com.lobo.projetoRacerSpring.domain.dtos.AdministradorDTO;
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
	
	public Administrador(AdministradorDTO obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.cpf = obj.getCpf();
		this.email = obj.getEmail();
		this.senha = obj.getSenha();
		this.perfis = obj.getPerfis().stream().map(x -> x.getCodigo()).collect(Collectors.toSet());
		this.dataCriacao = obj.getDataCriacao();
	}

	
	
}
