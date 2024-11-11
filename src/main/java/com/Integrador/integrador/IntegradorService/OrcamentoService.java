package com.Integrador.integrador.IntegradorService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Integrador.integrador.IntegradorEntites.OrcamentoEntity;
import com.Integrador.integrador.IntegradorEntites.ProdutoServicoEntity;
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
		orcamento.setId(null); // Para garantir que um novo ID seja gerado
		Double total = calcularTotal(orcamento.getProdutosServicos());
		orcamento.setTotal(total); // Definindo o total antes de salvar
		return orcamentoRepository.save(orcamento); // Salvando o orçamento
	}

	public List<OrcamentoEntity> listarTodosOrcamentos() {
		return orcamentoRepository.findAll(); // Retorna todos os orçamentos
	}

	public void deletarOrcamento(Long id) {
		OrcamentoEntity orcamento = buscarOrcamentoPorId(id); // Buscando o orçamento
		orcamentoRepository.delete(orcamento); // Deletando o orçamento
	}

	private OrcamentoEntity buscarOrcamentoPorId(Long id) {
		return orcamentoRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Orçamento não encontrado")); // Tratando exceção se o
																								// orçamento não for
																								// encontrado
	}

    // Método para calcular o total do orçamento
    public Double calcularOrcamento(List<ProdutoServicoEntity> produtosServicos) {
        return calcularTotal(produtosServicos);
    }
    // Método privado que faz o cálculo
    public Double calcularTotal(List<ProdutoServicoEntity> produtosServicos) {
        if (produtosServicos == null || produtosServicos.isEmpty()) {
            return 0.0;
        }
        return produtosServicos.stream()
                               .mapToDouble(produto -> produto.getPreco() * produto.getQuantidade())
                               .sum();
    }
}