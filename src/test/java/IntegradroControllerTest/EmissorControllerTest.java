package IntegradroControllerTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.Integrador.integrador.IntegradorController.EmissorController;
import com.Integrador.integrador.IntegradorEntites.EmissorEntity;
import com.Integrador.integrador.IntegradorService.EmissorService;

public class EmissorControllerTest {

    @Mock
    private EmissorService emissorService;

    @InjectMocks
    private EmissorController emissorController;

    @BeforeEach
    public void setUp() {
        // Inicializa os mocks
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCriarEmissor() {
        // Cria uma instância de EmissorEntity para ser usada no teste
        EmissorEntity emissor = new EmissorEntity();
        emissor.setId(1L);
        emissor.setNome("Emissor Teste");

        // Simula o retorno do emissorService.salvarEmissor
        when(emissorService.salvarEmissor(any(EmissorEntity.class))).thenReturn(emissor);

        // Chama o método do controlador
        ResponseEntity<EmissorEntity> response = emissorController.criarEmissor(emissor);

        // Verifica se o método salvarEmissor foi chamado uma vez
        verify(emissorService, times(1)).salvarEmissor(any(EmissorEntity.class));

        // Verifica o status da resposta
        assertEquals(HttpStatus.OK, response.getStatusCode());

        // Verifica o corpo da resposta
        assertEquals(emissor, response.getBody());

        // Verifica os campos do emissor
        assertEquals(1L, response.getBody().getId());
        assertEquals("Emissor Teste", response.getBody().getNome());
    }
}