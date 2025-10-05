package padm.io.pad_m.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import padm.io.pad_m.service.EmailService;

@RestController
@RequestMapping("/api/email")
public class EmailRestController {
	
	@Autowired
    private EmailService emailService;	

	@GetMapping("/enviar-email")
    public String enviarEmail() {
        emailService.sendEmail("gomes.estevan1@gmail.com", "Assunto do Email", "Texto do Email");
        return "Email enviado com sucesso!";
    }

}
