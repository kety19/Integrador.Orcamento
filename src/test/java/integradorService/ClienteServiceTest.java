package integradorService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;

import com.Integrador.integrador.IntegradorEntites.ClienteEntity;
import com.Integrador.integrador.IntegradorRepository.ClienteRepository;
import com.Integrador.integrador.IntegradorService.ClienteService;

public class ClienteServiceTest {

	@InjectMocks
	private ClienteService clienteService;

	@Mock
	private ClienteRepository clienteRepository;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testCriarCliente() {
		ClienteEntity novoCliente = new ClienteEntity();
		novoCliente.setNome("Cliente Teste");

		when(clienteRepository.save(any(ClienteEntity.class))).thenReturn(novoCliente);

		ClienteEntity clienteCriado = clienteService.criarCliente(novoCliente);

		assertNotNull(clienteCriado);
		assertEquals("Cliente Teste", clienteCriado.getNome());
	}

	@Test
	public void salvarClienteTest() {
		ClienteEntity cliente = new ClienteEntity();
		cliente.setId(1L);
		cliente.setNome("Cliente Teste");

		when(clienteRepository.save(any(ClienteEntity.class))).thenReturn(cliente);

		ClienteEntity result = clienteService.salvarCliente(cliente);

		assertNotNull(result);
		assertEquals(1L, result.getId().longValue());
		verify(clienteRepository, times(1)).save(cliente);
	}

	@Test
	void testListarClientes() {
		ClienteEntity cliente1 = new ClienteEntity();
		cliente1.setNome("Cliente 1");
		ClienteEntity cliente2 = new ClienteEntity();
		cliente2.setNome("Cliente 2");

		when(clienteRepository.findAll()).thenReturn(Arrays.asList(cliente1, cliente2));

		List<ClienteEntity> clientes = clienteService.listarClientes();

		assertEquals(2, clientes.size());
		assertEquals("Cliente 1", clientes.get(0).getNome());
		assertEquals("Cliente 2", clientes.get(1).getNome());
	}

	@Test
	public void deletarClienteTest() {
		// Act
		clienteService.deletarCliente(1L);

		// Assert
		verify(clienteRepository, times(1)).deleteById(1L);
	}
	
	
	@Test
	public void testSalvarCliente() {
	    // Arrange
	    ClienteEntity cliente = new ClienteEntity();
	    cliente.setNome("Novo Cliente");

	    ClienteEntity clienteSalvo = new ClienteEntity();
	    clienteSalvo.setId(1L);
	    clienteSalvo.setNome("Novo Cliente");

	    when(clienteRepository.save(any(ClienteEntity.class))).thenReturn(clienteSalvo);

	    ClienteEntity resultado = clienteService.salvarCliente(cliente);

	    assertNotNull(resultado.getId()); // Verifica se o ID foi gerado
	    assertEquals("Novo Cliente", resultado.getNome()); // Verifica o nome
	}
}