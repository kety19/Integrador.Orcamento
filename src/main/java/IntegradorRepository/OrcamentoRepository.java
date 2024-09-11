package IntegradorRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import IntegradorEntites.OrcamentoEntity;

@Repository
public interface OrcamentoRepository extends JpaRepository<OrcamentoEntity, Long> {
}
