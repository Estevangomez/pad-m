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

import padm.io.pad_m.domain.Minuta;
import padm.io.pad_m.service.MinutaService;

@Controller
@RequestMapping("/minuta")
public class MinutaController {

	DateTimeFormatter parser = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	@Autowired
	private MinutaService minutaService;

	@GetMapping
	public ModelAndView findAll() {
		ModelAndView mv = new ModelAndView("consulta/minutas");
		mv.addObject("localidades", minutaService.findAll());
		return mv;
	}

	@GetMapping("/new")
	public String frmCadastrar(Model model, @ModelAttribute("minuta") Minuta minuta) {
		model.addAttribute("minuta", minuta);
		return "form/frmMinuta";
	}

	@PostMapping("/save")
	public String saveObject(@ModelAttribute("minuta") Minuta minuta, BindingResult result) {
		try {
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/minutas";
	}

	@GetMapping("/edit/{id}")
	public ModelAndView frmEditar(@PathVariable(name = "id") Integer id) {
		ModelAndView model = new ModelAndView("form/frmMinuta");
		return model;
	}
}
