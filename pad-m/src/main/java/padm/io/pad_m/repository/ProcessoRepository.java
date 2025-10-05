package padm.io.pad_m.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import padm.io.pad_m.domain.Processo;

public interface ProcessoRepository extends JpaRepository<Processo, Integer> {

	@Query("SELECT p from Processo p WHERE p.tramitado = 0 AND p.arquivado = 0 AND p.setorcriadorId.id =:idSetor ORDER BY p.id DESC ")
	List<Processo> findAllBySetor(@Param("idSetor") Integer idSetor);

	@Query("SELECT p from Processo p WHERE p.id IN ( SELECT t.procId.id FROM Tramite t WHERE t.datasaida IS NULL AND t.setordestino.id =:idSetor ) ORDER BY p.id DESC ")
	List<Processo> findAllTramitadosBySetor(@Param("idSetor") Integer idSetor);
	
	@Query("SELECT p from Processo p WHERE p.arquivado = 1 AND p.setorcriadorId.id =:idSetor ORDER BY p.id DESC ")
	List<Processo> findAllArquivadosBySetor(@Param("idSetor") Integer idSetor);

	@Query("SELECT p from Processo p WHERE p.usucriadorId =:idUser ORDER BY p.id DESC")
	List<Processo> findAllByUserCriador(@Param("idUser") Integer idUser);

	@Query("SELECT p from Processo p WHERE p.tipo.id =:idTipo ORDER BY p.id DESC")
	List<Processo> findAllByTipo(@Param("idTipo") Integer idTipo);
	
	@Query("SELECT p from Processo p WHERE p.id IN (select t.procId.id from Tramite t where t.responsavelId.id =:servidorAtendente AND t.dataarquivamento IS NULL AND t.datasaida IS NULL) ORDER BY p.id DESC")
	List<Processo> findAllByServidorAtendenteResposanvel(@Param("servidorAtendente") Integer servidorAtendente);
	
	@Query("SELECT COUNT(p.id) FROM Processo p WHERE p.id IN (SELECT t.procId.id FROM Tramite t WHERE t.responsavelId.id =:idUsuario AND t.datasaida IS NULL AND t.dataarquivamento IS NULL) ")
	long countProcessosParaAtenderByServidor(@Param("idUsuario") Integer idUsuario);
	
	@Query(" SELECT COUNT(p.id) FROM Processo p  WHERE  p.id IN (SELECT t.procId.id FROM Tramite t WHERE t.setordestino.id =:idSetor AND t.datasaida IS NULL AND t.dataarquivamento IS NULL) ")
	long countProcessosEmEsperaBySetor(@Param("idSetor") Integer category);

}
