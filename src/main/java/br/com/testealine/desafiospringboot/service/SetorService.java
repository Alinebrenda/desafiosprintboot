package br.com.testealine.desafiospringboot.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.testealine.desafiospringboot.exception.NegocioException;
import br.com.testealine.desafiospringboot.model.entity.Setor;
import br.com.testealine.desafiospringboot.repository.SetorRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SetorService {
	
	@Autowired
	private SetorRepository repository;
	
    public List<Setor> listar() {
        return repository.findAll();
    }
	
	public Setor salvarSetor(Setor setor) {
		if(repository.existsByNomeSetor(setor.getNomeSetor())) {
			throw new NegocioException("O Nome do setor já existe");
		}else {		
			return repository.save(setor);	
		}
	}
	
	public Setor editarSetor(Long id, Setor setor) {
		Optional<Setor> setorOptional = repository.findById(id);
		Setor setorAtualizado =  setorOptional.get();
		setorAtualizado.setNomeSetor(setor.getNomeSetor());
		return repository.save(setorAtualizado);
	}

}
