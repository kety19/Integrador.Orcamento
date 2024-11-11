package com.Integrador.integrador.IntegradorEntites;

import java.time.LocalDateTime;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
    private LocalDateTime dataCriacao;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orcamento") 
    private List<ProdutoServicoEntity> produtosServicos;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "emissor_id")
    private EmissorEntity emissor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id")
    private ClienteEntity cliente;


    // Construtor padrão
    public OrcamentoEntity() {}

}


