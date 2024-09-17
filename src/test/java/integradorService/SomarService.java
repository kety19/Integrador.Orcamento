package integradorService;

import static org.junit.jupiter.api.Assertions.assertEquals;


import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.Integrador.integrador.IntegradorEntites.OrcamentoEntity;
import com.Integrador.integrador.IntegradorEntites.ProdutoServicoEntity;

import jakarta.annotation.security.RunAs;


@SpringBootTest
@ContextConfiguration(classes = { TestConfig.class })
public class SomarService{

	@Autowired
	private SomarService somarService;

	private OrcamentoEntity orcamento;


    @BeforeEach
    public void setUp() {
       
        orcamento = new OrcamentoEntity();
    }
    
	@Test
	void opcao1() {
		  ProdutoServicoEntity produto1 = new ProdutoServicoEntity();
	        produto1.setPrecoUnitario(100.0);
	        produto1.setQuantidade(2);  // Total = 200.0

	        ProdutoServicoEntity produto2 = new ProdutoServicoEntity();
	        produto2.setPrecoUnitario(50.0);
	        produto2.setQuantidade(3);  // Total = 150.0

	        List<ProdutoServicoEntity> produtosServicos = new ArrayList<>();
	        produtosServicos.add(produto1);
	        produtosServicos.add(produto2);

	        OrcamentoEntity orcamento = new OrcamentoEntity();
	        orcamento.setProdutosServicos(produtosServicos);


	        // Verificando se o total 
	        assertEquals(350.0, orcamento.getTotal(), 0.001);
	    }
}
