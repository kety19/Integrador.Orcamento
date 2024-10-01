package integradorService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.Integrador.integrador.IntegradorEntites.EmissorEntity;
import com.Integrador.integrador.IntegradorRepository.EmissorRepository;
import com.Integrador.integrador.IntegradorService.EmissorService;

public class EmissorServiceTest {
	@InjectMocks
	private EmissorService emissorService;

	@Mock
	private EmissorRepository emissorRepository;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testCriarEmissorComCampoObrigatorioFaltando() {
		EmissorEntity emissor = new EmissorEntity(null, "12345678000195");
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			emissorService.criarEmissor(emissor);
		});

		assertEquals("Nome é obrigatório", exception.getMessage());
	}

	@Test
	void testCriarEmissorComCnpjValido() {
		EmissorEntity emissor = new EmissorEntity();
		emissor.setNome("Test Emissor");
		emissor.setCnpj("12345678000195");

		when(emissorRepository.save(any(EmissorEntity.class))).thenReturn(emissor);

		EmissorEntity emissorSalvo = emissorService.criarEmissor(emissor);

		// Verificações
		assertEquals("Test Emissor", emissorSalvo.getNome());
		assertEquals("12345678000195", emissorSalvo.getCnpj());
		verify(emissorRepository, times(1)).save(emissor); // Verifica se save foi chamado uma vez
	}

	@Test
	public void testSalvarEmissor() {
		EmissorEntity emissor = new EmissorEntity();
		emissor.setId(1L);
		emissor.setNome("Emissor Teste");

		when(emissorRepository.save(any(EmissorEntity.class))).thenReturn(emissor);

		EmissorEntity resultado = emissorService.salvarEmissor(emissor);

		verify(emissorRepository, times(1)).save(emissor);

		assertEquals(emissor, resultado);

		// Verifica os campos do emissor
		assertEquals(1L, resultado.getId());
		assertEquals("Emissor Teste", resultado.getNome());
	}
}
