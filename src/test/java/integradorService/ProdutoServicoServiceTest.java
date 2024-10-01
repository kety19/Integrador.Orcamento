package integradorService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.Integrador.integrador.IntegradorEntites.ProdutoServicoEntity;
import com.Integrador.integrador.IntegradorRepository.ProdutoServicoRepository;
import com.Integrador.integrador.IntegradorService.ProdutoServicoService;


public class ProdutoServicoServiceTest {


    @InjectMocks
    private ProdutoServicoService produtoServicoService;

    @Mock
    private ProdutoServicoRepository produtoServicoRepository;

    private ProdutoServicoEntity produtoServicoEntity;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        produtoServicoEntity = new ProdutoServicoEntity();
        produtoServicoEntity.setId(1L);
        produtoServicoEntity.setNome("Produto 1");
        produtoServicoEntity.setPreco(100.0);
        produtoServicoEntity.setQuantidade(10);  // Testando quantidade
        produtoServicoEntity.setDescricao("Descrição do Produto 1");  // Testando descrição
    }

    @Test
    public void testCriarProdutoServico() {
        when(produtoServicoRepository.save(produtoServicoEntity)).thenReturn(produtoServicoEntity);

        ProdutoServicoEntity produtoCriado = produtoServicoService.criarProdutoServico(produtoServicoEntity);

        assertEquals("Produto 1", produtoCriado.getNome());
        assertEquals(100.0, produtoCriado.getPreco());
        assertEquals(10, produtoCriado.getQuantidade());
        assertEquals("Descrição do Produto 1", produtoCriado.getDescricao());
        verify(produtoServicoRepository, times(1)).save(produtoServicoEntity);
    }

    @Test
    public void testBuscarTodos() {
        when(produtoServicoRepository.findAll()).thenReturn(Arrays.asList(produtoServicoEntity));

        List<ProdutoServicoEntity> produtos = produtoServicoService.buscarTodos();

        assertEquals(1, produtos.size());
        assertEquals("Produto 1", produtos.get(0).getNome());
        assertEquals(10, produtos.get(0).getQuantidade());
        assertEquals("Descrição do Produto 1", produtos.get(0).getDescricao());
        verify(produtoServicoRepository, times(1)).findAll();
    }

    @Test
    public void testBuscarPorId() {
        when(produtoServicoRepository.findById(1L)).thenReturn(Optional.of(produtoServicoEntity));

        Optional<ProdutoServicoEntity> produtoEncontrado = produtoServicoService.buscarPorId(1L);

        assertTrue(produtoEncontrado.isPresent());
        assertEquals("Produto 1", produtoEncontrado.get().getNome());
        assertEquals(10, produtoEncontrado.get().getQuantidade());
        assertEquals("Descrição do Produto 1", produtoEncontrado.get().getDescricao());
        verify(produtoServicoRepository, times(1)).findById(1L);
    }

    @Test
    public void testAtualizarProdutoServico() {
    	produtoServicoEntity.setNome("Produto Atualizado");
    	produtoServicoEntity.setQuantidade(20);
    	produtoServicoEntity.setDescricao("Descrição Atualizada");

        when(produtoServicoRepository.save(produtoServicoEntity)).thenReturn(produtoServicoEntity);

        ProdutoServicoEntity produtoAtualizado = produtoServicoService.atualizarProdutoServico(1L, produtoServicoEntity);

        assertEquals("Produto Atualizado", produtoAtualizado.getNome());
        assertEquals(20, produtoAtualizado.getQuantidade());
        assertEquals("Descrição Atualizada", produtoAtualizado.getDescricao());
        verify(produtoServicoRepository, times(1)).save(produtoServicoEntity);
    }

    @Test
    public void testDeletarProdutoServico() {
        produtoServicoService.deletarProdutoServico(1L);

        verify(produtoServicoRepository, times(1)).deleteById(1L);
    }
}

