package br.com.testealine.desafiospringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.testealine.desafiospringboot.model.entity.Setor;

public interface SetorRepository extends JpaRepository<Setor, Long> {
	
	boolean existsByNomeSetor(String nome);

}
