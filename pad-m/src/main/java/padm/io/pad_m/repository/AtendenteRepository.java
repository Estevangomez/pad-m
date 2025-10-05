package padm.io.pad_m.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import padm.io.pad_m.domain.Atendente;

public interface AtendenteRepository extends JpaRepository<Atendente, Integer> {

	@Query(value = "SELECT a FROM Atendente a WHERE a.usuario.id =:idUsuario")
	Optional<Atendente> findAByIdUsuario(@Param("idUsuario") Integer idUsuario);

}
