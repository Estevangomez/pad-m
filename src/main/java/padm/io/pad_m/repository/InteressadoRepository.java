package padm.io.pad_m.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import padm.io.pad_m.domain.Interessado;

public interface InteressadoRepository extends JpaRepository<Interessado, Integer> {
	
	@Query(" SELECT i FROM Interessado i WHERE i.proc_id.id =:idProcesso ORDER BY i.interessado")
	List<Interessado> findAllByIdProcesso(@Param("idProcesso") Integer idProcesso);
	
	@Query(" SELECT count(i) FROM Interessado i WHERE i.usu_id.id =:idUsuario")
	Integer totalInteressadoByidUser(@Param("idUsuario") Integer idUsuario);
	
	
}
