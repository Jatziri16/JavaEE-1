package pruebas;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import mx.com.cursodia.javaEE2022.Beans.Videojuego;

public class HibernatePruebas {

	Session session = null;
	Transaction transaction = null;
	
	public static void main(String[] args) 
	{
		HibernatePruebas hp = new HibernatePruebas();
		//hp.nuevoVideojuego();
		hp.mostrarVideojuegos();
		//hp.seleccionarVideojuego(10);
		//hp.borrarVideojuego(15);
		//hp.mostrarVideojuegos();
		
		hp.filtrarVideojuegos(2);
	}
	
	private void nuevoVideojuego()
	{
		try
		{
			SessionFactory factoria = new Configuration().configure().buildSessionFactory();
			session = factoria.openSession();
			transaction = session.beginTransaction();
			
			Videojuego v = new Videojuego(15, "Splatoon 2", 1850.5f, 1, 200);
			session.persist(v); //session.saveOrUpdate(v);
			transaction.commit();
		}
		catch(HibernateException e)
		{
			System.out.println(e.getMessage());
			transaction.rollback();
		}
		finally
		{
			session.close();
		}
	}
	
	private void mostrarVideojuegos()
	{
		try
		{
			SessionFactory factoria = new Configuration().configure().buildSessionFactory();
			session = factoria.openSession();
			Query query = session.createQuery("from Videojuego videojuegos"); //session.createQuery("from videojuegos Videojuego");
			List<Videojuego> lista = query.list();
			for(Videojuego v: lista)
			{
				System.out.print(v.getCve_vid()+"\t\t"+v.getTit_vid()+"\t\t"+v.getPre_vid()+"\t\t"+v.getCveprov_vid()+"\t\t"+v.getInv_vid()+"\n");
			}
		}
		catch(HibernateException e)
		{
			System.out.println(e.getMessage());
		}
		finally
		{
			session.close();
		}
	}
	
	private void seleccionarVideojuego(int id)
	{
		try
		{
			SessionFactory factoria = new Configuration().configure().buildSessionFactory();
			session = factoria.openSession();
			Videojuego v = (Videojuego) session.get(Videojuego.class, id);
			System.out.print(v.getCve_vid()+"\t\t"+v.getTit_vid()+"\t\t"+v.getPre_vid()+"\t\t"+v.getCveprov_vid()+"\t\t"+v.getInv_vid()+"\n");
		}
		catch(HibernateException e)
		{
			System.out.println(e.getMessage());
		}
		finally
		{
			session.close();
		}
	}
	
	private void borrarVideojuego(int id)
	{
		try
		{
			SessionFactory factoria = new Configuration().configure().buildSessionFactory();
			session = factoria.openSession();
			transaction = session.beginTransaction();
			Videojuego v = (Videojuego) session.get(Videojuego.class, id);
			session.remove(v); //delete(v);
			transaction.commit();
		}
		catch(HibernateException e)
		{
			System.out.println(e.getMessage());
			transaction.rollback();
		}
		finally
		{
			session.close();
		}
	}
	
	private void filtrarVideojuegos(int cveProv)
	{
		try
		{
			SessionFactory factoria = new Configuration().configure().buildSessionFactory();
			session = factoria.openSession();
			Query query = session.createQuery("from Videojuego videojuegos WHERE videojuegos.cveprov_vid = "+cveProv);
			List<Videojuego> lista = query.list();
			for(Videojuego v: lista)
			{
				System.out.print(v.getCve_vid()+"\t\t"+v.getTit_vid()+"\t\t"+v.getPre_vid()+"\t\t"+v.getCveprov_vid()+"\t\t"+v.getInv_vid()+"\n");
			}
		}
		catch(HibernateException e)
		{
			System.out.println(e.getMessage());
		}
		finally
		{
			session.close();
		}
	}
}
