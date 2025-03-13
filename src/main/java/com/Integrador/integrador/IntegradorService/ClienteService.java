package com.Integrador.integrador.IntegradorService;

import java.util.List;
import java.util.Optional;

import com.Integrador.integrador.config.JWTKeys;
import org.springframework.security.authentication.AuthenticationManager;
import com.Integrador.integrador.IntegradorController.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import com.Integrador.integrador.IntegradorEntites.ClienteEntity;
import com.Integrador.integrador.IntegradorRepository.ClienteRepository;

@Service
@RequiredArgsConstructor
public class ClienteService {

	@Autowired
	private JwtUtils jwtService;
	@Autowired
	private AuthenticationManager authenticationManager;
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
    
    public String logar(LoginRequest login) {
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
