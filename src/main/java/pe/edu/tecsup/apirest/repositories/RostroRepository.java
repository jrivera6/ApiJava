package pe.edu.tecsup.apirest.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.tecsup.apirest.models.Rostro;

@Repository

public interface RostroRepository extends JpaRepository<Rostro, Serializable>{

	public abstract Rostro findById(Long id);
}
