package padm.io.pad_m.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// Configura o Spring Boot para expor a pasta 'uploads' no caminho '/uploads/**'
		registry.addResourceHandler("/uploads/**")
				.addResourceLocations("file:uploads/");
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("error/403").setViewName("403");
		registry.addViewController("error/404").setViewName("404");
		registry.addViewController("error/400").setViewName("400");
	}
	
	
	@Override
	  public void addCorsMappings(CorsRegistry registry) {
	    registry.addMapping("/api/**").allowedOrigins("*");
	  }

}
