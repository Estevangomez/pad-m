package padm.io.pad_m.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import padm.io.pad_m.domain.Orgao;
import padm.io.pad_m.repository.OrgaoRepository;

@Service
public class OrgaoService {
	@Autowired
	OrgaoRepository orgaoRepo;

	public List<Orgao> findAll() {
		return orgaoRepo.findAll();
	}

	public Optional<Orgao> findById(Integer id) {
		return orgaoRepo.findById(id);
	}

	@Transactional
	public void save(Orgao obj) {
		orgaoRepo.save(obj);
	}
	
	@Transactional
	public void delete(Orgao obj) {
		orgaoRepo.delete(obj);
	}
	
}
