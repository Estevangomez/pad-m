package padm.io.pad_m.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import padm.io.pad_m.domain.Moderador;
import padm.io.pad_m.repository.ModeradorRepository;

@Service
public class ModeradorService {
	@Autowired
	ModeradorRepository ModeradorRepository;

	public List<Moderador> findAll() {
		return ModeradorRepository.findAll();
	}

	public Optional<Moderador> findById(Integer id) {
		return ModeradorRepository.findById(id);
	}

	@Transactional
	public void save(Moderador obj) {
		ModeradorRepository.save(obj);
	}

	@Transactional
	public void delete(Moderador obj) {
		ModeradorRepository.delete(obj);
	}

}
