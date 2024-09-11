package IntegradorEntites;

import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class OrcamentoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String observacoes;
	private Double total;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "orcamento") 
	
	public List<ProdutoServicoEntity> getProdutosServicos() {
	    return null;
	}
	@ManyToOne
	private EmissorEntity emissor;

	@ManyToOne
	private ClienteEntity cliente;



}
