package pe.edu.tecsup.apirest.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="rest_usuarios")
@EntityListeners(AuditingEntityListener.class)
public class Usuario implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull(message="Este campo no puede ser nulo")
	@NotEmpty(message="Este campo no puede ser vacio")
	private String nombres;
	@NotNull(message="Este campo no puede ser nulo")
	@NotEmpty(message="Este campo no puede ser vacio")
	private String apellidos;		
	@NotNull(message="Este campo no puede ser nulo")
	@NotEmpty(message="Este campo no puede ser vacio")
	@Column(unique=true)
	@NotEmpty(message="Este campo no puede ser vacio")
	private String username;
	@NotNull(message="Este campo no puede ser nulo")
	@NotEmpty(message="Este campo no puede ser vacio")
	private	 String password;
	@NotNull(message="Este campo no puede ser nulo")
	@Column(unique=true)
	@NotEmpty(message="Este campo no puede ser vacio")
	@Email
	private String email;	
	@OneToMany(mappedBy="id_usuario",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private List<Captura> capturas;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public List<Captura> getCapturas() {
		return capturas;
	}
	public void setCapturas(List<Captura> capturas) {
		this.capturas = capturas;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombres=" + nombres + ", apellidos=" + apellidos + ", username=" + username
				+ ", password=" + password + ", email=" + email + ", capturas=" + capturas + "]";
	}


	
}
