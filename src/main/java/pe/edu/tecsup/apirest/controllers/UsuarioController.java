package pe.edu.tecsup.apirest.controllers;
import java.util.List;

import javax.validation.Valid;

import org.aspectj.apache.bcel.classfile.Code;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.tecsup.apirest.models.Usuario;
import pe.edu.tecsup.apirest.models.dao.UsuarioDao;

@RestController
@RequestMapping("/api")
public class UsuarioController {
	@Autowired
	UsuarioDao usuarioDao;
//	headers="content-type=application/x-www-form-urlencoded"
	@PostMapping(value="/usuarios")
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario createUser(@ModelAttribute @Valid @RequestBody Usuario user) {
		return usuarioDao.save(user);
	}
	@PostMapping(value="/web/usuarios", headers="content-type=application/json")
	public Usuario createUserWeb(@RequestBody @Valid Usuario user) {
		return usuarioDao.save(user);
	}
	@GetMapping("/usuarios")
	public List<Usuario> getAllUsers(){
		return usuarioDao.findAll();
	}
	
	@GetMapping("/usuarios/{id_usuario}")
	public ResponseEntity<Usuario> getUsuarioByIdUsuario(@PathVariable(value="id_usuario") Long userid){
			
		Usuario user = usuarioDao.findOne(userid);
		if(user==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(user);
	}
	
	@PutMapping("/usuarios/{id_usuario}")
	public ResponseEntity<Usuario> updateUser(@PathVariable(value="id_usuario") Long userid,@Valid @RequestBody Usuario userDetails){
		Usuario user = usuarioDao.findOne(userid);
		if(user==null) {
			return ResponseEntity.notFound().build();
		}
		user.setNombres(userDetails.getNombres());;
		user.setApellidos(userDetails.getApellidos());
		user.setUsername(userDetails.getUsername());
		user.setPassword(userDetails.getPassword());
		user.setEmail(userDetails.getEmail());
		Usuario updateUser = usuarioDao.save(user);
		return ResponseEntity.ok().body(updateUser);
	}
	
	@DeleteMapping("/usuarios/{id_usuario}")
	public ResponseEntity<Usuario> deleteUser(@PathVariable(value="id_usuario") Long userid){
		Usuario user = usuarioDao.findOne(userid);
		if(user==null) {
		return ResponseEntity.notFound().build();
		}
		usuarioDao.delete(user);
		return ResponseEntity.ok().build();
}
}
