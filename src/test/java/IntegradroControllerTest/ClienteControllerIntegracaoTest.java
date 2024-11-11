package IntegradroControllerTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.Integrador.integrador.IntegradorController.ClienteController;
import com.Integrador.integrador.IntegradorEntites.ClienteEntity;
import com.Integrador.integrador.IntegradorRepository.ClienteRepository;
import com.Integrador.integrador.IntegradorService.ClienteService;

import jakarta.transaction.Transactional;

public class ClienteControllerIntegracaoTest {

/*
	    @Autowired
	     TestRestTemplate restTemplate;

	    @Autowired
	     ClienteRepository clienteRepository;
	    
	    @Autowired
	    ClienteController clienteController;
	    
	    

	    @BeforeEach
	    void setUp() {
	        clienteRepository.deleteAll(); // Limpa os dados antes de cada teste
	    }
	    
	    @Test
	    void testCriarCliente() {
	    	
	    	  ClienteEntity cliente = new ClienteEntity();
	      	cliente.setNome("bia");
	      	cliente.setEndereco("barcelona");
	      	
	      	ResponseEntity<ClienteEntity> response = clienteController.criarCliente(cliente);
	      	
	      	assertEquals(HttpStatus.CREATED, response.getStatusCode());
	      	assertNotNull(response.getBody());
	      	assertEquals("bia", response.getBody().getNome());
	      	assertEquals("barcelona", response.getBody().getEndereco());
	    }
	    
	    @Test
	    void testListarClientes() {
	    	
	    	ResponseEntity<List<ClienteEntity>> response = clienteController.listarClientes();
	    	
	    	assertEquals(HttpStatus.OK, response.getStatusCode());
	    	assertNotNull(response.getBody());
	    }
	    
	    @Test
	    void testBuscarPorId() {
	    	
	    	Long id = 1L;
	    	
	    	ResponseEntity<ClienteEntity> response = clienteController.buscarClientePorId(id);
	    	
	    	assertEquals(HttpStatus.OK, response.getStatusCode());
	    	assertNotNull(response.getBody());
	    	assertEquals(id, response.getBody().getId());
	    }
	    
	    @Test
	    void testDeletarCliente() {
	    	
	    	Long id = 1L;
	    	
	    	ResponseEntity<Void> response = clienteController.deletarCliente(id);
	    			
	    	assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());		
	    }
*/	    
	    
	    
	    //ketelyn
/*
	    @Test
	    void testCriarCliente() {
	        ClienteEntity novoCliente = new ClienteEntity();
	        novoCliente.setNome("Cliente Teste");
	        novoCliente.setEmail("teste@cliente.com");

	        ResponseEntity<ClienteEntity> response = restTemplate.postForEntity("/clientes", novoCliente, ClienteEntity.class);

	        assertEquals(HttpStatus.CREATED, response.getStatusCode());
	        assertEquals("Cliente Teste", response.getBody().getNome());
	    }

	    @Test
	    void testListarClientes() {
	        // Cria um cliente para testar a listagem
	        ClienteEntity cliente = new ClienteEntity();
	        cliente.setNome("Cliente Teste");
	        cliente.setEmail("teste@cliente.com");
	        clienteRepository.save(cliente);

	        ResponseEntity<List> response = restTemplate.exchange("/clientes", HttpMethod.GET, null, List.class);

	        assertEquals(HttpStatus.OK, response.getStatusCode());
	        assertEquals(1, response.getBody().size());
	        assertEquals("Cliente Teste", ((ClienteEntity) response.getBody().get(0)).getNome());
	    }*/
}