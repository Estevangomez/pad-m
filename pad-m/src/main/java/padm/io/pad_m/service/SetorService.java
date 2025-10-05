package padm.io.pad_m.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import padm.io.pad_m.domain.Setor;
import padm.io.pad_m.repository.SetorRepository;

@Service
public class SetorService {
	@Autowired
	SetorRepository setorRepository;

	public List<Setor> findAll() {
		return setorRepository.findAll();
	}
	/*
	public List<Setor> findAllByIdOrgaoAndIdLocalidadeAndUnidade(Integer idOrgao, Integer idLocalidade, Integer idUnidade) {
		return setorRepository.findAllByIdOrgaoAndIdLocalidadeAndUnidade(idOrgao,idLocalidade,idUnidade);
	}
*/
	public Optional<Setor> findById(Integer id) {
		return setorRepository.findById(id);
	}

	@Transactional
	public void save(Setor obj) {
		setorRepository.save(obj);
	}

	@Transactional
	public void delete(Setor obj) {
		setorRepository.delete(obj);
	}

}
