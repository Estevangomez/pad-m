package padm.io.pad_m.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import padm.io.pad_m.domain.Setor;

public interface SetorRepository extends JpaRepository<Setor, Integer> {

	@Query(value = "SELECT s FROM Setor s WHERE s.unidadelotacaoid = :unidade ORDER BY nome")
	Optional<Setor> findSetorByUnidade(@Param("unidade") Integer unidade);
	/*
	@Query("SELECT s FROM Setor s  WHERE s.orgaoid.id =:idOrgao AND s.localidadeid.id =:idLocalidade AND s.unidadelotacaoid =:idUnidade order by s.nome")
	List<Setor> findAllByIdOrgaoAndIdLocalidadeAndUnidade(@Param("idOrgao") Integer idOrgao,
			@Param("idLocalidade") Integer idLocalidade, @Param("idUnidade") Integer idUnidade);
	*/

	@Query("SELECT s FROM Setor s order by s.nome")
	List<Setor> findAll();

}
