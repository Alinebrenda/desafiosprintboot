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

import br.com.testealine.desafiospringboot.model.entity.Setor;
import br.com.testealine.desafiospringboot.service.SetorService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value="/setor", produces = "application/json;charset=UTF-8")
@RequiredArgsConstructor
public class SetorController {
	
	@Autowired
	private SetorService service;
	
    @GetMapping
    public List<Setor> listar() {
        return service.listar();
    }
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Setor salvarSetor(@RequestBody Setor setor) {
		return service.salvarSetor(setor);
	}
	
	@PutMapping("/{id}")
	public Setor editarSetor(@PathVariable Long id, @RequestBody Setor setor) {
		return service.editarSetor(id, setor);
	}

}
