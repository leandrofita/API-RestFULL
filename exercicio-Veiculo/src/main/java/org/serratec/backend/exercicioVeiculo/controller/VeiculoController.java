package org.serratec.backend.exercicioVeiculo.controller;

import java.util.ArrayList;
import java.util.List;

import org.serratec.backend.exercicioVeiculo.domain.Veiculo;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {
	
	private static List<Veiculo> listaVeic = new ArrayList<Veiculo>();
	
	static {
		listaVeic.add(new Veiculo(1,"Volkswagen","Gol"));
		listaVeic.add(new Veiculo(2,"Fiat","Palio"));
		listaVeic.add(new Veiculo(3,"Ford","Ranger"));
	}
	
	@GetMapping
	public List<Veiculo> listar(){
		return listaVeic;
	}
	
	@GetMapping("{id}")
	public Veiculo buscar(@PathVariable int id) {
		
		for (Veiculo veiculo: listaVeic) {
			if(veiculo.getId() == id) {
				return veiculo;
			}
		}
		return null;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	
	public Veiculo inserir(@RequestBody Veiculo veiculo) {
		
		listaVeic.add(veiculo);
		return veiculo;
	}
	@DeleteMapping("{id}")
	
	public String delete(@PathVariable int id) {
		for (Veiculo veiculo: listaVeic) {
			if(veiculo.getId() == id) {
				listaVeic.remove(veiculo);
				String mensagem = "Sucesso!";
				return mensagem;
				
			}
		}
		return null;
		
	}
	
	
	

}
