package padm.io.pad_m.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import padm.io.pad_m.domain.Usuario;
import padm.io.pad_m.repository.UsuarioRepository;

@Service
public class UsuarioService {
	@Autowired
	UsuarioRepository usuariorepo;

	public List<Usuario> findAll() {
		return usuariorepo.findAll();
	}

	public Optional<List<Usuario>> findAllBySetor(Integer idSetor) {
		return usuariorepo.findAllBySetor(idSetor);
	}

	public Optional<Usuario> findById(Integer id) {
		return usuariorepo.findById(id);
	}

	public Optional<Usuario> findByCpf(String email) {
		return usuariorepo.findByCpf(email);
	}

	@Transactional
	public void save(Usuario obj) {
		usuariorepo.save(obj);
	}

	@Transactional
	public void delete(Usuario obj) {
		usuariorepo.delete(obj);
	}

}
