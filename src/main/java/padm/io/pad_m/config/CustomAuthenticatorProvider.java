package padm.io.pad_m.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import padm.io.pad_m.security.UserDetailsServiceImpl;
import padm.io.pad_m.service.ADService;

@Component
public class CustomAuthenticatorProvider implements AuthenticationProvider {
	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	
	@Autowired
	ADService adService;
	
	@Autowired
	Environment env;
	
	@Override
    public Authentication authenticate(Authentication authentication) 
      throws AuthenticationException {
      
        String username = authentication.getName(); //("000000000000" + authentication.getName()).substring(authentication.getName().length());
        String password = authentication.getCredentials().toString();
      
        // ACRESCENTANDO MANUALMENTE A ROLE USER
        //List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        //authorities.add(new SimpleGrantedAuthority("USER")); 
        
        if (this.loginAD(username, password)) {        	
        	UserDetails userDetail = userDetailsService.loadUserByUsername(username);        	
        	//userDetail.getAuthorities().stream().map(x -> Perfil.toEnum(x)).collect(Collectors.t());
            //for (userDetail.getAuthorities())
        	return new UsernamePasswordAuthenticationToken(userDetail, password, userDetail.getAuthorities());
        } else {
        	throw new
        	    BadCredentialsException("Usuário e senha inválidos");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
    
    private boolean loginAD(String username, String password) {
		boolean ret = false;
		if (Arrays.asList(env.getActiveProfiles()).contains("homo"))
		    ret = adService.loginActiveDirectory(username, password);
		else
		  ret = true;
    	return ret;
	}
    
	
}
