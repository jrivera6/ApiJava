package pe.edu.tecsup.apirest.models;

import java.io.Serializable;
import java.util.Date;

public class Dato2 implements Serializable{

	private Date fecha_captura;
	
	private Integer cantidad_capturas;

	public Date getFecha_captura() {
		return fecha_captura;
	}

	public void setFecha_captura(Date fecha_captura) {
		this.fecha_captura = fecha_captura;
	}

	public Integer getCantidad_capturas() {
		return cantidad_capturas;
	}

	public void setCantidad_capturas(Integer cantidad_capturas) {
		this.cantidad_capturas = cantidad_capturas;
	}

	@Override
	public String toString() {
		return "Dato2 [fecha_captura=" + fecha_captura + ", cantidad_capturas=" + cantidad_capturas + "]";
	}
	
	
}
