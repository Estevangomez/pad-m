package padm.io.pad_m.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import padm.io.pad_m.domain.UnidadeLotacao;
import padm.io.pad_m.repository.UnidadeLotacaoRepository;

@Service
public class UnidadeLotacaoService {
	@Autowired
	UnidadeLotacaoRepository unidadeRepository;

	public List<UnidadeLotacao> findAll() {
		return unidadeRepository.findAll();
	}
	
	public List<UnidadeLotacao> findAllByIdOrgaoAndIdLocalidade(Integer idOrgao, Integer idLocalidade) {
		return unidadeRepository.findAllByIdOrgaoAndIdLocalidade(idOrgao,idLocalidade);
	}
	

	public Optional<UnidadeLotacao> findById(Integer id) {
		return unidadeRepository.findById(id);
	}

	@Transactional
	public void save(UnidadeLotacao obj) {
		unidadeRepository.save(obj);
	}

	@Transactional
	public void delete(UnidadeLotacao obj) {
		unidadeRepository.delete(obj);
	}

}
