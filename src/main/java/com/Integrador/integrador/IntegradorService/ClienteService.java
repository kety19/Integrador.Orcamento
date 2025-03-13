package com.Integrador.integrador.IntegradorService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Integrador.integrador.IntegradorController.LoginRequeste;
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
    
    public String logar(LoginRequeste login) {
        var data = clienteRepository.findByNomr(login.login()).get();
        System.out.println(data.getUsername());
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        login.login(),
                        login.senha()
                )
        );
//        Usuario user = usuarioRepository.findByNomr(login.login()).get();
        String jwtToken = jwtService.generateToken(data);

        return jwtToken;
    }


}
