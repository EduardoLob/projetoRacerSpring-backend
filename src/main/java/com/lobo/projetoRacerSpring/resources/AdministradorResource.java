package com.lobo.projetoRacerSpring.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lobo.projetoRacerSpring.domain.Administrador;
import com.lobo.projetoRacerSpring.domain.dtos.AdministradorDTO;
import com.lobo.projetoRacerSpring.services.AdministradorService;

@RestController
@RequestMapping(value = "/adm")
public class AdministradorResource {

	@Autowired
	private AdministradorService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<AdministradorDTO> findById(@PathVariable Integer id){
		Administrador obj = service.findById(id);
		return ResponseEntity.ok().body(new AdministradorDTO(obj));
	}
}
