package padm.io.pad_m.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import padm.io.pad_m.domain.Tramite;

public interface TramiteRepository extends JpaRepository<Tramite, Integer> {

	// @Query(value = "SELECT * FROM tbtramite WHERE proc_id =:idProcesso ORDER BY
	// id DESC", nativeQuery = true)
	Tramite findFirstByProcId_id(@Param("idProcesso") Integer idProcesso);

	@Query(value = "SELECT * FROM tbtramite WHERE proc_id = :idProcesso ORDER BY id DESC", nativeQuery = true)
	List<Tramite> findAllByIdProcesso(@Param("idProcesso") Integer idProcesso);

	@Query("SELECT t FROM Tramite t WHERE t.datavencimentoresposta < CURRENT_DATE() AND t.setordestino.id =:idSetor AND t.datasaida IS NULL ")
	List<Tramite> findAllTramitesVencidos(@Param("idSetor") Integer idSetor);

	@Query("SELECT t FROM Tramite t WHERE t.setordestino.id =:idSetor AND t.datasaida IS NULL AND t.procId.id =:idProcesso ")
	Optional<Tramite> findBySetorDataSaidaProcesso(@Param("idSetor") Integer idSetor,
			@Param("idProcesso") Integer idProcesso);

}
