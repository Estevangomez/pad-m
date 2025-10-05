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

import padm.io.pad_m.domain.Setor;
import padm.io.pad_m.service.SetorService;

@Controller
@RequestMapping("/setor")
public class SetorController {

	DateTimeFormatter parser = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	@Autowired
	private SetorService setorService;

	@GetMapping
	public ModelAndView findAll() {
		ModelAndView mv = new ModelAndView("consulta/setores");
		mv.addObject("setores", setorService.findAll());
		return mv;
	}

	@GetMapping("/new")
	public String frmCadastrar(Model model, @ModelAttribute("setor") Setor setor) {
		model.addAttribute("setor", setor);
		return "form/frmSetor";
	}

	@PostMapping("/save")
	public String saveObject(@ModelAttribute("setor") Setor setor, BindingResult result) {
		try {
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/setores";
	}

	@GetMapping("/edit/{id}")
	public ModelAndView frmEditar(@PathVariable(name = "id") Integer id) {
		ModelAndView model = new ModelAndView("form/frmSetor");
		return model;
	}
}
