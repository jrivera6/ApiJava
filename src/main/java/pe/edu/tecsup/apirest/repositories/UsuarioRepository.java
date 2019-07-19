package pe.edu.tecsup.apirest.repositories;
import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.tecsup.apirest.models.Usuario;
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Serializable> {

	public abstract Usuario findById(Long id);
	
}
