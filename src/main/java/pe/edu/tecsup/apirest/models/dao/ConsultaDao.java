package pe.edu.tecsup.apirest.models.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.tecsup.apirest.models.Captura;
import pe.edu.tecsup.apirest.models.Dato2;
import pe.edu.tecsup.apirest.models.Datos;
import pe.edu.tecsup.apirest.repositories.ConsultaRepository;

@Service
public class ConsultaDao {

	@Autowired
	private ConsultaRepository consultaRepository;
	
	public List<Datos> consultar(Long id_captura) throws Exception{
		return consultaRepository.consultar(id_captura);
	}
	
	public List<Captura> consulta2(Long id_usuario) throws Exception{
		return consultaRepository.consulta2(id_usuario);
	}

	public List<Dato2> consulta3() throws Exception{
		return consultaRepository.consulta3();
	}
}