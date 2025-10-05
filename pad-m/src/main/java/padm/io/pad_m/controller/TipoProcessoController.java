package padm.io.pad_m.controller;

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
import padm.io.pad_m.domain.TipoProcesso;
import padm.io.pad_m.service.TipoProcessoService;

@Controller
@RequestMapping("/tiposProcesso")
public class TipoProcessoController {

    @Autowired
    private TipoProcessoService tipoProcessoService;

    @GetMapping
    public ModelAndView findAll() {
        ModelAndView mv = new ModelAndView("consulta/tiposProcesso");
        mv.addObject("tiposProcesso", tipoProcessoService.findAll());
        return mv;
    }

    @GetMapping("/new")
    public String frmCadastrar(Model model) {
        model.addAttribute("tipoProcesso", new TipoProcesso());
        return "form/frmTipoProcesso";
    }

    @PostMapping("/save")
    public String saveObject(@ModelAttribute("tipoProcesso") TipoProcesso tipoProcesso, BindingResult result) {
        if (result.hasErrors()) {
            return "form/frmTipoProcesso";
        }
        tipoProcessoService.save(tipoProcesso);
        return "redirect:/tiposProcesso";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView frmEditar(@PathVariable("id") Integer id) {
        ModelAndView mv = new ModelAndView("form/frmTipoProcesso");
        mv.addObject("tipoProcesso", tipoProcessoService.findById(id));
        return mv;
    }
}
