package padm.io.pad_m.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/monitor")
public class MonitorController {

	@GetMapping
	public ModelAndView findAll() {
		ModelAndView mv = new ModelAndView("monitor/monitor");		
		return mv;
	}

}
