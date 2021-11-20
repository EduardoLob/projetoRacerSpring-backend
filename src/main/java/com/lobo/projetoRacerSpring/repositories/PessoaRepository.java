package com.lobo.projetoRacerSpring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lobo.projetoRacerSpring.domain.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

}
