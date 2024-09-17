
package com.Integrador.integrador.IntegradorRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Integrador.integrador.IntegradorEntites.ProdutoServicoEntity;

@Repository
public interface ProdutoServicoRepository extends JpaRepository<ProdutoServicoEntity, Long> {
}
