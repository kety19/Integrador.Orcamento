	package integradorService;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.Integrador.integrador.IntegradorService.ProdutoServicoService;

public class TestConfig {


    @Bean
    public ProdutoServicoService produtoServicoService() {
        return new ProdutoServicoService();
    }
}
