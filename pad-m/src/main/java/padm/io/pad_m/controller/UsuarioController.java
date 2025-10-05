package padm.io.pad_m.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import padm.io.pad_m.domain.Perfis;
import padm.io.pad_m.domain.Servidor;
import padm.io.pad_m.domain.Setor;
import padm.io.pad_m.domain.Usuario;
import padm.io.pad_m.fileserver.FilesStorageService;
import padm.io.pad_m.security.AuthenticationFacade;
import padm.io.pad_m.service.PerfisService;
import padm.io.pad_m.service.ServidorService;
import padm.io.pad_m.service.SetorService;
import padm.io.pad_m.service.UsuarioService;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

	DateTimeFormatter parser = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private final String frmUsuario = "form/frmCadUsuario";

	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private ServidorService servidorService;

	@Autowired
	AuthenticationFacade session;
	
	@Autowired
	private SetorService setorService;
	
	@Autowired
	PerfisService perfisService;
	
	@Autowired
	private FilesStorageService storageService;

	
	@Value("${path.upload}")
	String upload;
	


	@GetMapping
	public ModelAndView findAll() {
		ModelAndView mv = new ModelAndView("consulta/usuarios");	
		Optional<List<Usuario>> users = usuarioService.findAllBySetor(session.getUsuario().getLotacao_id().getId());	
		mv.addObject("usuarios", usuarioService.findAllBySetor(session.getUsuario().getLotacao_id().getId()).get());
		mv.addObject("activePage", "mnuCandidato");
		return mv;
	}

	@GetMapping("/new")
	public String frmCadastrar(Model model, @ModelAttribute("usuario") Usuario usuario) {	
		List<Setor> setores = setorService.findAll();
		model.addAttribute("usuario", usuario);		
		model.addAttribute("setores", setores);
		model.addAttribute("msg", 0);
		model.addAttribute("activePage", "mnuCandidato");
		return "form/frmCadUsuario";
	}

	@GetMapping("/edit/{id}")
	public ModelAndView frmEditar(@PathVariable(name = "id") Integer id) {
		ModelAndView model = new ModelAndView(frmUsuario);
		Usuario user = usuarioService.findById(id).get();
		List<Setor> setores = setorService.findAll();
		model.addObject("setores", setores);
		model.addObject("usuario", user);
		model.addObject("msg", 0);
		model.addObject("idServidor", user.getServidorId().getId());
		
		return model;
	}

	@PostMapping("/save")
	public ModelAndView saveObject(@ModelAttribute("usuario") Usuario usuario,  @RequestParam(name = "file", required = false) MultipartFile file, BindingResult result) {
		try {	
			Optional<Usuario> u = usuarioService.findByCpf(usuario.getCpf().trim());			
			if(u.isPresent()){
				ModelAndView model = new ModelAndView(frmUsuario);
				model.addObject("msg", 1);
				return model;
			}
			
			usuario.setFlag(1);
			usuario.setDatacriacao(LocalDateTime.now());
			usuario.setUltimoacesso(LocalDateTime.now());	
		
			 if (file != null && !file.isEmpty()) { 
		            storageService.save(file, "fotos");                  
		            usuario.setImage(storageService.save(file, "fotos"));
		        }
		
		    usuario.setAtivo("S");  		   
			usuarioService.save(usuario);
			
			Perfis perfis = new Perfis();
			perfis.setIdUser(usuario.getId());
			perfis.setPerfis(usuario.getPerfilId());
			perfisService.save(perfis);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ModelAndView model = new ModelAndView("consulta/usuarios");
		model.addObject("msg", 0);
		return model;
	}

}
