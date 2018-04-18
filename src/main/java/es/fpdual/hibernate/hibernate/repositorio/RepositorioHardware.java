package es.fpdual.hibernate.hibernate.repositorio;

import org.hibernate.Session;

import es.fpdual.hibernate.hibernate.modelo.Hardware;
import es.fpdual.hibernate.hibernate.modelo.Persona;
import es.fpdual.hibernate.hibernate.util.HibernateUtil;

public class RepositorioHardware {

	public static Integer crearHardware(final Hardware hardware) {
		final Session sesion = HibernateUtil.getMiFactoria().getCurrentSession();
		
		try {
			sesion.getTransaction().begin();
			final Integer idHardware = (Integer)sesion.save(hardware);
			
			sesion.getTransaction().commit();
			
			return idHardware;
		
		}catch(Exception e) {
			System.out.println("Se ha producido un error insertando el hardware: " + e.getMessage() );
			e.printStackTrace();
			throw new RuntimeException();
		}finally {
			sesion.close();
		}
	}
	
	public static Integer modificarHardware(final Integer idHardware,final Integer precio) {
		final Session sesion = HibernateUtil.getMiFactoria().getCurrentSession();
		
		try {
			sesion.getTransaction().begin();

			final Hardware hardwareBBDD = (Hardware)sesion.createQuery("from Hardware where HARD_ID = :idHardware")
					.setParameter("idHardware", idHardware).uniqueResult();
			
			hardwareBBDD.setPrecio(precio);

			sesion.getTransaction().commit();
			return idHardware;
		
		}catch(Exception e) {
			System.out.println("Se ha producido un error actualizando el precio: " + e.getMessage() );
			e.printStackTrace();
			throw new RuntimeException();
		}finally {
			sesion.close();
		}
	}
	
	/*
	public static Integer modificarPersona(final Persona persona,final String nombre, final String dni) {
		final Session sesion = HibernateUtil.getMiFactoria().getCurrentSession();
		
		try {
			sesion.getTransaction().begin();
			final Integer idPersona = (Integer)sesion.save(persona);
			
			sesion.getTransaction().commit();
			
			return idPersona;
		
		}catch(Exception e) {
			System.out.println("Se ha producido un error insertando la persona: " + e.getMessage() );
			e.printStackTrace();
			throw new RuntimeException();
		}finally {
			sesion.close();
		}
	}
	*/

	
	public static void eliminarHardware(final Integer idHardware) {
		final Session sesion = HibernateUtil.getMiFactoria().getCurrentSession();
		
		try {
			sesion.getTransaction().begin();
			
			sesion.createQuery("delete Hardware where hard_id = :idHardware").setParameter("idHardware",idHardware).executeUpdate();
			sesion.getTransaction().commit();
			
		
		}catch(Exception e) {
			System.out.println("Se ha producido un error eliminando el hardware: " + e.getMessage() );
			e.printStackTrace();
			throw new RuntimeException();
		}finally {
			sesion.close();
		}
	}
}
