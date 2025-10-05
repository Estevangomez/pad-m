package padm.io.pad_m.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import padm.io.pad_m.domain.Assinador;
import padm.io.pad_m.repository.AssinadorRepository;

@Service
public class AssinadorService {
	@Autowired
	AssinadorRepository assinadorRepositor;

	public List<Assinador> findAll() {
		return assinadorRepositor.findAll();
	}

	public Optional<Assinador> findById(Integer id) {
		return assinadorRepositor.findById(id);
	}

	public long countByDoc_id(Integer iddoc) {
		return assinadorRepositor.countByDoc_id(iddoc);
	}

	public Optional<Assinador> findAByHash(String hash) {
		return assinadorRepositor.findAByHash(hash);
	}
	
	public List<Assinador> findAllByDocumentoID(Integer id) {
		return assinadorRepositor.findAllByDocumentoID(id);
	}

	public Integer findByUserAndDoc(Integer idUser, Integer idDoc) {// metodo para verificar se o usuario ja assinou o
																	// documento 1 - SIM / 0 - NAO
		Integer ret = 0;
		Optional<Assinador> a = assinadorRepositor.findByUserAndDoc(idUser, idDoc);
		if (a.isPresent()) {
			ret = 1;
		}
		return ret;
	}

	public Optional<Assinador> findFirstByDoc_id(Integer idDoc) {
		return assinadorRepositor.findFirstByDoc_idOrderByIdDesc(idDoc);
	}

	@Transactional
	public void save(Assinador obj) {
		assinadorRepositor.save(obj);
	}

	@Transactional
	public void delete(Assinador obj) {
		assinadorRepositor.delete(obj);
	}

}
