package padm.io.pad_m.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import padm.io.pad_m.domain.Usuario;

@Component
public class AuthenticationFacade implements IAuthenticationFacade {
	
	@Value("${spring.profiles.active}")
	String profile;
	
	@Override
    public Authentication getAuthentication() {		
        return SecurityContextHolder.getContext().getAuthentication();
    }

	@Override
	public Usuario getUsuario() {		
		UserDetailsImpl userDetails = (UserDetailsImpl)this.getAuthentication().getPrincipal();
		Usuario user = userDetails.getUsuario();
		return user;
	}
	
	@Override
	public boolean isProducao() {
		return (profile.contains("prod"));
	}
	
}
