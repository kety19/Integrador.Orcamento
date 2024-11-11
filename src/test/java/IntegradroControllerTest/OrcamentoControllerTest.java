package IntegradroControllerTest;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.Integrador.integrador.IntegradorController.OrcamentoController;
import com.Integrador.integrador.IntegradorEntites.OrcamentoEntity;
import com.Integrador.integrador.IntegradorEntites.ProdutoServicoEntity;
import com.Integrador.integrador.IntegradorRepository.OrcamentoRepository;
import com.Integrador.integrador.IntegradorService.OrcamentoService;
import com.Integrador.integrador.IntegradorService.RelatorioService;

public class OrcamentoControllerTest {

	@InjectMocks
	private OrcamentoController orcamentoController;

	@Mock
	private OrcamentoRepository orcamentoRepository;

	@Mock
	private OrcamentoService orcamentoService;

	@Mock
	private RelatorioService relatorioService;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void testCriarOrcamento() {
		OrcamentoEntity orcamento = new OrcamentoEntity();
		orcamento.setTotal(1000.0);
		orcamento.setDataCriacao(LocalDateTime.now());
		orcamento.setObservacoes("Orçamento de teste");

		when(orcamentoService.criarOrcamento(any(OrcamentoEntity.class))).thenReturn(orcamento);

		ResponseEntity<OrcamentoEntity> response = orcamentoController.criarOrcamento(orcamento);

		assertEquals(HttpStatus.CREATED, response.getStatusCode());
		assertEquals(orcamento, response.getBody());
	}

	@Test
	public void testListarOrcamentos() {
		OrcamentoEntity orcamento1 = new OrcamentoEntity();
		orcamento1.setId(1L);
		orcamento1.setTotal(1500.0);

		OrcamentoEntity orcamento2 = new OrcamentoEntity();
		orcamento2.setId(2L);
		orcamento2.setTotal(2500.0);

		List<OrcamentoEntity> orcamentos = Arrays.asList(orcamento1, orcamento2);

		when(orcamentoService.listarTodosOrcamentos()).thenReturn(orcamentos);

		ResponseEntity<List<OrcamentoEntity>> response = orcamentoController.listarOrcamentos();

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(orcamentos, response.getBody());
	}

	@Test
	public void testCalcularTotalOrcamento() {
		ProdutoServicoEntity produto1 = new ProdutoServicoEntity();
		produto1.setPreco(10.0);
		produto1.setQuantidade(2);

		ProdutoServicoEntity produto2 = new ProdutoServicoEntity();
		produto2.setPreco(20.0);
		produto2.setQuantidade(3);

		List<ProdutoServicoEntity> produtos = Arrays.asList(produto1, produto2);

		when(orcamentoService.calcularOrcamento(produtos)).thenReturn(70.0);

		ResponseEntity<Double> response = orcamentoController.calcularTotalOrcamento(produtos);

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(Double.valueOf(70.0), response.getBody());
	}
	/*@Test
	public void testGerarOrcamentoPdf_Sucesso() throws Exception {
		Long orcamentoId = 1L;
		byte[] mockPdfBytes = new byte[] { 1, 2, 3 }; // Simulação do PDF

		when(orcamentoRepository.existsById(orcamentoId)).thenReturn(true);
		when(relatorioService.gerarPdf(orcamentoId)).thenReturn(mockPdfBytes);

		// Chama o método do controlador
		ResponseEntity<byte[]> response = orcamentoController.gerarOrcamentoPdf(orcamentoId);

		assertEquals(HttpStatus.OK, response.getStatusCode());

		assertNotNull(response.getBody());
		assertEquals(mockPdfBytes.length, response.getBody().length);
		assertArrayEquals(mockPdfBytes, response.getBody());
	}*/
}
