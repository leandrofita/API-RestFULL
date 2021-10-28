package org.serratec.java2backend.exercicio02.controller;


	
	import java.util.List;
	import java.util.Optional;

	import org.serratec.java2backend.exercicio02.ClienteRepository;
	import org.serratec.java2backend.exercicio02.domain.Cliente;
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
	@RequestMapping("/clientes")
	public class ClienteControler {
		
		@Autowired
		private ClienteRepository clienteRepository;

		@GetMapping /*método para listar todos*/
		public List<Cliente> listar() {
			return clienteRepository.findAll();
		}

		@GetMapping("/{id}") /* método para listar por id */
		public ResponseEntity<Cliente> pesquisar(@PathVariable Long id) {
		Optional<Cliente> cliente = clienteRepository.findById(id);
		if (cliente.isPresent()) {
			return ResponseEntity.ok(cliente.get());
		}
		return ResponseEntity.notFound().build();
		}


		@PostMapping /* método para inserir */
		public Cliente inserir(@RequestBody Cliente cliente) {
		return clienteRepository.save(cliente);
		}
		
		/*@PutMapping*/
		
		@DeleteMapping("/{id}") /* método para deletar por id*/
		public ResponseEntity<Void> remover(@PathVariable Long id) {
		if (!clienteRepository.existsById(id)) {
		return ResponseEntity.notFound().build();
			}
		clienteRepository.deleteById(id);
		return ResponseEntity.noContent().build();
			
		}
	}

