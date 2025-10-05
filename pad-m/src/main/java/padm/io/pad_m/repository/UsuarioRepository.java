package padm.io.pad_m.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import padm.io.pad_m.domain.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	
	@Query(value="SELECT * FROM tbusuario WHERE cpf = :cpf ORDER BY nome", nativeQuery = true)
	Optional<Usuario> findByCpf(@Param("cpf") String cpf );
	
	
	@Query(value="SELECT u FROM Usuario u WHERE u.lotacao_id.id =:idSetor ORDER BY u.nome")
	Optional<List<Usuario>> findAllBySetor(@Param("idSetor") Integer idSetor );
	
	
}
