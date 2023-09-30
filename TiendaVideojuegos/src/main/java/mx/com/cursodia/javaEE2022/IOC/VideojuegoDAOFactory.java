package mx.com.cursodia.javaEE2022.IOC;

import mx.com.cursodia.javaEE2022.dao.VideojuegoDAO;
import mx.com.cursodia.javaEE2022.dao.VideojuegoDAOJPAImpl;

public class VideojuegoDAOFactory 
{
	public static VideojuegoDAO getInstance()
	{
		String type = "JPA";
		if(type.equals("Hibernate"))
		{
			//return VideojuegoDAOHibernateImpl();
		}
		else if(type.equals("JPA"))
		{
			return new VideojuegoDAOJPAImpl();
		}
		else if(type.equals("JDBC"))
		{
			// return new VideojuegoDAOJDBCImpl();
		}
		else
		{
			System.out.println("Error al seleccionar el tipo de persistencia");
		}
		return null;
	}
}
/* Se necesita algo que englobe las 2 clases que me puede retornar*/