package padm.io.pad_m.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import padm.io.pad_m.domain.Servidor;
import padm.io.pad_m.repository.ServidorRepository;

@Service
public class ServidorService {
	@Autowired
	ServidorRepository servidorRepository;

	public List<Servidor> findAll() {
		return servidorRepository.findAll();
	}

	public Optional<List<Servidor>> findAllBySetor(Integer idSetor) {
		return servidorRepository.findAllBySetor(idSetor);
	}

	public Optional<Servidor> findById(Integer id) {
		return servidorRepository.findById(id);
	}

	@Transactional
	public void save(Servidor obj) {
		servidorRepository.save(obj);
	}

	@Transactional
	public void delete(Servidor obj) {
		servidorRepository.delete(obj);
	}

}
