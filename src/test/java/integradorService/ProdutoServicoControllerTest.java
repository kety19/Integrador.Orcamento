package integradorService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.Integrador.integrador.IntegradorController.ProjetoServicoController;
import com.Integrador.integrador.IntegradorEntites.ProdutoServicoEntity;
import com.Integrador.integrador.IntegradorRepository.ProdutoServicoRepository;

@SpringBootTest
public class ProdutoServicoControllerTest {

	@Mock
	private ProdutoServicoRepository produtoServicoRepository;

	@InjectMocks
	private ProjetoServicoController projetoServicoController;

	public void ProjetoServicoControllerTest() {
	        MockitoAnnotations.openMocks(this);
	    }

	@Test
	void testCriarProjetoServico() {
		ProdutoServicoEntity produtoServico = new ProdutoServicoEntity();
		produtoServico.setPrecoUnitario(100.0);
		produtoServico.setQuantidade(2);

		when(produtoServicoRepository.save(any(ProdutoServicoEntity.class))).thenReturn(produtoServico);

		ResponseEntity<ProdutoServicoEntity> response = projetoServicoController.criarProjetoServico(produtoServico);

		assertEquals(HttpStatus.CREATED, response.getStatusCode());
		assertNotNull(response.getBody());
		assertEquals(100.0, response.getBody().getPrecoUnitario());
	}

	@Test
	void testListarProjetosServicos() {
		ProdutoServicoEntity produto1 = new ProdutoServicoEntity();
		produto1.setPrecoUnitario(100.0);
		produto1.setQuantidade(2);

		ProdutoServicoEntity produto2 = new ProdutoServicoEntity();
		produto2.setPrecoUnitario(50.0);
		produto2.setQuantidade(3);

		List<ProdutoServicoEntity> produtos = new ArrayList<>();
		produtos.add(produto1);
		produtos.add(produto2);

		when(produtoServicoRepository.findAll()).thenReturn(produtos);

		ResponseEntity<List<ProdutoServicoEntity>> response = projetoServicoController.listarProjetosServicos();

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertNotNull(response.getBody());
		assertEquals(2, response.getBody().size());
		assertEquals(100.0, response.getBody().get(0).getPrecoUnitario());
		assertEquals(50.0, response.getBody().get(1).getPrecoUnitario());
	}
}
