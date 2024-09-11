package IntegradorEntites;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class ProdutoServicoEntity {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
		private String descricao;
	    private Double precoUnitario;
	    private Integer quantidade;

	    @ManyToOne
	    private OrcamentoEntity orcamento; 

}
