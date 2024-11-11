package com.Integrador.integrador.IntegradorService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Integrador.integrador.IntegradorEntites.ClienteEntity;
import com.Integrador.integrador.IntegradorRepository.ClienteRepository;

@Service
public class ClienteService {
	@Autowired
	private ClienteRepository clienteRepository;

	public ClienteEntity salvarCliente(ClienteEntity cliente) {
		return clienteRepository.save(cliente);
	}

	public ClienteEntity criarCliente(ClienteEntity cliente) {
		return clienteRepository.save(cliente);
	}

	public Optional<ClienteEntity> buscarClientePorId(Long id) {
		return clienteRepository.findById(id);
	}

	public List<ClienteEntity> listarClientes() {
		return clienteRepository.findAll();
		
	}

    public void deletarCliente(Long id) {
        clienteRepository.deleteById(id);
    }


}
