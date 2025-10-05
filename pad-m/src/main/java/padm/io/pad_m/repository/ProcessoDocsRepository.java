package padm.io.pad_m.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import padm.io.pad_m.domain.ProcessoDocs;

public interface ProcessoDocsRepository extends JpaRepository<ProcessoDocs, Integer> {
	
	@Query(value="SELECT * FROM tbprocessodocs WHERE usuario_id =:usuario ORDER BY id", nativeQuery = true)
	List<ProcessoDocs> findAllByUser(@Param("usuario") Integer usuario );
	
	@Query(value="SELECT * FROM tbprocessodocs WHERE processo_id =:idProcesso ORDER BY id", nativeQuery = true)
	List<ProcessoDocs> findAllByProcesso(@Param("idProcesso") Integer idProcesso );
	
	@Query(value="SELECT * FROM tbprocessodocs WHERE documento_id =:idDoc AND  processo_id =:idProcesso ORDER BY id", nativeQuery = true)
	Optional<ProcessoDocs> findByIdDoc(@Param("idDoc") Integer idDoc, @Param("idProcesso") Integer idProcesso );
	
}
