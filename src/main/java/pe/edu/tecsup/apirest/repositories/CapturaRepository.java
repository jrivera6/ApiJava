package pe.edu.tecsup.apirest.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.tecsup.apirest.models.Captura;
import pe.edu.tecsup.apirest.models.Usuario;
@Repository

public interface CapturaRepository extends JpaRepository<Captura, Serializable>{

	public abstract Captura findById(Long id);
	
}
		