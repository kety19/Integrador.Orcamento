package com.Integrador.integrador.IntegradorEntites;

import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.Getter;

@Entity
@Data
public class OrcamentoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String observacoes;
	private Double total;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "orcamento") 
	private List<ProdutoServicoEntity> produtosServicos;
	
	@ManyToOne
	private EmissorEntity emissor;

	@ManyToOne
	private ClienteEntity cliente;

	 // Setter para produtos e serviços
    public void setProdutosServicos(List<ProdutoServicoEntity> produtosServicos) {
        this.produtosServicos = produtosServicos;
        calcularTotal();  // Calcula o total sempre que a lista de produtos/serviços for modificada
    }

    // Método para calcular o total
    public void calcularTotal() {
        this.total = produtosServicos.stream()
                        .mapToDouble(produto -> produto.getPrecoUnitario() * produto.getQuantidade())
                        .sum();
    }
}


