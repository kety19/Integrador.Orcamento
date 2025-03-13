package com.Integrador.integrador.IntegradorRepository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Integrador.integrador.IntegradorEntites.ClienteEntity;
@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {
	
	@Query(value = "select * from usuario where nome = ?1", nativeQuery = true)
    Optional<ClienteEntity> findByNomr(String login);
	
}

