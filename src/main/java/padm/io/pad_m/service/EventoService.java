package padm.io.pad_m.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import padm.io.pad_m.domain.Evento;
import padm.io.pad_m.repository.EventoRepository;

@Service
public class EventoService {

	@Autowired
	EventoRepository eventoRepository;

	public List<Evento> findAll() {
		return eventoRepository.findAll();
	}

	public Optional<Evento> findById(Integer id) {
		return eventoRepository.findById(id);
	}

	public Optional<List<Evento>> findAllByIdProcesso(Integer id) {
		return eventoRepository.findAllByIdProcesso(id);
	}
	
	public Evento findFirstByProcessoId(Integer proc_id) {
		return eventoRepository.findFirstByProcessoId(proc_id);
	}

	@Transactional
	public void save(Evento obj) {
		eventoRepository.save(obj);
	}

	@Transactional
	public void delete(Evento obj) {
		eventoRepository.delete(obj);
	}

}
