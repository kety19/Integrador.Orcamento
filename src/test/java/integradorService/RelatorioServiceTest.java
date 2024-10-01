package integradorService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Collections;
import java.util.Date;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.Integrador.integrador.IntegradorEntites.ClienteEntity;
import com.Integrador.integrador.IntegradorEntites.EmissorEntity;
import com.Integrador.integrador.IntegradorEntites.OrcamentoEntity;
import com.Integrador.integrador.IntegradorEntites.ProdutoServicoEntity;
import com.Integrador.integrador.IntegradorRepository.OrcamentoRepository;
import com.Integrador.integrador.IntegradorService.RelatorioService;

public class RelatorioServiceTest {

	@Mock
	private OrcamentoRepository orcamentoRepository;

	@InjectMocks
	private RelatorioService relatorioService;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void gerarPdf_deveGerarPdfComDadosDoOrcamento() {
		// Arrange
		Long orcamentoId = 1L;

		// Mock do cliente
		ClienteEntity cliente = new ClienteEntity();
		cliente.setNome("João Silva");
		cliente.setEndereco("Rua A, 123");
		cliente.setTelefone("1111-2222");
		cliente.setEmail("joao@exemplo.com");

		// Mock do emissor
		EmissorEntity emissor = new EmissorEntity();
		emissor.setNome("Empresa X");
		emissor.setCnpj("12.345.678/0001-99");
		emissor.setEndereco("Avenida B, 456");
		emissor.setTelefone("3333-4444");
		emissor.setEmail("contato@empresax.com");
		emissor.setLogoUrl("http://logo.com/logo.png");

		// Mock do orçamento
		OrcamentoEntity orcamento = new OrcamentoEntity();
		orcamento.setId(orcamentoId);
		orcamento.setTotal(2000.0);
		orcamento.setDataCriacao(LocalDateTime.now());
		orcamento.setCliente(cliente);
		orcamento.setEmissor(emissor);

		// Mock de produtos
		ProdutoServicoEntity produto = new ProdutoServicoEntity();
		produto.setNome("Produto A");
		produto.setDescricao("Descrição do Produto A");
		produto.setPreco(500.0);
		produto.setQuantidade(4);

		orcamento.setProdutosServicos(Collections.singletonList(produto));

		// Simulando comportamento do repositório
		when(orcamentoRepository.findByIdWithRelations(orcamentoId)).thenReturn(Optional.of(orcamento));

		byte[] pdfBytes = relatorioService.gerarPdf(orcamentoId);

		assertNotNull(pdfBytes);
		assertTrue(pdfBytes.length > 0);

		verify(orcamentoRepository).findByIdWithRelations(orcamentoId);
	}

	@Test
	void gerarPdf_deveLancarRuntimeException_quandoOrcamentoNaoEncontrado() {
		// Arrange
		Long orcamentoId = 1L;

		when(orcamentoRepository.findByIdWithRelations(orcamentoId)).thenReturn(Optional.empty());

		// Act & Assert
		RuntimeException exception = assertThrows(RuntimeException.class, () -> {
			relatorioService.gerarPdf(orcamentoId);
		});

		assertEquals("Orçamento não encontrado", exception.getMessage());
		verify(orcamentoRepository).findByIdWithRelations(orcamentoId);
	}
}