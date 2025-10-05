package padm.io.pad_m.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import padm.io.pad_m.domain.PerfilUsuario;
import padm.io.pad_m.repository.PerfilUsuarioRepository;

@Service
public class PerfilUsuarioService {
	@Autowired
	PerfilUsuarioRepository perfilUsuarioRepository;

	public List<PerfilUsuario> findAll() {
		return perfilUsuarioRepository.findAll();
	}

	public Optional<PerfilUsuario> findById(Integer id) {
		return perfilUsuarioRepository.findById(id);
	}

	@Transactional
	public void save(PerfilUsuario obj) {
		perfilUsuarioRepository.save(obj);
	}

	@Transactional
	public void delete(PerfilUsuario obj) {
		perfilUsuarioRepository.delete(obj);
	}

}
