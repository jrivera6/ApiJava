package pe.edu.tecsup.apirest.controllers;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.tecsup.apirest.models.Captura;
import pe.edu.tecsup.apirest.models.Usuario;
import pe.edu.tecsup.apirest.models.dao.CapturaDao;
import pe.edu.tecsup.apirest.models.dao.UsuarioDao;



@RestController
@RequestMapping("/api")
public class CapturaController {
	private static final Logger logger = LoggerFactory.getLogger(CapturaController.class);
	private static final String FILEPATH = "src/integrador-api/images";
	
	@Autowired
	CapturaDao capturaDao;

	@PostMapping(value="/capturas")
	@ResponseStatus(HttpStatus.CREATED)

	public Captura createUser(@Valid @ModelAttribute @RequestBody Captura captura) {
		return capturaDao.save(captura);
	}
	@GetMapping("/capturas")
	public List<Captura> getAllCapturas(){
		return capturaDao.findAll();
	}

	@GetMapping("/capturas/{id}")
	public ResponseEntity<Captura> getCapturaById(@PathVariable(value="id") Long capturaid){
			
		Captura captura = capturaDao.findOne(capturaid);
		if(captura==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(captura);
	}
	
	@PutMapping("/capturas/{id}")
	public ResponseEntity<Captura> updateCaptura(@PathVariable(value="id") Long capturaid,@Valid @RequestBody Captura capturaDetails){
		Captura captura = capturaDao.findOne(capturaid);
		if(captura==null) {
			return ResponseEntity.notFound().build();
		}
		captura.setFecha_captura(capturaDetails.getFecha_captura());
		captura.setNombre_captura(capturaDetails.getNombre_captura());
		captura.setCantidad_rostros(capturaDetails.getCantidad_rostros());
		Captura updateCaptura = capturaDao.save(captura);
		return ResponseEntity.ok().body(updateCaptura);
	}
	
	@DeleteMapping("/capturas/{id}")
	public ResponseEntity<Captura> deleteCaptura(@PathVariable(value="id") Long capturaid){
		Captura captura = capturaDao.findOne(capturaid);
		if(captura==null) {
		return ResponseEntity.notFound().build();
		}
		capturaDao.delete(captura);
		return ResponseEntity.ok().build();
}
	

	@GetMapping("/capturas/images/{filename:.+}")
	public ResponseEntity<Resource> files(@PathVariable String filename) throws Exception{
		logger.info("call images: " + filename);
		
		Resource resource = new UrlResource(Paths.get(FILEPATH).resolve(filename).toUri());
		logger.info("Resource: " + resource);
		
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\""+resource.getFilename()+"\"")
				.header(HttpHeaders.CONTENT_TYPE, Files.probeContentType(Paths.get(FILEPATH).resolve(filename)))
				.header(HttpHeaders.CONTENT_LENGTH, String.valueOf(resource.contentLength()))
				.body(resource);
	}

}
