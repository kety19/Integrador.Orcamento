package com.Integrador.integrador.IntegradorService;

import org.springframework.context.annotation.Configuration;

import org.springframework.stereotype.Service;
import com.Integrador.integrador.IntegradorEntites.OrcamentoEntity;
import com.Integrador.integrador.IntegradorEntites.ProdutoServicoEntity;


@Service
public class SomarService {

		
		public void total(OrcamentoEntity orcamento) {

			double total = 0;
			for (ProdutoServicoEntity ps : orcamento.getProdutosServicos()) {
				total += ps.getPrecoUnitario() * ps.getQuantidade();
			}
			orcamento.setTotal(total);
		}
	}
