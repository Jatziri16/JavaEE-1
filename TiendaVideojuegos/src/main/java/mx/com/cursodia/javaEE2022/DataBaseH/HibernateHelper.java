package mx.com.cursodia.javaEE2022.DataBaseH;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateHelper 
{
	private static final SessionFactory sessionFactory = buildSessionFactory();
	
	private static SessionFactory buildSessionFactory()
	{
		try 
		{
			return new Configuration().configure().buildSessionFactory();
		} catch (Throwable e) 
		{
			System.err.print("Error al crear el factory de sesion: "+e);
			throw new ExceptionInInitializerError(e);
		}
	}
	
	//Patron factory
	public static SessionFactory getSessionFactory()
	{
		return sessionFactory; 
	}
}
