package mx.com.cursodia.javaEE2022.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import mx.com.cursodia.javaEE2022.Beans.Videojuego;
import mx.com.cursodia.javaEE2022.DataBaseH.DataBaseException;
import mx.com.cursodia.javaEE2022.DataBaseH.HibernateHelper;

public class VideojuegoDAOJPAImpl extends GenericDAOJPAImpl<Videojuego, Integer> implements VideojuegoDAO 
{

	@Override
	public List<Videojuego> filtrarPorProv(int cveprov) {
		// TODO Auto-generated method stub
		return null;
	}

	//int cve, 
	/*public void insertar(String titulo, float precio, int cveprov, int inventario) throws DataBaseException
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JavaEE2022");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = null;
		tx = em.getTransaction();
		tx.begin();
		
		// Agregar Try/Catch
		em.persist(new Videojuego(titulo, precio, cveprov, inventario));
		tx.commit();
		em.close();
	}
	
	public List<Videojuego> buscarTodos() //throws DataBaseException
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JavaEE2022");
		EntityManager em = emf.createEntityManager();
		TypedQuery<Videojuego> query = em.createQuery("SELECT V FROM Videojuego V", Videojuego.class);
		List<Videojuego> lista = null;
		try {
			lista = query.getResultList();
		} catch(PersistenceException e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return lista;
	}
	public Videojuego getVideojuego(int cve)
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JavaEE2022");
		EntityManager em = emf.createEntityManager();
		TypedQuery<Videojuego> query = em.createQuery("SELECT V FROM Videojuego V JOIN FETCH V.proveedor WHERE V.cve_vid = :cve", Videojuego.class);
		query.setParameter(1, cve);
		Videojuego videojuego = query.getSingleResult();
		em.close();
		return videojuego;
	}
	
	public List<Videojuego> filtrarVideojuegosProv(int cveprov) //throws DataBaseException
	{
		SessionFactory factoriaS = HibernateHelper.getSessionFactory();
		Session session = factoriaS.openSession();
		return session.createQuery("from Videojuego videojuegos WHERE videojuegos.cveprov_vid = "+cveprov).list();
	}
	
	public void actualizarVideojuego(int cve, String titulo, float precio, int cveprov, int inventario)
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JavaEE2022");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = null;
		tx = em.getTransaction();
		tx.begin();
		
		// Agregar Try/Catch
		em.merge(new Videojuego(cve, titulo, precio, cveprov, inventario));
		System.out.println("Se guardaron los cambios!!!");
		tx.commit();
		em.close();
	}
	
	public boolean borrarVideojuego(int cve)
	{
		boolean resp = false;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JavaEE2022");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = null;
		tx = em.getTransaction();
		tx.begin();
		try {
			em.remove(em.merge(getVideojuego(cve)));
			resp = true;
			tx.commit();
		} catch (PersistenceException e) {
			// TODO Auto-generated catch block
			em.getTransaction().rollback();
			e.printStackTrace();
		}
		em.close();
		return resp;
	}*/
}
