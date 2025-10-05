package padm.io.pad_m.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import padm.io.pad_m.domain.Doc;
import padm.io.pad_m.domain.Evento;
import padm.io.pad_m.domain.Processo;
import padm.io.pad_m.domain.ProcessoDocs;
import padm.io.pad_m.domain.TipoEvento;
import padm.io.pad_m.domain.Usuario;
import padm.io.pad_m.domain.dto.ProcessoDocumentoDTO;
import padm.io.pad_m.repository.ProcessoDocsRepository;

@Service
public class ProcessoDocsService {

	@Autowired
	ProcessoDocsRepository procsDocsRepository;

	@Autowired
	DocService docService;

	@Autowired
	EventoService eventoService;

	@Autowired
	TipoEventoService tipoEventoService;

	@Autowired
	ProcessoService processoService;

	@Autowired
	UsuarioService usuarioService;

	public List<ProcessoDocs> findAll() {
		return procsDocsRepository.findAll();
	}

	public List<ProcessoDocs> findAllByUser(Integer usuario) {
		return procsDocsRepository.findAllByUser(usuario);
	}

	public Optional<ProcessoDocs> findById(Integer id) {
		return procsDocsRepository.findById(id);
	}

	public Optional<ProcessoDocs> findByIdDoc(Integer idDoc, Integer idProcesso) {
		return procsDocsRepository.findByIdDoc(idDoc, idProcesso);
	}

	public List<ProcessoDocs> findAllByProcesso(Integer idProcesso) {
		return procsDocsRepository.findAllByProcesso(idProcesso);
	}

	@Transactional
	public void save(ProcessoDocumentoDTO obj) {
		ProcessoDocs pdocs = new ProcessoDocs();
		Doc documento = docService.findById(obj.getIdDocumento());
		pdocs.setDocumento(documento);
		Processo processo = processoService.findById(obj.getIdProcesso()).get();
		pdocs.setProcesso(processo);
		Usuario usuario = usuarioService.findById(obj.getIdUsuario()).get();
		pdocs.setUsuario(usuario);
		pdocs.setDatacad(LocalDateTime.now().toString());
		procsDocsRepository.save(pdocs);

		Evento e = new Evento();
		e.setEvento("Usuario : " + usuario.getNome() + " Adicionou o Documento :  " + documento.getNomdoc()
				+ " Ao Processo :  " + processo.getNumanoproc());
		e.setDataevento(LocalDateTime.now());
		e.setUser_id(usuario);
		TipoEvento tpEvento = new TipoEvento();
		tpEvento = tipoEventoService.findById(13).get();
		e.setTipo_id(tpEvento);
		eventoService.save(e);

	}

	@Transactional
	public Integer delete(ProcessoDocs obj) {
		Integer ret = 0;
		try {
			procsDocsRepository.delete(obj);
			ret = 1;
		} catch (Exception e) {

		}
		return ret;
	}

}
