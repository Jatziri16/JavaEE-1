package pruebas;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import mx.com.cursodia.javaEE2022.Beans.Videojuego;

public class JPAPruebas {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JavaEE2022");
		EntityManager em = emf.createEntityManager();
		TypedQuery<Videojuego> query = em.createQuery("SELECT V FROM Videojuego V", Videojuego.class);
		List<Videojuego> lista = query.getResultList();
		for(Videojuego v: lista)
		{
			System.out.println(v.getTit_vid());
		}
	}

}
