package pe.edu.tecsup.apirest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import pe.edu.tecsup.apirest.models.Captura;
import pe.edu.tecsup.apirest.models.Dato2;
import pe.edu.tecsup.apirest.models.Datos;
import pe.edu.tecsup.apirest.models.dao.ConsultaDao;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@RestController
@RequestMapping("/api")
public class ConsultaController {

	private static final Logger logger = LoggerFactory.getLogger(ConsultaController.class);

	@Autowired
	private ConsultaDao consultaDao;
	@GetMapping("/datos/{id_captura}")
	public ResponseEntity<?> datos(@PathVariable Long id_captura) throws Exception {
		logger.info("call datos");
		
		List<Datos> dato = consultaDao.consultar(id_captura);
		
		return ResponseEntity.ok().body(dato);
	}
	
	@GetMapping("/usuarios/{id_usuario}/capturas")
	public ResponseEntity<?> datos2(@PathVariable Long id_usuario) throws Exception {
		logger.info("call datos");
		
		List<Captura> dato = consultaDao.consulta2(id_usuario);
		
		return ResponseEntity.ok().body(dato);
	}
	
	@GetMapping("/grafica/capturas")
	public ResponseEntity<?> datos3() throws Exception {
		logger.info("call datos");
		
		List<Dato2> dato = consultaDao.consulta3();
		
		return ResponseEntity.ok().body(dato);
	}
}
