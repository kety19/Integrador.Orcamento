package integradorService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.Integrador.integrador.IntegradorEntites.OrcamentoEntity;
import com.Integrador.integrador.IntegradorEntites.ProdutoServicoEntity;
import com.Integrador.integrador.IntegradorRepository.ClienteRepository;
import com.Integrador.integrador.IntegradorRepository.EmissorRepository;
import com.Integrador.integrador.IntegradorRepository.OrcamentoRepository;
import com.Integrador.integrador.IntegradorService.OrcamentoService;

public class OrcamentoServiceTest {

	@InjectMocks
	private OrcamentoService orcamentoService;

	@Mock
	private OrcamentoRepository orcamentoRepository;

	@Mock
	private EmissorRepository emissorRepository;

	@Mock
	private ClienteRepository clienteRepository;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testCriarOrcamento() {
		// Criando um novo orçamento
		OrcamentoEntity novoOrcamento = new OrcamentoEntity();
		novoOrcamento.setObservacoes("Novo Orcamento");

		// Simulando uma lista de produtos/serviços
		ProdutoServicoEntity produtoServico = new ProdutoServicoEntity();
		produtoServico.setPreco(100.0);
		produtoServico.setQuantidade(5); // 100 * 5 = 500.0 no total
		novoOrcamento.setProdutosServicos(Arrays.asList(produtoServico));

		// Simulando o comportamento do repositório para salvar o orçamento
		when(orcamentoRepository.save(any(OrcamentoEntity.class))).thenReturn(novoOrcamento);

		// Chamada do método de serviço
		OrcamentoEntity orcamentoSalvo = orcamentoService.criarOrcamento(novoOrcamento);

		// Verificações
		assertEquals("Novo Orcamento", orcamentoSalvo.getObservacoes());
		assertEquals(500.0, orcamentoSalvo.getTotal(), 0.001);
		verify(orcamentoRepository, times(1)).save(any(OrcamentoEntity.class));
	}

	@Test
	public void testCalcularTotalComProdutos() {
		// Criar uma lista de ProdutoServicoEntity
		List<ProdutoServicoEntity> produtosServicos = new ArrayList();

		// Adiciona produtos/serviços à lista
		ProdutoServicoEntity produto1 = new ProdutoServicoEntity();
		produto1.setPreco(10.0);
		produto1.setQuantidade(3); // 10.0 * 3 = 30.0

		ProdutoServicoEntity produto2 = new ProdutoServicoEntity();
		produto2.setPreco(20.0);
		produto2.setQuantidade(2); // 20.0 * 2 = 40.0

		produtosServicos.add(produto1);
		produtosServicos.add(produto2);

		// Calcular o total esperado
		Double totalEsperado = 30.0 + 40.0; // 70.0

		// Chamar o método calcularTotal e verificar o resultado
		Double totalCalculado = orcamentoService.calcularTotal(produtosServicos);
		assertEquals(totalEsperado, totalCalculado, "O total calculado não está correto");
	}

	@Test
	public void testDeletarOrcamento() {
		// Simula o orçamento a ser deletado
		OrcamentoEntity orcamento = new OrcamentoEntity();
		orcamento.setId(1L);

		// Simula o retorno do método buscarOrcamentoPorId
		when(orcamentoRepository.findById(1L)).thenReturn(java.util.Optional.of(orcamento));

		// Chama o método de deletar
		orcamentoService.deletarOrcamento(1L);

		// Verifica se o delete foi chamado corretamente
		verify(orcamentoRepository, times(1)).delete(orcamento);
	}

	@Test
	public void testListarTodosOrcamentos() {
		// Simula uma lista de orçamentos
		List<OrcamentoEntity> orcamentos = List.of(new OrcamentoEntity());
		when(orcamentoRepository.findAll()).thenReturn(orcamentos);

		// Chama o método de serviço
		List<OrcamentoEntity> result = orcamentoService.listarTodosOrcamentos();

		// Verifica se o método findAll foi chamado
		verify(orcamentoRepository, times(1)).findAll();
		assertEquals(orcamentos, result);
	}
}
