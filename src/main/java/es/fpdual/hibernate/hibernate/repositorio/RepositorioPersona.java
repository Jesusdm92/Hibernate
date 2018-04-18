package es.fpdual.hibernate.hibernate.repositorio;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import es.fpdual.hibernate.hibernate.modelo.Persona;
import es.fpdual.hibernate.hibernate.util.HibernateUtil;

public class RepositorioPersona {

	public static Integer crearPersona(final Persona persona) {
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
	
	public static Integer modificarPersona(final Integer idPersona,final String apellidos) {
		final Session sesion = HibernateUtil.getMiFactoria().getCurrentSession();
		
		try {
			sesion.getTransaction().begin();
			
			//sesion.createQuery("update..").setParameter().executeUpdate();
			final Persona personaBBDD = (Persona)sesion.createQuery("from Persona where PER_ID = :idPersona")
					.setParameter("idPersona", idPersona).uniqueResult();
			
			personaBBDD.setApellidos(apellidos);
			// sesion.saveOrUpdate(persona);
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

	
	public static void eliminarPersona(final Integer idPersona) {
		final Session sesion = HibernateUtil.getMiFactoria().getCurrentSession();
		
		try {
			sesion.getTransaction().begin();
			
			sesion.createQuery("delete Persona where per_id = :idPersona").setParameter("idPersona",idPersona).executeUpdate();
			sesion.getTransaction().commit();
			
		
		}catch(Exception e) {
			System.out.println("Se ha producido un error insertando la persona: " + e.getMessage() );
			e.printStackTrace();
			throw new RuntimeException();
		}finally {
			sesion.close();
		}
	}
	
	public static List<Persona> consultar(String nombre){
	final Session sesion = HibernateUtil.getMiFactoria().getCurrentSession();
		
		try {
			sesion.getTransaction().begin();
			
			final  org.hibernate.query.Query<Persona> consulta = sesion.createQuery("from Persona where PER_NOM like :nombre").setParameter("nombre",nombre);
			return consulta.list();		
		
		}catch(Exception e) {
			System.out.println("Se ha producido un error en la consulta: " + e.getMessage() );
			e.printStackTrace();
			throw new RuntimeException();
		}finally {
			sesion.close();
		}
	}
	
	
}
