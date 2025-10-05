package padm.io.pad_m.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import padm.io.pad_m.domain.Localidade;
import padm.io.pad_m.repository.LocalidadeRepository;

@Service
public class LocalidadeService {
	@Autowired
	LocalidadeRepository localidadeRepository;

	public List<Localidade> findAll() {
		return localidadeRepository.findAll();
	}

	public Optional<Localidade> findById(Integer id) {
		return localidadeRepository.findById(id);
	}

	@Transactional
	public void save(Localidade obj) {
		localidadeRepository.save(obj);
	}

	@Transactional
	public void delete(Localidade obj) {
		localidadeRepository.delete(obj);
	}

}
