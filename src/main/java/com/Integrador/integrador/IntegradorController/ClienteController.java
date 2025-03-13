package com.Integrador.integrador.IntegradorController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Integrador.integrador.IntegradorEntites.ClienteEntity;
import com.Integrador.integrador.IntegradorRepository.ClienteRepository;
import com.Integrador.integrador.IntegradorService.ClienteService;

@RestController
@RequestMapping("/clientes")
@CrossOrigin("*")
@PreAuthorize("hasRole('ADMIN') or hasRole('USUARIO')")
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private ClienteService clienteService;

	@PostMapping
	public ResponseEntity<ClienteEntity> criarCliente(@RequestBody ClienteEntity cliente) {
		ClienteEntity clienteCriado = clienteService.criarCliente(cliente);
		return ResponseEntity.status(HttpStatus.CREATED).body(clienteCriado);
	}

	@GetMapping("/listarClientes")//findAll
	public ResponseEntity<List<ClienteEntity>> listarClientes() {
		List<ClienteEntity> clientes = clienteService.listarClientes();
		return ResponseEntity.ok(clientes);
	}
	

	// Endpoint para buscar um cliente por ID
	@GetMapping("/clientes/{id}")
	public ResponseEntity<ClienteEntity> buscarClientePorId(@PathVariable Long id) {
		Optional<ClienteEntity> cliente = clienteService.buscarClientePorId(id); // Altere para clienteService

		if (cliente.isPresent()) {
			return ResponseEntity.ok(cliente.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletarCliente(@PathVariable Long id) {
		Optional<ClienteEntity> cliente = clienteService.buscarClientePorId(id); // Use o clienteService novamente

		if (cliente.isPresent()) {
			clienteService.deletarCliente(id); // Chame o service em vez do repository diretamente
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
