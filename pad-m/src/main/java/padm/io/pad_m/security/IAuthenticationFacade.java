package padm.io.pad_m.security;

import org.springframework.security.core.Authentication;

import padm.io.pad_m.domain.Usuario;

public interface IAuthenticationFacade {
	Authentication getAuthentication();
	
	Usuario getUsuario();
	
	boolean isProducao();
}
