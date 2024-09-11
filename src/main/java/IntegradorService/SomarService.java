package IntegradorService;

import org.springframework.stereotype.Service;
import IntegradorEntites.OrcamentoEntity;
import IntegradorEntites.ProdutoServicoEntity;

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
