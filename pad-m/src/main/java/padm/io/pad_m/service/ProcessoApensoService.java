package padm.io.pad_m.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import padm.io.pad_m.domain.Processo;
import padm.io.pad_m.domain.ProcessoApenso;
import padm.io.pad_m.domain.Usuario;
import padm.io.pad_m.repository.ProcessoApensoRepository;

@Service
public class ProcessoApensoService {

	@Autowired
	ProcessoApensoRepository procsApensoRepository;

	@Autowired
	ProcessoService processoService;

	@Autowired
	UsuarioService usuarioService;

	public List<ProcessoApenso> findAll() {
		return procsApensoRepository.findAll();
	}

	public Optional<ProcessoApenso> findById(Integer id) {
		return procsApensoRepository.findById(id);
	}

	public List<ProcessoApenso> findAllByIdProcesso(Integer idProcesso) {
		return procsApensoRepository.findAllByIdProcesso(idProcesso);
	}

	@Transactional
	public void save(Integer p, String obs, Integer user, Integer[] processos) {

		Processo processo = processoService.findById(p).get();
		Usuario usuario = usuarioService.findById(user).get();
		Integer contador = 0;

		for (contador = 0; contador < processos.length; contador++) {
			ProcessoApenso pa = new ProcessoApenso();
			pa.setIdProcesso(processo);
			pa.setProcesso(processoService.findById(processos[contador]).get());
			pa.setUsuario(usuario);
			pa.setObs(obs);
			pa.setDatacad(LocalDateTime.now());
			procsApensoRepository.save(pa);
		}

	}

	@Transactional
	public Integer delete(ProcessoApenso obj) {
		Integer ret = 0;
		try {
			procsApensoRepository.delete(obj);
			ret = 1;
		} catch (Exception e) {

		}
		return ret;
	}

}
