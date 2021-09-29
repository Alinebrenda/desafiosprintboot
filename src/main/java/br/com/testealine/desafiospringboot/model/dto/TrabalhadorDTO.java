package br.com.testealine.desafiospringboot.model.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class TrabalhadorDTO implements Serializable {
	
	private static final long serialVersionUID = -9096265832456029171L;

	private String nome;
	
	private String cpf;
	
	private Long idSetor;
	
	private Long idCargo;
	
	private String sexo;

}
