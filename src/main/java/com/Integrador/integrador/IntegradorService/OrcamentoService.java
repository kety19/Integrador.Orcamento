package com.Integrador.integrador.IntegradorService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Integrador.integrador.IntegradorEntites.OrcamentoEntity;
import com.Integrador.integrador.IntegradorRepository.ClienteRepository;
import com.Integrador.integrador.IntegradorRepository.EmissorRepository;
import com.Integrador.integrador.IntegradorRepository.OrcamentoRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class OrcamentoService {

	@Autowired
	private OrcamentoRepository orcamentoRepository;

	@Autowired
	private EmissorRepository emissorRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	public OrcamentoEntity criarOrcamento(OrcamentoEntity orcamento) {
		orcamento.setId(null);	
	// Salvando o orçamento
	return orcamentoRepository.save(orcamento);
}

	public List<OrcamentoEntity> listarTodosOrcamentos() {
		return orcamentoRepository.findAll();
	}

	public void deletarOrcamento(Long id) {
		OrcamentoEntity orcamento = buscarOrcamentoPorId(id);
		orcamentoRepository.delete(orcamento);
	}

	private OrcamentoEntity buscarOrcamentoPorId(Long id) {
		 return orcamentoRepository.findById(id)
		            .orElseThrow(() -> new EntityNotFoundException("Orçamento não encontrado"));
	}
}
