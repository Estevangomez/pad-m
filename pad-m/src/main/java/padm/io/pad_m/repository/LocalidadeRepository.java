package padm.io.pad_m.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import padm.io.pad_m.domain.Localidade;

public interface LocalidadeRepository extends JpaRepository<Localidade, Integer> {
		
	
	
}
