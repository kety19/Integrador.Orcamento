package integradorService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.Integrador.integrador.IntegradorEntites.ProdutoServicoEntity;
import com.Integrador.integrador.IntegradorRepository.ProdutoServicoRepository;
import com.Integrador.integrador.IntegradorService.ProdutoServicoService;

@SpringBootTest
public class PordutoServicoServiceTest {

	@Mock
	private ProdutoServicoRepository produtoServicoRepository;

	@InjectMocks
	private ProdutoServicoService produtoServicoService;

	public void ProdutoServicoServiceTest() {
	        MockitoAnnotations.openMocks(this);
	    }

	@Test
	void testSalvarProdutoServico() {
		ProdutoServicoEntity produtoServico = new ProdutoServicoEntity();
		produtoServico.setPrecoUnitario(100.0);
		produtoServico.setQuantidade(2);

		when(produtoServicoRepository.save(any(ProdutoServicoEntity.class))).thenReturn(produtoServico);

		ProdutoServicoEntity resultado = produtoServicoService.salvarProdutoServico(produtoServico);

		assertNotNull(resultado);
		assertEquals(100.0, resultado.getPrecoUnitario());
		assertEquals(2, resultado.getQuantidade());
		verify(produtoServicoRepository, times(1)).save(produtoServico);
	}
	
	@Test
    void testDeletarProdutoServico() {
        ProdutoServicoEntity produtoServico = new ProdutoServicoEntity();
        produtoServico.setPrecoUnitario(100.0);
        produtoServico.setQuantidade(2);

        when(produtoServicoRepository.findById(anyLong())).thenReturn(Optional.of(produtoServico));

        produtoServicoService.deletarProdutoServico(1L);

        verify(produtoServicoRepository, times(1)).delete(produtoServico);
    }
}
