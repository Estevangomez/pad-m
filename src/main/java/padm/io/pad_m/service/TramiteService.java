package padm.io.pad_m.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import padm.io.pad_m.domain.Tramite;
import padm.io.pad_m.repository.ProcessoRepository;
import padm.io.pad_m.repository.TramiteRepository;

@Service
public class TramiteService {
	@Autowired
	TramiteRepository tramiteRepo;

	@Autowired
	ProcessoRepository processoRepo;

	public List<Tramite> findAll() {
		return tramiteRepo.findAll();
	}

	public List<Tramite> findAllTramitesVencidos(Integer idSertor) {
		return tramiteRepo.findAllTramitesVencidos(idSertor);
	}

	public List<Tramite> findAllByIdProcesso(Integer idProcesso) {
		return tramiteRepo.findAllByIdProcesso(idProcesso);
	}

	public Optional<Tramite> findById(Integer id) {
		return tramiteRepo.findById(id);
	}

	public Optional<Tramite> findBySetorDataSaidaProcesso(Integer idSetor, Integer idProcesso) {
		return tramiteRepo.findBySetorDataSaidaProcesso(idSetor, idProcesso);
	}

	public Tramite findFirstByProcId(Integer idProcesso) {
		return tramiteRepo.findFirstByProcId_id(idProcesso);
	}

	@Transactional
	public void save(Tramite obj) {
		tramiteRepo.save(obj);
	}

	@Transactional
	public void delete(Tramite obj) {
		tramiteRepo.delete(obj);
	}

}
