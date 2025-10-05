package padm.io.pad_m.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import padm.io.pad_m.domain.ProcessoApenso;

public interface ProcessoApensoRepository extends JpaRepository<ProcessoApenso, Integer> {
	
	@Query(value = "SELECT a FROM ProcessoApenso a WHERE a.idProcesso.id =:idProcesso ORDER BY a.id DESC")
	List<ProcessoApenso> findAllByIdProcesso(@Param("idProcesso") Integer idProcesso);

	
}
