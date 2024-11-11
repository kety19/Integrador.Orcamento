package com.Integrador.integrador.IntegradorService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Integrador.integrador.IntegradorEntites.ProdutoServicoEntity;
import com.Integrador.integrador.IntegradorRepository.ProdutoServicoRepository;

@Service
public class ProdutoServicoService {

	@Autowired
	private ProdutoServicoRepository produtoServicoRepository;

	public ProdutoServicoEntity criarProdutoServico(ProdutoServicoEntity produtoServico) {
	    return produtoServicoRepository.save(produtoServico);
	}
	
	// Método para retornar todos os produtos/serviços
	public List<ProdutoServicoEntity> listarTodos() {
		return produtoServicoRepository.findAll();
	}

	// Defina o método salvarProdutoServico
	public ProdutoServicoEntity salvarProdutoServico(ProdutoServicoEntity produtoServico) {
		return produtoServicoRepository.save(produtoServico);
	}

	public List<ProdutoServicoEntity> buscarTodos() {
		return produtoServicoRepository.findAll();
	}

	public Optional<ProdutoServicoEntity> buscarPorId(Long id) {
		return produtoServicoRepository.findById(id);
	}

	public ProdutoServicoEntity atualizarProdutoServico(Long id, ProdutoServicoEntity produtoServico) {
		produtoServico.setId(id);
		return produtoServicoRepository.save(produtoServico);
	}

	public void deletarProdutoServico(Long id) {
		produtoServicoRepository.deleteById(id);
	}
}
