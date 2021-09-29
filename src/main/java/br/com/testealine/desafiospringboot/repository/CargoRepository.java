package br.com.testealine.desafiospringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.testealine.desafiospringboot.model.entity.Cargo;

public interface CargoRepository extends JpaRepository<Cargo, Long> {

}
