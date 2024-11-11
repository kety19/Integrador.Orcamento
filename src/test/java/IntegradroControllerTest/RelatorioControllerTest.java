package IntegradroControllerTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.Integrador.integrador.IntegradorController.RelatorioController;
import com.Integrador.integrador.IntegradorService.RelatorioService;

public class RelatorioControllerTest {

	@Mock
	private RelatorioService relatorioService;

	@InjectMocks
	private RelatorioController relatorioController;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this); // Inicializa os mocks
	}

	@Test
	public void testRelatorioControllerConstructor() {
		RelatorioService relatorioService = mock(RelatorioService.class);
		RelatorioController relatorioController = new RelatorioController(relatorioService);
		assertNotNull(relatorioController);
	}
}
