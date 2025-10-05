package padm.io.pad_m.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import padm.io.pad_m.domain.Classif;
import padm.io.pad_m.repository.ClassifRepository;

@Service
public class ClassifService {
	@Autowired
	ClassifRepository classifRepository;

	public List<Classif> findAll() {
		return classifRepository.findAllOrderedByNome();
	}

	public Optional<Classif> findById(Integer id) {
		return classifRepository.findById(id);
	}

	@Transactional
	public void save(Classif obj) {
		classifRepository.save(obj);
	}

	@Transactional
	public void delete(Classif obj) {
		classifRepository.delete(obj);
	}

}
