package padm.io.pad_m.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import padm.io.pad_m.domain.UnidadeLotacao;

public interface UnidadeLotacaoRepository extends JpaRepository<UnidadeLotacao, Integer> {

	List<UnidadeLotacao> findAll();

	@Query("SELECT u FROM UnidadeLotacao u  WHERE u.orgaoid.id =:idOrgao AND u.localidadeid.id =:idLocalidade order by u.nome")
	List<UnidadeLotacao> findAllByIdOrgaoAndIdLocalidade(@Param("idOrgao") Integer idOrgao, @Param("idLocalidade") Integer idLocalidade);

}
