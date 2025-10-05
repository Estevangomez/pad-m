package padm.io.pad_m.controller;

import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import padm.io.pad_m.domain.Localidade;
import padm.io.pad_m.service.LocalidadeService;

@Controller
@RequestMapping("/localidade")
public class LocalidadeController {

	DateTimeFormatter parser = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	@Autowired
	private LocalidadeService localidadeService;

	@GetMapping
	public ModelAndView findAll() {
		ModelAndView mv = new ModelAndView("consulta/localidades");
		mv.addObject("localidades", localidadeService.findAll());
		return mv;
	}

	@GetMapping("/new")
	public String frmCadastrar(Model model, @ModelAttribute("localidade") Localidade localidade) {
		model.addAttribute("localidae", localidade);
		return "form/frmLocalidade";
	}

	@PostMapping("/save")
	public String saveObject(@ModelAttribute("localidade") Localidade localidade, BindingResult result) {
		try {
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/localidades";
	}

	@GetMapping("/edit/{id}")
	public ModelAndView frmEditar(@PathVariable(name = "id") Integer id) {
		ModelAndView model = new ModelAndView("form/frmLocalidade");
		return model;
	}
}
