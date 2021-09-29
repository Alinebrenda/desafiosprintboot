package br.com.testealine.desafiospringboot.model.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;

import br.com.testealine.desafiospringboot.model.base.EntidadeBase;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Trabalhador extends EntidadeBase{
	
	private String nome;
	
	private String cpf;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_setor", nullable = false)
	private Setor setor;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_cargo", nullable = false)
	private Cargo cargo;
	
	private String sexo;
	
	private boolean ativo;
	
    @PrePersist
    private void prePersist() {
        ativo = true;
    }


}
