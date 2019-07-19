package pe.edu.tecsup.apirest.models.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.tecsup.apirest.models.Captura;
import pe.edu.tecsup.apirest.models.Usuario;
import pe.edu.tecsup.apirest.repositories.CapturaRepository;
import pe.edu.tecsup.apirest.repositories.UsuarioRepository;

@Service
public class CapturaDao {
	@Autowired
	CapturaRepository capturaRepository;
	@Autowired
	UsuarioRepository usuarioRepository;
	public Captura save(Captura captura) {
		return capturaRepository.save(captura);
	}
	public List<Captura> findAll(){
		return capturaRepository.findAll();
	}
	
	public Captura findOne(Long capturaid) {
		return capturaRepository.findById(capturaid);
	}
	
	public void delete(Captura captura) {
		capturaRepository.delete(captura);
	}
	

}
