package padm.io.pad_m.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import padm.io.pad_m.domain.Assinador;

public interface AssinadorRepository extends JpaRepository<Assinador, Integer> {

	@Query("SELECT a FROM Assinador a WHERE a.hashdoc = :hash")
	Optional<Assinador> findAByHash(@Param("hash") String hash);	
	
	@Query("SELECT a FROM Assinador a WHERE a.doc.id =:id")
	List<Assinador> findAllByDocumentoID(@Param("id") Integer id);	
	
	long countByDoc_id(Integer idDoc); 
	
	Optional<Assinador> findFirstByDoc_idOrderByIdDesc(@Param("idDoc") Integer idDoc);
	
	@Query("SELECT a FROM Assinador a WHERE a.userId.id = :idUser AND a.doc.id =:idDoc ")
	Optional<Assinador> findByUserAndDoc(@Param("idUser") Integer idUser, @Param("idDoc") Integer idDoc);
	
	

}
