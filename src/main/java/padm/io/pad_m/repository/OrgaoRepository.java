package padm.io.pad_m.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import padm.io.pad_m.domain.Orgao;

public interface OrgaoRepository extends JpaRepository<Orgao, Integer> {
	
	
	@Query("SELECT o FROM Orgao o order by o.nome")
	List<Orgao> findAll();

}
