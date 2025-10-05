package padm.io.pad_m.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import padm.io.pad_m.domain.Finalidade;
import padm.io.pad_m.repository.FinalidadeRepository;

@Service
public class FinalidadeService {
	@Autowired
	FinalidadeRepository finalidadeRepository;

	public List<Finalidade> findAll() {
		return finalidadeRepository.findAll();
	}

	public Optional<Finalidade> findById(Integer id) {
		return finalidadeRepository.findById(id);
	}

	@Transactional
	public void save(Finalidade obj) {
		finalidadeRepository.save(obj);
	}

	@Transactional
	public void delete(Finalidade obj) {
		finalidadeRepository.delete(obj);
	}

}
