package com.Integrador.integrador.IntegradorService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Integrador.integrador.IntegradorEntites.ProdutoServicoEntity;
import com.Integrador.integrador.IntegradorRepository.ProdutoServicoRepository;

@Service
public class ProdutoServicoService {

    @Autowired
    private ProdutoServicoRepository produtoServicoRepository;

    public ProdutoServicoEntity salvarProdutoServico(ProdutoServicoEntity produtoServico) {
        return produtoServicoRepository.save(produtoServico);
    }

    public List<ProdutoServicoEntity> listarTodosProdutosServicos() {
        return produtoServicoRepository.findAll();
    }
    
    public void deletarProdutoServico(Long id) {
        ProdutoServicoEntity produtoServico = buscarProdutoServicoPorId(id);
        produtoServicoRepository.delete(produtoServico);
    }

	private ProdutoServicoEntity buscarProdutoServicoPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
}
