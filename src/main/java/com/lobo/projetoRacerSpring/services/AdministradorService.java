package com.lobo.projetoRacerSpring.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lobo.projetoRacerSpring.domain.Administrador;
import com.lobo.projetoRacerSpring.repositories.AdministradorRepository;

@Service
public class AdministradorService {

	@Autowired
	private AdministradorRepository repository;
	
	public Administrador findById(Integer id) {
		Optional<Administrador> obj = repository.findById(id);
		return obj.orElse(null);
	}
}
