package br.com.testealine.desafiospringboot.service;


import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.testealine.desafiospringboot.exception.NegocioException;
import br.com.testealine.desafiospringboot.model.dto.TrabalhadorAtualizadoDTO;
import br.com.testealine.desafiospringboot.model.dto.TrabalhadorDTO;
import br.com.testealine.desafiospringboot.model.entity.Cargo;
import br.com.testealine.desafiospringboot.model.entity.Setor;
import br.com.testealine.desafiospringboot.model.entity.Trabalhador;
import br.com.testealine.desafiospringboot.repository.CargoRepository;
import br.com.testealine.desafiospringboot.repository.SetorRepository;
import br.com.testealine.desafiospringboot.repository.TrabalhadorRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TrabalhadorService {
	
	@Autowired
	private TrabalhadorRepository trabalhadorRepository;
	
	@Autowired
	private SetorRepository setorRepository;
	
	@Autowired
	private CargoRepository cargoRepository;
	
	private ModelMapper mapper = new ModelMapper();
	
    public List<Trabalhador> listar() {
        return trabalhadorRepository.findAll();
    }
	
	public Trabalhador salvartrabalhador(TrabalhadorDTO trabalhadorDTO) {
		if(trabalhadorRepository.existsByCpf(trabalhadorDTO.getCpf())) {
			throw new NegocioException("Trabalhador já cadastrado!");
		}else {
			Trabalhador trabalhador = toEntity(trabalhadorDTO);
			trabalhador = setCagoESetor(trabalhadorDTO, trabalhador);
			return trabalhadorRepository.save(trabalhador);	
		}
	}
	
	public Trabalhador editarTrabalhador(Long id, TrabalhadorDTO trabalhadorDTO) {
		Optional<Trabalhador> trabalhadorOptional = trabalhadorRepository.findById(id);
		Trabalhador trabalhador =  trabalhadorOptional.get();
		trabalhador = setCagoESetor(trabalhadorDTO, trabalhador);
		trabalhador.setId(id);
		return trabalhadorRepository.save(trabalhador);
	}
	
	public Trabalhador desativarTrabalhador(Long id) {
		Optional<Trabalhador> trabalhadorOptional = trabalhadorRepository.findById(id);
		Trabalhador trabalhador =  trabalhadorOptional.get();
		trabalhador.setAtivo(false);
		return trabalhadorRepository.save(trabalhador);
	}
	
    private Trabalhador toEntity(TrabalhadorDTO trabalhadorDTO) {
        return mapper.map(trabalhadorDTO, Trabalhador.class);
    }
    
    private TrabalhadorAtualizadoDTO toModel(TrabalhadorDTO trabalhadorDTO) {
        return mapper.map(trabalhadorDTO, TrabalhadorAtualizadoDTO.class);
    }
    
    private Trabalhador setCagoESetor(TrabalhadorDTO trabalhadorDTO, Trabalhador trabalhador) {
    	Optional<Setor> setor = setorRepository.findById(trabalhadorDTO.getIdSetor());
		Optional<Cargo> cargo = cargoRepository.findById(trabalhadorDTO.getIdCargo());
		trabalhador.setSetor(setor.get());
		trabalhador.setCargo(cargo.get());
		return trabalhador;
    	
    }

}
