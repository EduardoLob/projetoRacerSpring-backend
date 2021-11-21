package com.lobo.projetoRacerSpring.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.lobo.projetoRacerSpring.domain.Usuario;
import com.lobo.projetoRacerSpring.domain.Pessoa;
import com.lobo.projetoRacerSpring.domain.dtos.UsuarioDTO;
import com.lobo.projetoRacerSpring.repositories.UsuarioRepository;
import com.lobo.projetoRacerSpring.repositories.PessoaRepository;
import com.lobo.projetoRacerSpring.services.exceptions.DataIntegrityViolationException;
import com.lobo.projetoRacerSpring.services.exceptions.ObjectnotFoundException;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;
	@Autowired
	private PessoaRepository pessoaRepository;
	@Autowired
	private BCryptPasswordEncoder encoder;

	public Usuario findById(Integer id) {
		Optional<Usuario> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundException("Não encontramos o usuario de ID: " + id));
	}

	public List<Usuario> findAll() {
		return repository.findAll();
	}

	public Usuario create(UsuarioDTO objDTO) {
		objDTO.setId(null);
		objDTO.setSenha(encoder.encode(objDTO.getSenha()));
		validaPorCpfEEmail(objDTO);
		Usuario newObj = new Usuario(objDTO);
		return repository.save(newObj);
	}

	public Usuario update(Integer id, @Valid UsuarioDTO objDTO) {
		objDTO.setId(id);
		Usuario oldObj = findById(id);
		validaPorCpfEEmail(objDTO);
		oldObj = new Usuario(objDTO);
		return repository.save(oldObj);
	}

	public void delete(Integer id) {
		Usuario obj = findById(id);
		repository.deleteById(id); 
	}

	private void validaPorCpfEEmail(UsuarioDTO objDTO) {
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
