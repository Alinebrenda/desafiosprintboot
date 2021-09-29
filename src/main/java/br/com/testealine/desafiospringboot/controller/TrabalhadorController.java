package br.com.testealine.desafiospringboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.testealine.desafiospringboot.model.dto.TrabalhadorDTO;
import br.com.testealine.desafiospringboot.model.entity.Trabalhador;
import br.com.testealine.desafiospringboot.service.TrabalhadorService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value="/trabalhador", produces = "application/json;charset=UTF-8")
@RequiredArgsConstructor
public class TrabalhadorController {
	
	@Autowired
	private TrabalhadorService service;
	
    @GetMapping
    public List<Trabalhador> listar() {
        return service.listar();
    }
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Trabalhador salvarTrabalhador(@RequestBody TrabalhadorDTO trabalhadorDTO) {
		return service.salvartrabalhador(trabalhadorDTO);
	}
	
	@PutMapping("/{id}")
	public Trabalhador editarTrabalhador(@PathVariable Long id, @RequestBody TrabalhadorDTO trabalhadorDTO) {
		return service.editarTrabalhador(id, trabalhadorDTO);
	}
	
	@PutMapping("/desativar/{idTrabalhador}")
	public Trabalhador desativarTrabalhador(@PathVariable Long idTrabalhador) {
		return service.desativarTrabalhador(idTrabalhador);
	}

}