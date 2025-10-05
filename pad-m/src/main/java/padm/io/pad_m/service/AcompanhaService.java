package padm.io.pad_m.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import padm.io.pad_m.domain.Acompanha;
import padm.io.pad_m.repository.AcompanhaRepository;

@Service
public class AcompanhaService {
	@Autowired
	AcompanhaRepository acompanhaRepositor;

	public List<Acompanha> findAll() {
		return acompanhaRepositor.findAll();
	}

	public Optional<Acompanha> findById(Integer id) {
		return acompanhaRepositor.findById(id);
	}

	@Transactional
	public void save(Acompanha obj) {
		acompanhaRepositor.save(obj);
	}

	@Transactional
	public void delete(Acompanha obj) {
		acompanhaRepositor.delete(obj);
	}

}
