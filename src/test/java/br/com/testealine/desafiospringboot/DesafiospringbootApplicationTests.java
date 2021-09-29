package br.com.testealine.desafiospringboot;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.testealine.desafiospringboot.controller.SetorController;
import br.com.testealine.desafiospringboot.controller.TrabalhadorController;
import br.com.testealine.desafiospringboot.model.dto.TrabalhadorDTO;
import br.com.testealine.desafiospringboot.model.entity.Cargo;
import br.com.testealine.desafiospringboot.model.entity.Setor;

@SpringBootTest
class DesafiospringbootApplicationTests {
	
	private Setor setor = new Setor();
	private SetorController setorController = new SetorController();
	
	private TrabalhadorDTO trabalhadorDTO = new TrabalhadorDTO();
	private TrabalhadorController trabalhadorController = new TrabalhadorController();

	@Test
	void contextLoads() {
	}
	
	@Test
	public void salvarSetor() {
		List<Cargo> cargos = Arrays.asList(new Cargo("ASSISTENTE ADMINISTRATIVO"), new Cargo("ANALISTA ADMINISTRATIVO"));
		setor.setNomeSetor("ADMINISTRATIVO");
		setor.setCargos(cargos);
		setorController.salvarSetor(setor);
	}
	
	public void salvarTrabalhador() {
		trabalhadorDTO.setNome("Aline");
		trabalhadorDTO.setCpf("12312312387");
		trabalhadorDTO.setSexo("FEMININO");
		trabalhadorDTO.setIdCargo(1L);
		trabalhadorDTO.setIdCargo(2L);
		
		
		
	}

}