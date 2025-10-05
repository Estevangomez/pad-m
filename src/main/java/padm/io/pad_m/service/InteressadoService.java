package padm.io.pad_m.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import padm.io.pad_m.domain.Interessado;
import padm.io.pad_m.domain.Processo;
import padm.io.pad_m.domain.Setor;
import padm.io.pad_m.domain.Usuario;
import padm.io.pad_m.domain.dto.InteressadoDTO;
import padm.io.pad_m.repository.InteressadoRepository;
import padm.io.pad_m.repository.SetorRepository;
import padm.io.pad_m.repository.UsuarioRepository;

@Service
public class InteressadoService {
	@Autowired
	InteressadoRepository interessadoRepository;
	
	@Autowired
	SetorRepository setorRepository;
	
	@Autowired
	UsuarioRepository usuarioRepository;

	public List<Interessado> findAll() {
		return interessadoRepository.findAll();
	}
	
	public List<Interessado> findAllByIdProcesso(Integer idProcesso) {
		return interessadoRepository.findAllByIdProcesso(idProcesso);
	}
	
	public Integer totalInteressadoByidUser(Integer idUsser) {
		return interessadoRepository.totalInteressadoByidUser(idUsser);
	}
	

	public Optional<Interessado> findById(Integer id) {
		return interessadoRepository.findById(id);
	}

	@Transactional
	public void saveSetorInteressado(InteressadoDTO obj) {
		Interessado interessado = new Interessado ();
		
		Processo p = new Processo();
		p.setId(obj.getIdProcesso());
		interessado.setProc_id(p);
		
		Setor s = new Setor();
		s = setorRepository.findById(obj.getIdSetor()).get();
		interessado.setInteressado(s.getNome());
		interessado.setSetor(s);
		
		interessadoRepository.save(interessado);		
	}
	
	
	@Transactional
	public void saveUsuarioInteressado(InteressadoDTO obj) {
		Interessado interessado = new Interessado ();
		
		Processo p = new Processo();
		p.setId(obj.getIdProcesso());
		interessado.setProc_id(p);
		
		Usuario u =  new Usuario();
		u = usuarioRepository.findById(obj.getIdUsuario()).get();
		interessado.setInteressado(u.getNome());
		interessado.setUsu_id(u);
		
		interessadoRepository.save(interessado);
		
	}

	@Transactional
	public Integer delete(Interessado obj) {
		Integer ret = 0;
		try {
			interessadoRepository.delete(obj);
			ret =1;
		} catch (Exception e) {
			
		}
		
		return ret;
	}

}
