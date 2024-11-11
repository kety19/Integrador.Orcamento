package IntegradroControllerTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.mockito.Mockito.*;

import com.Integrador.integrador.IntegradorController.ClienteController;
import com.Integrador.integrador.IntegradorEntites.ClienteEntity;
import com.Integrador.integrador.IntegradorService.ClienteService;

public class ClienteControllerTest {

	@InjectMocks
	private ClienteController clienteController;

	@Mock
	private ClienteService clienteService;

	@BeforeEach

	void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void criarClienteTest() {
		// Arrange
		ClienteEntity cliente = new ClienteEntity();
		cliente.setId(1L);
		cliente.setNome("Cliente Teste");

		when(clienteService.criarCliente(any(ClienteEntity.class))).thenReturn(cliente);

		// Act
		ResponseEntity<ClienteEntity> response = clienteController.criarCliente(cliente);

		// Assert
		assertEquals(HttpStatus.CREATED, response.getStatusCode());
		assertNotNull(response.getBody());
		assertEquals(1L, response.getBody().getId().longValue());
		assertEquals("Cliente Teste", response.getBody().getNome());
	}

	@Test
	public void listarClientesTest() {
		// Arrange
		ClienteEntity cliente = new ClienteEntity();
		cliente.setId(1L);
		cliente.setNome("Cliente Teste");

		List<ClienteEntity> clientes = Arrays.asList(cliente);
		when(clienteService.listarClientes()).thenReturn(clientes);

		// Act
		ResponseEntity<List<ClienteEntity>> response = clienteController.listarClientes();

		// Assert
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertNotNull(response.getBody());
		assertEquals(1, response.getBody().size());
		assertEquals("Cliente Teste", response.getBody().get(0).getNome());
	}

	@Test
	void testBuscarClientePorId_ClienteEncontrado() {
		ClienteEntity cliente = new ClienteEntity();
		cliente.setId(1L);
		cliente.setNome("Teste");

		when(clienteService.buscarClientePorId(1L)).thenReturn(Optional.of(cliente));

		ResponseEntity<ClienteEntity> response = clienteController.buscarClientePorId(1L);

		assertEquals(200, response.getStatusCodeValue());
		assertEquals(cliente, response.getBody());
	}

	@Test
	void testBuscarClientePorId_ClienteNaoEncontrado() {
		when(clienteService.buscarClientePorId(1L)).thenReturn(Optional.empty());

		ResponseEntity<ClienteEntity> response = clienteController.buscarClientePorId(1L);

		assertEquals(404, response.getStatusCodeValue());
		assertNull(response.getBody());
	}

	@Test
	public void testDeletarCliente() {
		// Arrange
		Long id = 1L;
		ClienteEntity cliente = new ClienteEntity();
		cliente.setId(id);

		when(clienteService.buscarClientePorId(id)).thenReturn(Optional.of(cliente)); // Mocka o retorno do service.

		// Act
		ResponseEntity<Void> response = clienteController.deletarCliente(id);

		// Assert
		assertEquals(204, response.getStatusCodeValue());
		verify(clienteService, times(1)).deletarCliente(id); // Verifica se o método deletarCliente foi chamado.
	}

}
