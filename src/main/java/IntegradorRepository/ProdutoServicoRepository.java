
package IntegradorRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import IntegradorEntites.ProdutoServicoEntity;

@Repository
public interface ProdutoServicoRepository extends JpaRepository<ProdutoServicoEntity, Long> {
}
