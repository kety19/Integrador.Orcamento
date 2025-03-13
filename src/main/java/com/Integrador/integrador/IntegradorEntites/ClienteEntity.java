package com.Integrador.integrador.IntegradorEntites;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Data
public class ClienteEntity implements UserDetails {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

		private String nome;
	    private String endereco;
	    private String telefone;
	    private String email;
		@Getter
        private String password;


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of();
	}

    ;

	public String getUsername(){
		return nome;
	};
}


