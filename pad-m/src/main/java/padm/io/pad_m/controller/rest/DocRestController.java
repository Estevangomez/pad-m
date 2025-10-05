package padm.io.pad_m.controller.rest;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import padm.io.pad_m.domain.Assinador;
import padm.io.pad_m.domain.Doc;
import padm.io.pad_m.domain.dto.ResultDTO;
import padm.io.pad_m.service.AssinadorService;
import padm.io.pad_m.service.DocService;
import padm.io.pad_m.service.ProcessoDocsService;

@RestController
@RequestMapping("/api/docs")
public class DocRestController {
	private final Path root = Paths.get("./uploads");
	private String pdfDir = "documentos";

	@Autowired
	private DocService docService;
	
	@Autowired
	private ProcessoDocsService processoDocService;
	
	@Autowired
	private AssinadorService assinadorService;
	
	
	@DeleteMapping("/delete/{id}/processo/{idProcesso}")
	public ResultDTO delete(@PathVariable("id") Integer id, @PathVariable("idProcesso") Integer idProcesso) {
		ResultDTO result = new ResultDTO();
		try {
			  Doc doc = docService.findById(id);	  
		      List<Assinador> assinador = assinadorService.findAllByDocumentoID(id);
		      for(Assinador a : assinador ){
		    	  assinadorService.delete(a);
		    	  processoDocService.delete( processoDocService.findByIdDoc(id, idProcesso).get());
		      }		
		     
		      docService.deleteById(id);
			  File fileToDelete = new File(root.resolve(pdfDir) + "/" + doc.getHashdoc());
		      fileToDelete.delete(); 
		      result.setRet(1);
		      result.setMensagem("Documento Deletado");
		} catch (Exception e) {
			e.printStackTrace();
			  result.setRet(0);
		      result.setMensagem("Erro ao  Deletar Documento");
		}
		 
		return result;
	}

}
