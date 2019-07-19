package pe.edu.tecsup.apirest.models.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.tecsup.apirest.models.Rostro;
import pe.edu.tecsup.apirest.repositories.RostroRepository;

@Service
public class RostroDao {
	@Autowired
	RostroRepository rostroRepository;
	
	public Rostro save(Rostro rostro) {
		return rostroRepository.save(rostro);
	}
	public List<Rostro> findAll(){
		return rostroRepository.findAll();
	}
	
	public Rostro findOne(Long rostroid) {
		return rostroRepository.findById(rostroid);
	}
	
	public void delete(Rostro rostro) {
		rostroRepository.delete(rostro);
	}
}
