package com.Integrador.integrador.IntegradorController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.Integrador.integrador.IntegradorEntites.ClienteEntity;
import com.Integrador.integrador.IntegradorRepository.ClienteRepository;

public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;

	// Endpoint para listar todos os clientes
	@GetMapping
	public List<ClienteEntity> listarClientes() {
		return clienteRepository.findAll();
	}

	// Endpoint para buscar um cliente por ID
	@GetMapping("/{id}")
	public ResponseEntity<ClienteEntity> buscarClientePorId(@PathVariable Long id) {
		Optional<ClienteEntity> cliente = clienteRepository.findById(id);
		if (cliente.isPresent()) {
			return ResponseEntity.ok(cliente.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletarCliente(@PathVariable Long id) {
		Optional<ClienteEntity> cliente = clienteRepository.findById(id);
		if (cliente.isPresent()) {
			clienteRepository.delete(cliente.get());
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
