package com.Integrador.integrador.IntegradorRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Integrador.integrador.IntegradorEntites.OrcamentoEntity;

@Repository
public interface OrcamentoRepository extends JpaRepository<OrcamentoEntity, Long> {
}
