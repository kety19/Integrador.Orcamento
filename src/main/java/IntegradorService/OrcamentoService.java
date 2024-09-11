package IntegradorService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import IntegradorRepository.ClienteRepository;
import IntegradorRepository.EmissorRepository;
import IntegradorRepository.OrcamentoRepository;
import IntegradorEntites.ProdutoServicoEntity;
import jakarta.persistence.EntityNotFoundException;
import IntegradorEntites.OrcamentoEntity;

@Service
public class OrcamentoService {

	@Autowired
	private static OrcamentoRepository orcamentoRepository;

	@Autowired
	private static EmissorRepository emissorRepository;

	@Autowired
	private static ClienteRepository clienteRepository;

	public static OrcamentoEntity criarOrcamento(OrcamentoEntity orcamento) {
		// Validar se o emissor existe
		if (!emissorRepository.existsById(OrcamentoEntity.getEmissor().getId())) {
			throw new EntityNotFoundException("Emissor não encontrado");
		}
		return orcamento;
	}

	public List<OrcamentoEntity> listarTodosOrcamentos() {
		return orcamentoRepository.findAll();
	}

	public void deletarOrcamento(Long id) {
		OrcamentoEntity orcamento = buscarOrcamentoPorId(id);
		orcamentoRepository.delete(orcamento);
	}

	private OrcamentoEntity buscarOrcamentoPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
}
