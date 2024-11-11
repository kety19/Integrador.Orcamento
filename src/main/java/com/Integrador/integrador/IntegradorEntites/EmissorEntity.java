package com.Integrador.integrador.IntegradorEntites;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class EmissorEntity {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

		private String nome;
	    private String endereco;
	    private String telefone;
	    private String email;
	    private String logoUrl;
	    private String cnpj;
	    
	    public EmissorEntity() {
	    }
	    public EmissorEntity(String nome, String cnpj) {
	        this.nome = nome;
	        this.cnpj = cnpj;
	    }
	    

}
