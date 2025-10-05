package padm.io.pad_m.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import padm.io.pad_m.domain.Sigilo;
import padm.io.pad_m.repository.SigiloRepository;

@Service
public class SigiloService {
	@Autowired
	SigiloRepository sigiloRepository;

	public List<Sigilo> findAll() {
		return sigiloRepository.findAll();
	}

	public Optional<Sigilo> findById(Integer id) {
		return sigiloRepository.findById(id);
	}

	@Transactional
	public void save(Sigilo obj) {
		sigiloRepository.save(obj);
	}

	@Transactional
	public void delete(Sigilo obj) {
		sigiloRepository.delete(obj);
	}

}
