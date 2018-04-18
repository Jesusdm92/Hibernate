package es.fpdual.hibernate.hibernate.pruebas;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import es.fpdual.hibernate.hibernate.modelo.EstadoCivil;
import es.fpdual.hibernate.hibernate.modelo.Hardware;
import es.fpdual.hibernate.hibernate.modelo.Persona;
import es.fpdual.hibernate.hibernate.modelo.TipoHardware;
import es.fpdual.hibernate.hibernate.repositorio.RepositorioHardware;
import es.fpdual.hibernate.hibernate.repositorio.RepositorioPersona;

public class Pruebas {

	public static void main(String[] args) {
		System.out.println(crearPersona());
		System.out.println(crearHardware());
		System.out.println(modificarPersona());
		System.out.println(modificarHardware());
		eliminarHardware();
		consultarPersona();

	}

	private static Integer crearPersona() {

		final Persona persona = new Persona();
		persona.setNombre("Jesus");
		persona.setApellidos("Delgado");
		persona.setDni("15455638Y");
		persona.setEdad(25);
		persona.setEstadoCivil(EstadoCivil.SOLTERO);

		return RepositorioPersona.crearPersona(persona);
	}

	private static Integer crearHardware() {

		final Hardware hardware = new Hardware();
		hardware.setNombre("Raton");
		hardware.setPrecio(2);
		hardware.setCodigoBarras("1234567891233");
		hardware.setFechaFabricacion(new Date());
		hardware.setTipoHardware(TipoHardware.ENTRADA);
		return RepositorioHardware.crearHardware(hardware);
	}
	
	private static Integer modificarPersona() {
		return RepositorioPersona.modificarPersona(1, "Delgado Marín");
	}

	private static Integer modificarHardware() {
		return RepositorioHardware.modificarHardware(2,30);
	}
	
	private static void eliminarHardware() {
		RepositorioHardware.eliminarHardware(2);
	}
	
	private static void consultarPersona() {
		final List<Persona> personas = RepositorioPersona.consultar("%j%");
		System.out.println(personas.size());
		
	}
}
