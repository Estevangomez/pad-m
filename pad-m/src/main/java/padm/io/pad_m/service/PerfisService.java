package padm.io.pad_m.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import padm.io.pad_m.domain.Perfis;
import padm.io.pad_m.repository.PerfisRepository;

@Service
public class PerfisService {

	@Autowired
	PerfisRepository perfisRepo;

	@Transactional
	public void save(Perfis p) {
		perfisRepo.save(p);
	}

	@Transactional
	public void delete(Integer id) {
		perfisRepo.deleteById(id);
	}

}
