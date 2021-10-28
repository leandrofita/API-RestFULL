package org.serratec.java2backend.exercicio02.controller;

import java.util.List;
import java.util.Optional;

import org.serratec.java2backend.exercicio02.ProdutoRepository;
import org.serratec.java2backend.exercicio02.domain.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository produtoRepository;

	@GetMapping
	public List<Produto> listar() {
		return produtoRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Produto> pesquisar(@PathVariable Long id) {
	Optional<Produto> produto = produtoRepository.findById(id);
	if (produto.isPresent()) {
		return ResponseEntity.ok(produto.get());
	}
	return ResponseEntity.notFound().build();
	}


	@PostMapping
	public Produto inserir(@RequestBody Produto produto) {
	return produtoRepository.save(produto);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> remover(@PathVariable Long id) {
	if (!produtoRepository.existsById(id)) {
	return ResponseEntity.notFound().build();
		}
	produtoRepository.deleteById(id);
	return ResponseEntity.noContent().build();
		
	}
}