package com.lobo.projetoRacerSpring.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lobo.projetoRacerSpring.domain.Administrador;
import com.lobo.projetoRacerSpring.domain.Pessoa;
import com.lobo.projetoRacerSpring.domain.dtos.AdministradorDTO;
import com.lobo.projetoRacerSpring.repositories.AdministradorRepository;
import com.lobo.projetoRacerSpring.repositories.PessoaRepository;
import com.lobo.projetoRacerSpring.services.exceptions.DataIntegrityViolationException;
import com.lobo.projetoRacerSpring.services.exceptions.ObjectnotFoundException;

@Service
public class AdministradorService {

	@Autowired
	private AdministradorRepository repository;
	@Autowired
	private PessoaRepository pessoaRepository;

	public Administrador findById(Integer id) {
		Optional<Administrador> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundException("Não encontramos o ADM de ID: " + id));
	}

	public List<Administrador> findAll() {
		return repository.findAll();
	}

	public Administrador create(AdministradorDTO objDTO) {
		objDTO.setId(null);
		validaPorCpfEEmail(objDTO);
		Administrador newObj = new Administrador(objDTO);
		return repository.save(newObj);
	}

	public Administrador update(Integer id, @Valid AdministradorDTO objDTO) {
		objDTO.setId(id);
		Administrador oldObj = findById(id);
		validaPorCpfEEmail(objDTO);
		oldObj = new Administrador(objDTO);
		return repository.save(oldObj);
	}

	public void delete(Integer id) {
		Administrador obj = findById(id);
		repository.deleteById(id); 
	}

	private void validaPorCpfEEmail(AdministradorDTO objDTO) {
		Optional<Pessoa> obj = pessoaRepository.findByCpf(objDTO.getCpf());
		if (obj.isPresent() && obj.get().getId() != objDTO.getId()) {
			throw new DataIntegrityViolationException("CPF já está cadastrado em nosso sistema");
		}
		obj = pessoaRepository.findByEmail(objDTO.getEmail());
		if (obj.isPresent() && obj.get().getId() != objDTO.getId()) {
			throw new DataIntegrityViolationException("Email já está cadastrado em nosso sistema");
		}
	}

}
