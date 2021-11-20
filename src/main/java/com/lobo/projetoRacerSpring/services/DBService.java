package com.lobo.projetoRacerSpring.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lobo.projetoRacerSpring.domain.Administrador;
import com.lobo.projetoRacerSpring.domain.Usuario;
import com.lobo.projetoRacerSpring.domain.enums.Perfil;
import com.lobo.projetoRacerSpring.repositories.AdministradorRepository;
import com.lobo.projetoRacerSpring.repositories.UsuarioRepository;

@Service
public class DBService {

	@Autowired
	private AdministradorRepository administradorRepository;
	@Autowired
	private UsuarioRepository usuarioRepository;

	public void instanciaDB() {
		Administrador adm1 = new Administrador(null, "Eduardo Lobo", "37132003003", "eduardo@mail.com", "123");
		adm1.addPerfil(Perfil.ADMIN);
		Administrador adm2 = new Administrador(null, "Paulo Gentil", "52363045041", "gentil@mail.com", "123");
		adm2.addPerfil(Perfil.ADMIN);

		Usuario user1 = new Usuario(null, "Paulo Alberto", "89274377053", "paulo@mail.com", "123");

		administradorRepository.saveAll(Arrays.asList(adm1, adm2));
		usuarioRepository.saveAll(Arrays.asList(user1));
	}
}
