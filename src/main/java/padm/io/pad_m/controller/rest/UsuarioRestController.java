package padm.io.pad_m.controller.rest;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import padm.io.pad_m.domain.Usuario;
import padm.io.pad_m.domain.dto.ResultDTO;
import padm.io.pad_m.security.UserDetailsImpl;
import padm.io.pad_m.service.UsuarioService;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioRestController {
    private final ResourceLoader resourceLoader;
    
	@Autowired
	UsuarioService usuarioService;
	
	@Value("${path.upload}")
	String upload;	
	
	public UsuarioRestController(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }
	 
	  @GetMapping("/load")
	    public ResponseEntity<byte[]> getFileAsBytes() {
	        try {
	        	
	            // Path to the directory where files are located
	            Path filePath = Paths.get(upload, "lobo.jpg");

	            // Read file as bytes
	            byte[] fileBytes = Files.readAllBytes(filePath);

	            // Set the content type and headers
	            HttpHeaders headers = new HttpHeaders();
	            headers.set(HttpHeaders.CONTENT_TYPE, "application/octet-stream");
	            headers.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" +"lobo.jpg");

	            // Return the file bytes and HTTP status
	            return new ResponseEntity<>(fileBytes, headers, HttpStatus.OK);
	        } catch (IOException e) {
	            // Handle the exception (e.g., file not found)
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }
	    
	@GetMapping
	public ResponseEntity<List<Usuario>> findAll() {
		return ResponseEntity.ok(usuarioService.findAll());
	}
	
	@GetMapping("/setor/{idSetor}")
	public ResponseEntity<List<Usuario>> findAllBySetor(@PathVariable("idSetor") Integer idSetor) {		
		return ResponseEntity.ok(usuarioService.findAllBySetor(idSetor).get());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Usuario> findById(@PathVariable("id") Integer id) {		
		Usuario usuario = usuarioService.findById(id).get();
		return ResponseEntity.ok(usuario);
	}
	/*
	@GetMapping("/download")
	public ResponseEntity<Resource> download(String param) throws IOException {
	    // Assume I already have this byte array from db or something
	    byte[] array = getItFromDB();

	    ByteArrayResource resource = new ByteArrayResource(array);
	    return ResponseEntity.ok()
	            .contentType(MediaType.APPLICATION_OCTET_STREAM)
	            .contentLength(resource.contentLength())
	            .header(HttpHeaders.CONTENT_DISPOSITION,
	                    ContentDisposition.attachment()
	                        .filename("whatever")
	                        .build().toString())
	            .body(resource);
	}
	*/
	//@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
		Optional<Usuario> user = usuarioService.findById(id);			
		File fileToDelete = new File(upload+"\\"+user.get().getImage());
	      fileToDelete.delete();
	    
		usuarioService.delete(user.get());
		return ResponseEntity.noContent().build();
	}
	
	
	@GetMapping("/{id}/{ativo}")
	public ResultDTO ativar(@PathVariable(name = "id") Integer id, @PathVariable(name = "ativo") String ativo,
			@AuthenticationPrincipal UserDetailsImpl loggedUser) {
		ResultDTO result = new ResultDTO();

		try {
			Usuario u = new Usuario();
			u =  usuarioService.findById(id).get();
			u.setAtivo(ativo);
			usuarioService.save(u);

			result.setMsg("Processamento realizado", "success", 1);

		} catch (Exception e) {
			result.setMsg("Erro", "danger", 0);
			e.printStackTrace();
		}
		return result;
	}
	



}
