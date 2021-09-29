package br.com.testealine.desafiospringboot.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import br.com.testealine.desafiospringboot.model.base.EntidadeBase;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Setor extends EntidadeBase {
	
	private String nomeSetor;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_setor") 
	private List<Cargo> cargos = new ArrayList<>();

}
