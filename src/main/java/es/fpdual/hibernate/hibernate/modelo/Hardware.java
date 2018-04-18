package es.fpdual.hibernate.hibernate.modelo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="A_HARD")
public class Hardware {
	@Id
	@GeneratedValue
	@Column(name="HARD_ID")
	private int idHardware;
	
	@Column(name="HARD_NOM",nullable=false, length=50)
	private String nombre;
	
	@Column(name = "HARD_PRE", nullable = false) 
	private Integer precio;
	
	@Column(name = "PER_CBAR", nullable = false, length = 13, unique=true) 
	private String codigoBarras;
	
	@Column(name = "PER_FFAB", nullable = false) 
	private Date fechaFabricacion;
	
	@Column(name = "PER_ECV", nullable = false)
	@Enumerated
	private TipoHardware tipoHardware;
	
	public Hardware() {
		
	}

	public int getIdHardware() {
		return idHardware;
	}

	public void setIdHardware(int idHardware) {
		this.idHardware = idHardware;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getPrecio() {
		return precio;
	}

	public void setPrecio(Integer precio) {
		this.precio = precio;
	}

	public String getCodigoBarras() {
		return codigoBarras;
	}

	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	public Date getFechaFabricacion() {
		return fechaFabricacion;
	}

	public void setFechaFabricacion(Date fechaFabricacion) {
		this.fechaFabricacion = fechaFabricacion;
	}

	public TipoHardware getTipoHardware() {
		return tipoHardware;
	}

	public void setTipoHardware(TipoHardware tipoHardware) {
		this.tipoHardware = tipoHardware;
	}

	
}
