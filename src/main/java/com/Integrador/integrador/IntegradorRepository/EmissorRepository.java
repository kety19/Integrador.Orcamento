package com.Integrador.integrador.IntegradorRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Integrador.integrador.IntegradorEntites.EmissorEntity;

@Repository
public interface EmissorRepository extends JpaRepository<EmissorEntity, Long> {
}
