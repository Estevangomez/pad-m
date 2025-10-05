package padm.io.pad_m.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import padm.io.pad_m.domain.Gestor;
import padm.io.pad_m.repository.GestorRepository;

@Service
public class GestorService {
	@Autowired
	GestorRepository gestorRepository;

	public List<Gestor> findAll() {
		return gestorRepository.findAll();
	}

	public Optional<Gestor> findById(Integer id) {
		return gestorRepository.findById(id);
	}

	@Transactional
	public void save(Gestor obj) {
		gestorRepository.save(obj);
	}

	@Transactional
	public void delete(Gestor obj) {
		gestorRepository.delete(obj);
	}

}
