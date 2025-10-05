package padm.io.pad_m.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import padm.io.pad_m.domain.Usuario;

@Service
public class ADService {
    
	@Autowired
	private UsuarioService usuarioService;

	public boolean loginActiveDirectory(String username, String password) {
    	//return true;    
	
		try {
			if (!password.equals("")) {				
				Optional<Usuario> user = usuarioService.findByCpf(username);  
				if(user.isEmpty()) {
					return false;
				}else {
					if(user.get().getSenha().equals(password)) {
						return true;
					}else {
						return false;
					}
				}				
				
			} else
				return false;
		} catch (Exception e) {
			return false;
		}
	}

}
