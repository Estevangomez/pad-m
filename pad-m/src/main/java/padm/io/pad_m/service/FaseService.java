package padm.io.pad_m.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import padm.io.pad_m.domain.Fase;
import padm.io.pad_m.repository.FaseRepository;

@Service
public class FaseService {
	@Autowired
	FaseRepository faseRepository;

	public List<Fase> findAll() {
		return faseRepository.findAll();
	}

	public Optional<Fase> findById(Integer id) {
		return faseRepository.findById(id);
	}

	@Transactional
	public void save(Fase obj) {
		faseRepository.save(obj);
	}

	@Transactional
	public void delete(Fase obj) {
		faseRepository.delete(obj);
	}

}
