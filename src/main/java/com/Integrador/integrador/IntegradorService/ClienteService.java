package com.Integrador.integrador.IntegradorService;
import java.util.List;

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

    public List<ClienteEntity> listarTodosClientes() {
        return clienteRepository.findAll();
    }


}
