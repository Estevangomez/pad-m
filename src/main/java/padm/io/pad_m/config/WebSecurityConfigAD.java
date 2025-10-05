package padm.io.pad_m.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import padm.io.pad_m.security.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class WebSecurityConfigAD implements WebMvcConfigurer{
	
	
	@Autowired
	CustomAuthenticatorProvider authProvider;
	
	@Bean
	public UserDetailsService userDetailsService() {		
		return new UserDetailsServiceImpl();
	}
	

	/*
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authProvider);
	} */
	  
	   @Bean
	    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
			http.authenticationProvider(authProvider);
	        http
	          .cors(cors -> cors.disable())
	          .csrf(csrf -> csrf.disable())
	          .authorizeHttpRequests(authz -> authz
	        		  .antMatchers("/login/**").permitAll()
	           		  .antMatchers("/css/**").permitAll()
	           		  .antMatchers("/webjars/**").permitAll()
	    		      .antMatchers("/images/**").permitAll()
	    		      .antMatchers("/js/**").permitAll()
	    			  .antMatchers("/fonts/**").permitAll()
	    			  .antMatchers("/api/v1/**").permitAll()
	        		  .anyRequest().authenticated()
	        		  ).formLogin(
	        				  formLogin -> formLogin
	                          .loginPage("/login")
									  .failureUrl("/login?error=true")  // Redireciona em caso de erro
	                          .permitAll()
	                    ).logout(logout -> logout.logoutSuccessUrl("/login").permitAll().logoutUrl("/logout") );
	         return http.build();
	    }
	   
/*
	   @Bean
	    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
			http.authenticationProvider(authProvider);
	        http
	          .cors(cors -> cors.disable())
	          .csrf(csrf -> csrf.disable())
	          .authorizeHttpRequests(authz -> authz
	        		  .requestMatchers("/login/**").permitAll()
	           		  .requestMatchers("/css/**").permitAll()
	           		  .requestMatchers("/webjars/**").permitAll()
	    		      .requestMatchers("/images/**").permitAll()
	    		      .requestMatchers("/js/**").permitAll()
	    			  .requestMatchers("/fonts/**").permitAll()
	    			  .requestMatchers("/api/v1/**").permitAll()
	        		  .anyRequest().fullyAuthenticated()
	        		  ).formLogin(
	        				  formLogin -> formLogin
	                          .loginPage("/login")
	                          .permitAll()
	                    ).logout(logout -> logout.logoutSuccessUrl("/").permitAll().logoutUrl("/logout") );
	         return http.build();
	    }	*/
	
	@Bean
	public PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}
	
	 

}
