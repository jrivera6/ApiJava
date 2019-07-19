package pe.edu.tecsup.apirest.models.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.tecsup.apirest.models.Usuario;
import pe.edu.tecsup.apirest.repositories.UsuarioRepository;
@Service
public class UsuarioDao {
	@Autowired
	UsuarioRepository usuarioRepository;
	
	public Usuario save(Usuario user) {
		return usuarioRepository.save(user);
	}
	public List<Usuario> findAll(){
		return usuarioRepository.findAll();
	}
	
	public Usuario findOne(Long userid) {
		return usuarioRepository.findById(userid);
	}
	
	public void delete(Usuario user) {
		usuarioRepository.delete(user);
	}
}
