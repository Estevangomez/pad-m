package padm.io.pad_m.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import padm.io.pad_m.domain.Processo;
import padm.io.pad_m.domain.TipoProcesso;
import padm.io.pad_m.repository.TipoProcessoRepository;

@Service
public class TipoProcessoService {
	@Autowired
	TipoProcessoRepository tipoProcessoRepo;

	public List<TipoProcesso> findAll() {
		return tipoProcessoRepo.findAll();
	}

	public Optional<TipoProcesso> findById(Integer id) {
		return tipoProcessoRepo.findById(id);
	}

	@Transactional
	public TipoProcesso save(TipoProcesso obj) {
		return tipoProcessoRepo.save(obj);
	}

	@Transactional
	public void delete(TipoProcesso obj) {
		tipoProcessoRepo.delete(obj);
	}

}
