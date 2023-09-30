package mx.com.cursodia.javaEE2022.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import mx.com.cursodia.javaEE2022.Beans.Videojuego;

public abstract class GenericDAOJPAImpl<T, Id extends Serializable> implements GenericDAO<T, Id> 
{
	private Class<T> claseDePersistencia;
	@SuppressWarnings("unchecked")
	public GenericDAOJPAImpl()
	{
		this.claseDePersistencia = (Class<T>)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	@Override
	public T seleccionar (Id id)
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JavaEE2022");
		EntityManager em = emf.createEntityManager();
		
		T objeto = null;
		try
		{
			objeto = (T) em.find(claseDePersistencia, id);
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally 
		{
			em.close();
		}
		
		return objeto;
	}
	
	@Override
	public List<T> buscarTodos()
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JavaEE2022");
		EntityManager em = emf.createEntityManager();
		List<T> listaDeObjetos = null;
		try {
			TypedQuery<T> consulta = em.createQuery("SELECT o FROM "+claseDePersistencia.getSimpleName()+" o", claseDePersistencia);
			listaDeObjetos = consulta.getResultList();
		} catch(PersistenceException e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return listaDeObjetos;
	}
	
	@Override
	public void borrar(T objeto)
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JavaEE2022");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			em.remove(em.merge(objeto));
			tx.commit();
		} catch (PersistenceException e) {
			// TODO Auto-generated catch block
			tx.rollback();
			e.printStackTrace();
		}
		em.close();
	}
	
	@Override
	public void insertar(T objeto) 
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JavaEE2022");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = null;
		try
		{
			tx = em.getTransaction();
			tx.begin();
			em.persist(objeto);
			tx.commit();
		} catch(PersistenceException e)
		{
			tx.rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}
	}
	
	@Override
	public void guardarCambios(T objeto) 
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JavaEE2022");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = null;
		
		try
		{
			tx = em.getTransaction();
			tx.begin();
			em.persist(objeto);
			System.out.println("SE GUARDARON LOS CAMBIOS");
			tx.commit();
		} catch(PersistenceException e)
		{
			tx.rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}
	}
}
