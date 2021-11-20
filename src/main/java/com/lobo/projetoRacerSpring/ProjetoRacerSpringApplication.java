package com.lobo.projetoRacerSpring;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.lobo.projetoRacerSpring.domain.Administrador;
import com.lobo.projetoRacerSpring.domain.Usuario;
import com.lobo.projetoRacerSpring.domain.enums.Perfil;
import com.lobo.projetoRacerSpring.repositories.AdministradorRepository;
import com.lobo.projetoRacerSpring.repositories.UsuarioRepository;

@SpringBootApplication
public class ProjetoRacerSpringApplication implements CommandLineRunner {

	@Autowired
	private AdministradorRepository administradorRepository;
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ProjetoRacerSpringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Administrador adm1 = new Administrador(null, "Eduardo Lobo", "37132003003", "eduardo@mail.com", "123");
		adm1.addPerfil(Perfil.ADMIN);
		
		Usuario user1 = new Usuario(null, "Paulo Alberto", "89274377053", "paulo@mail.com", "123");
		
		administradorRepository.saveAll(Arrays.asList(adm1));
		usuarioRepository.saveAll(Arrays.asList(user1));
	}

}
