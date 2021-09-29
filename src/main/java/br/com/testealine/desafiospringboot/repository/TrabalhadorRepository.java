package br.com.testealine.desafiospringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.testealine.desafiospringboot.model.entity.Trabalhador;

public interface TrabalhadorRepository extends JpaRepository<Trabalhador, Long> {
	
	boolean existsByCpf(String cpf);
	
}
