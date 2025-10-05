package padm.io.pad_m.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import padm.io.pad_m.domain.Doc;
import padm.io.pad_m.domain.Usuario;

public interface DocRepository extends JpaRepository<Doc, Integer> {

    @Query("SELECT d FROM Doc d WHERE d.usu_id = :usuario")
    List<Doc> findAllDocumentosByUsuario(@Param("usuario") Usuario usuario, Pageable pageable); 
    
    @Query("SELECT d FROM Doc d WHERE d.usu_id.id =:idUsuario")
    Page<Doc> findByUsuarioIdCustom(@Param("idUsuario") Integer idUsuario, Pageable pageable);
    
    @Query("SELECT d FROM Doc d WHERE d.hashdoc = :hash")
    Optional<Doc> findByHashdoc(@Param("hash") String hash);
    
   
    
}
