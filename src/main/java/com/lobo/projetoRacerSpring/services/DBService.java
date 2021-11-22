package com.lobo.projetoRacerSpring.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
	@Autowired
	private BCryptPasswordEncoder encoder;

	public void instanciaDB() {
		Administrador adm1 = new Administrador(null, "Eduardo Lobo", "37132003003", "eduardo@mail.com", encoder.encode("123"));
		adm1.addPerfil(Perfil.ADMIN);
		Administrador adm2 = new Administrador(null, "Paulo Gentil", "52363045041", "gentil@mail.com", encoder.encode("123"));
		adm2.addPerfil(Perfil.ADMIN);

		Usuario user1 = new Usuario(null, "Paulo Alberto", "89274377053", "paulo@mail.com", encoder.encode("123"));
		Usuario user2 = new Usuario(null, "Maria Betina", "25547138045", "maria@mail.com", encoder.encode("123"));
		Usuario user3 = new Usuario(null, "Joniscleido Janis", "35166911075", "jonis@mail.com", encoder.encode("123"));
		
		administradorRepository.saveAll(Arrays.asList(adm1, adm2));
		usuarioRepository.saveAll(Arrays.asList(user1, user2, user3));
	}
}
