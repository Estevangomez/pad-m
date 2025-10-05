package padm.io.pad_m.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import padm.io.pad_m.domain.Orgao;
import padm.io.pad_m.domain.Servidor;
import padm.io.pad_m.domain.Setor;
import padm.io.pad_m.service.OrgaoService;
import padm.io.pad_m.service.ServidorService;
import padm.io.pad_m.service.SetorService;

@Controller
@RequestMapping("/servidores")
public class ServidorController {

	DateTimeFormatter parser = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	@Autowired
	private ServidorService servidorService;

	@Autowired
	private OrgaoService orgaoService;

	@Autowired
	private SetorService setorService;

	@GetMapping
	public ModelAndView findAll() {
		ModelAndView mv = new ModelAndView("consulta/servidores");
		mv.addObject("servidores", servidorService.findAll());
		mv.addObject("activePage", "mnuServidor");
		return mv;
	}

	@GetMapping("/new")
	public String frmCadastrar(Model model, @ModelAttribute("servidor") Servidor servidor) {		
		List<Setor> setores = setorService.findAll();

		model.addAttribute("servidor", servidor);
		model.addAttribute("setores", setores);

		return "form/frmServidor";
	}

	@PostMapping("/save")
	public String saveObject(@ModelAttribute("servidor") @Valid Servidor servidor, BindingResult result, Model model, @RequestParam("admissao") String admissao,
			@RequestParam("desligamento") String desligamento, @RequestParam("expiracao") String expiracao) {
		
	
		try {				
			servidor.setDatacadastro(LocalDate.now());
			
			if(!admissao.isBlank()){
				LocalDate dtadmissao = LocalDate.parse(admissao, parser);
				servidor.setDataadmissao(dtadmissao);
			}
					
			if(!desligamento.isBlank()){
				LocalDate dtdesligamento = LocalDate.parse(desligamento, parser);
				servidor.setDatadesligamento(dtdesligamento); 
			}
			
			if(!expiracao.isBlank()){
				LocalDate dtexpiracao = LocalDate.parse(expiracao, parser);
				servidor.setDataexpiracao(dtexpiracao);
			}

			servidorService.save(servidor);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/servidores";
	}

	@GetMapping("/edit/{id}")
	public ModelAndView frmEditar(@PathVariable(name = "id") Integer id) {
		ModelAndView model = new ModelAndView("form/frmServidor");
		List<Orgao> orgaos = orgaoService.findAll();
		Servidor s = servidorService.findById(id).get();
		
		DateTimeFormatter formatters = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		
		System.out.println(s.getDataadmissao().format(formatters));
		model.addObject("servidor", s);
		//model.addObject("admissao", s.getDataadmissao().format(formatters));
		//model.addObject("desligamento", s.getDatadesligamento().format(formatters));
		//model.addObject("expiracao", s.getDataexpiracao().format(formatters));
		model.addObject("orgaos", orgaos);
		return model;
	}
}
