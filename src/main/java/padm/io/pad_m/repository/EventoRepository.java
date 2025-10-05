package padm.io.pad_m.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import padm.io.pad_m.domain.Evento;

public interface EventoRepository extends JpaRepository<Evento, Integer> {

	@Query(value="SELECT e FROM Evento e WHERE e.proc_id.id =:idProcesso ORDER BY e.id DESC")
	Optional<List<Evento>> findAllByIdProcesso(@Param("idProcesso") Integer idProcesso );
	
	@Query(value = "SELECT TOP 1 * FROM tbevento WHERE proc_id =:idProcesso ORDER BY id DESC ", nativeQuery = true)
	Evento findFirstByProcessoId(@Param("idProcesso") Integer idProcesso);
	
}
