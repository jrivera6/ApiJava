package pe.edu.tecsup.apirest.repositories;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import pe.edu.tecsup.apirest.models.Captura;
import pe.edu.tecsup.apirest.models.Dato2;
import pe.edu.tecsup.apirest.models.Datos;

@Repository
public class ConsultaRepository {

	private static final Logger logger = LoggerFactory.getLogger(ConsultaRepository.class);
			
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Datos> consultar(Long id_captura){
		logger.info("call consultar()");
		
		String sql = "SELECT estado_rostro, COUNT(id) AS cantidad_rostros FROM rest_rostros WHERE id_captura = ? GROUP BY estado_rostro";
		
		 List<Datos> datos = jdbcTemplate.query(sql, new RowMapper<Datos>() {
			public Datos mapRow(ResultSet rs, int rowNum) throws SQLException{
				Datos dato = new Datos();
				dato.setEstado_rostro(rs.getString("estado_rostro"));
				dato.setCantidad_rostros(rs.getInt("cantidad_rostros"));
				return dato;
			}
		},id_captura);
		logger.info("datos: "+datos);
		return datos;
	}
	
	public List<Captura> consulta2(Long id_usuario){
		
		logger.info("call consulta2");
		
		String sql = "SELECT * FROM rest_capturas WHERE id_usuario = ? ORDER BY fecha_captura DESC";
		
		List<Captura> datos = jdbcTemplate.query(sql, new RowMapper<Captura>(){
			public Captura mapRow(ResultSet res, int rowNum) throws SQLException{
				
				Captura dato = new Captura();
				dato.setId(res.getLong("id"));
				dato.setFecha_captura(res.getDate("fecha_captura"));
				dato.setCantidad_rostros(res.getInt("cantidad_rostros"));
				dato.setNombre_captura(res.getString("nombre_captura"));
				dato.setId_usuario(res.getLong("id_usuario"));
				return dato;
			}
		},id_usuario);
		logger.info("datos: "+datos);
		return datos;
	}
	public List<Dato2> consulta3(){
		
		logger.info("call consulta3");
		
		String sql = "SELECT fecha_captura,COUNT(id) AS cantidad_capturas FROM rest_capturas GROUP BY fecha_captura";
		
		List<Dato2> datos = jdbcTemplate.query(sql, new RowMapper<Dato2>(){
			public Dato2 mapRow(ResultSet res, int rowNum) throws SQLException{
				
				Dato2 dato = new Dato2();
				
				dato.setFecha_captura(res.getDate("fecha_captura"));
				dato.setCantidad_capturas(res.getInt("cantidad_capturas"));
				return dato;
			}
		});
		logger.info("datos: "+datos);
		return datos;
	}

	
}
