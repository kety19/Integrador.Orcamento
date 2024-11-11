package com.Integrador.integrador.IntegradorRepository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Integrador.integrador.IntegradorEntites.OrcamentoEntity;

@Repository
public interface OrcamentoRepository extends JpaRepository<OrcamentoEntity, Long> {
    
    @Query("SELECT o FROM OrcamentoEntity o LEFT JOIN FETCH o.cliente LEFT JOIN FETCH o.emissor LEFT JOIN FETCH o.produtosServicos WHERE o.id = :id")
    Optional<OrcamentoEntity> findByIdWithRelations(@Param("id") Long id);  // Retorna Optional
}