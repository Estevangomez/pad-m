package padm.io.pad_m.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import padm.io.pad_m.domain.TipoDoc;
import padm.io.pad_m.repository.TipoDocRepository;

@Service
public class TipoDocService {
	@Autowired
	TipoDocRepository tipoDocRepository;

	public List<TipoDoc> findAll() {
		return tipoDocRepository.findAll();
	}

	public Optional<TipoDoc> findById(Integer id) {
		return tipoDocRepository.findById(id);
	}

	@Transactional
	public void save(TipoDoc obj) {
		tipoDocRepository.save(obj);
	}

	@Transactional
	public void delete(TipoDoc obj) {
		tipoDocRepository.delete(obj);
	}

}
