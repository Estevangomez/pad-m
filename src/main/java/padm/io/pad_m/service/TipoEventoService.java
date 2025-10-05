package padm.io.pad_m.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import padm.io.pad_m.domain.TipoEvento;
import padm.io.pad_m.repository.TipoEventoRepository;

@Service
public class TipoEventoService {
	@Autowired
	TipoEventoRepository tipoEventoRepository;

	public List<TipoEvento> findAll() {
		return tipoEventoRepository.findAll();
	}

	public Optional<TipoEvento> findById(Integer id) {
		return tipoEventoRepository.findById(id);
	}

	@Transactional
	public void save(TipoEvento obj) {
		tipoEventoRepository.save(obj);
	}

	@Transactional
	public void delete(TipoEvento obj) {
		tipoEventoRepository.delete(obj);
	}

}
