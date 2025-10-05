package padm.io.pad_m.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import padm.io.pad_m.domain.Servidor;

public interface ServidorRepository extends JpaRepository<Servidor, Integer> {
	
	@Query(value="SELECT s FROM Servidor s WHERE s.setorlotacaoId =:idSetor ORDER BY s.nome")
	Optional<List<Servidor>> findAllBySetor(@Param("idSetor") Integer idSetor );
	
}
