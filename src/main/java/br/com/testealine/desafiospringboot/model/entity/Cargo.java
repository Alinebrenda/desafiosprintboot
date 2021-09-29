package br.com.testealine.desafiospringboot.model.entity;

import javax.persistence.Entity;

import br.com.testealine.desafiospringboot.model.base.EntidadeBase;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@AllArgsConstructor
public class Cargo extends EntidadeBase {
	
	private String nomeCargo;

}
