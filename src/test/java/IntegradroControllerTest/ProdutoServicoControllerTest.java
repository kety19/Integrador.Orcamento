package IntegradroControllerTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.mockito.Mockito.*;

import com.Integrador.integrador.IntegradorController.ProdutoServicoController;
import com.Integrador.integrador.IntegradorEntites.ProdutoServicoEntity;
import com.Integrador.integrador.IntegradorRepository.ProdutoServicoRepository;
import com.Integrador.integrador.IntegradorService.ProdutoServicoService;

public class ProdutoServicoControllerTest {

	@InjectMocks
	private ProdutoServicoController produtoServicoController;

	@Mock
	private ProdutoServicoService produtoServicoService;

	@Mock
	private ProdutoServicoRepository produtoServicoRepository;

	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testCriarProdutoServico() {
		ProdutoServicoEntity novoProduto = new ProdutoServicoEntity();
		novoProduto.setNome("Novo Produto");
		novoProduto.setPreco(200.0);
		novoProduto.setQuantidade(2); // Certifique-se de que você tem este campo no seu Entity

		// Produto que será retornado após a criação
		ProdutoServicoEntity produtoServicoCriado = new ProdutoServicoEntity();
		produtoServicoCriado.setNome(novoProduto.getNome());
		produtoServicoCriado.setPreco(100.0); // O valor que você quer que o serviço retorne
		produtoServicoCriado.setQuantidade(novoProduto.getQuantidade());

		// Simulando a resposta do serviço
		when(produtoServicoService.criarProdutoServico(any(ProdutoServicoEntity.class)))
				.thenReturn(produtoServicoCriado);

		// Chamada ao método do controller
		ResponseEntity<ProdutoServicoEntity> response = produtoServicoController.criarProdutoServico(novoProduto);

		// Verificações
		assertEquals(201, response.getStatusCodeValue());
		assertEquals(100.0, response.getBody().getPreco());
		assertEquals("Novo Produto", response.getBody().getNome());
	}

	@Test
	void testListarProdutosServicos() {
		List<ProdutoServicoEntity> produtos = new ArrayList<>();
		ProdutoServicoEntity produto1 = new ProdutoServicoEntity();
		produto1.setNome("Produto 1");
		produto1.setPreco(100.0);

		ProdutoServicoEntity produto2 = new ProdutoServicoEntity();
		produto2.setNome("Produto 2");
		produto2.setPreco(200.0);

		produtos.add(produto1);
		produtos.add(produto2);

		// Simulando a resposta do serviço
		when(produtoServicoService.listarTodos()).thenReturn(produtos);

		// Chamada ao método do controller
		ResponseEntity<List<ProdutoServicoEntity>> response = produtoServicoController.listarProdutosServicos();

		// Verificação
		assertEquals(200, response.getStatusCodeValue());
		assertEquals(2, response.getBody().size());
		assertEquals("Produto 1", response.getBody().get(0).getNome());
	}

	@Test
	public void testDeletarProdutoServico() {
		// Arrange
		Long id = 1L;
		doNothing().when(produtoServicoService).deletarProdutoServico(id);

		// Act
		produtoServicoController.deletarProdutoServico(id);

		// Assert
		verify(produtoServicoService, times(1)).deletarProdutoServico(id);
	}
}