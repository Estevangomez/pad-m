package padm.io.pad_m.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import padm.io.pad_m.domain.Classif;

public interface ClassifRepository extends JpaRepository<Classif, Integer> {

	
	@Query("SELECT c FROM Classif c ORDER BY c.nome")
	List<Classif> findAllOrderedByNome();
	
}
