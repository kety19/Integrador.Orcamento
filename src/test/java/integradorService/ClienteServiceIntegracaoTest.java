package integradorService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.Integrador.integrador.IntegradorEntites.ClienteEntity;
import com.Integrador.integrador.IntegradorRepository.ClienteRepository;
import com.Integrador.integrador.IntegradorService.ClienteService;

import jakarta.transaction.Transactional;
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Transactional
public class ClienteServiceIntegracaoTest {
/*

	@Autowired
	 ClienteService clienteService;
	
	@Autowired
	 ClienteRepository clienteRepository;
	

	
	
    
    @Test
    void testSalvarCleinte() {
    	
    	ClienteEntity cliente = new ClienteEntity();
    	cliente.setNome("bia");
    	cliente.setEndereco("barcelona");
    	
    	ClienteEntity clienteSalvo = clienteRepository.saveAndFlush(cliente);
    	
    	assertEquals("bia", clienteSalvo.getNome());
    	assertEquals("bia@testin.com", clienteSalvo.getEmail());
    }
    
    @Test
    void testCriarCliente() {
    	
    	ClienteEntity cliente = new ClienteEntity();
    	cliente.setNome("bia");
    	cliente.setEndereco("barcelona");
    	
    	ClienteEntity clienteCriado = clienteService.criarCliente(cliente);
    	
    	assertEquals("heloisa", cliente.getNome());
    	assertEquals("helo@teste.com", clienteCriado.getEmail());
    	
    	
    }

    @Test
    void testBuscarPorId() {
    	
    	ClienteEntity cliente = new ClienteEntity();
    	cliente.setNome("bia");
    	cliente.setEndereco("barcelona");
    	
    	ClienteEntity clienteCriado = clienteService.criarCliente(cliente);
    	
    	Long id = clienteCriado.getId();
    	assertTrue(clienteService.buscarClientePorId(id).isPresent());
    	
    	
    }
    @Test
    void testListarCleinte() {
    	
    ClienteEntity cliente = new ClienteEntity();
	cliente.setNome("bia");
	cliente.setEndereco("barcelona");
	
	ClienteEntity cliente2 = new ClienteEntity();
	cliente2.setNome("ana");
	cliente2.setEndereco("paris");
	
	clienteService.salvarCliente(cliente);
	clienteService.salvarCliente(cliente2);
	
	List<ClienteEntity> clientes = clienteService.listarClientes();
	
	assertEquals(2, cliente.size());
	
}
    
    @Test
    void testDeletar() {
     	
        ClienteEntity cliente = new ClienteEntity();
    	cliente.setNome("bia");
    	cliente.setEndereco("barcelona");
    	
    	ClienteEntity clienteCriado = clienteService.criarCliente(cliente);

    	Long id = clienteCriado.getId();
    	clienteService.deletarCliente(id);
    	
    	assertTrue(clienteService.buscarClientePorId(id).isEmpty());
    	
    }
    */
	
   //ketelyn 
   
/*
	@Test
	public void testCriarCliente() {
		ClienteEntity novoCliente = new ClienteEntity();
		novoCliente.setNome("Novo Cliente");

		ResponseEntity<ClienteEntity> response = restTemplate.postForEntity("/clientes", novoCliente,
				ClienteEntity.class);

		assertEquals(HttpStatus.CREATED, response.getStatusCode());
		assertNotNull(response.getBody());
		assertEquals("Novo Cliente", response.getBody().getNome());
	}

	@Test
	public void testListarClientes() {
		ClienteEntity cliente1 = new ClienteEntity();
		cliente1.setNome("Cliente 1");
		restTemplate.postForEntity("/clientes", cliente1, ClienteEntity.class);

		ClienteEntity cliente2 = new ClienteEntity();
		cliente2.setNome("Cliente 2");
		restTemplate.postForEntity("/clientes", cliente2, ClienteEntity.class);

		ResponseEntity<ClienteEntity[]> response = restTemplate.getForEntity("/clientes", ClienteEntity[].class);

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertNotNull(response.getBody());
		assertEquals(2, response.getBody().length);
	}*/
}