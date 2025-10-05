package padm.io.pad_m.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import padm.io.pad_m.domain.Atendente;
import padm.io.pad_m.repository.AtendenteRepository;

@Service
public class AtendenteService {
	@Autowired
	AtendenteRepository atendenteRepository;

	public List<Atendente> findAll() {
		return atendenteRepository.findAll();
	}

	public Optional<Atendente> findById(Integer id) {
		return atendenteRepository.findById(id);
	}

	public Optional<Atendente> findAByIdUsuario(Integer idUsuario) {
		return atendenteRepository.findAByIdUsuario(idUsuario);
	}

	@Transactional
	public void save(Atendente obj) {
		atendenteRepository.save(obj);
	}

	@Transactional
	public void delete(Atendente obj) {
		atendenteRepository.delete(obj);
	}

}
