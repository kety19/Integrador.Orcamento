package IntegradorRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import IntegradorEntites.EmissorEntity;

@Repository
	public interface EmissorRepository extends JpaRepository<EmissorEntity, Long> {
	}

