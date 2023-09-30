package mx.com.cursodia.javaEE2022.Beans;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import mx.com.cursodia.javaEE2022.DataBaseH.DataBaseException;
import mx.com.cursodia.javaEE2022.DataBaseH.DatabaseHelper;
import mx.com.cursodia.javaEE2022.DataBaseH.HibernateHelper;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.Table;
import javax.persistence.TypedQuery;

//@ anotaciones!! formas en las que nos comunicamos con el framework
//Equivalente a una tabla en una base de datos - ENTIDADES
@Entity
@Table(name="videojuegos") //
public class Videojuego {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cve_vid")
	private Integer cve_vid;
	private String tit_vid;
	private float pre_vid;
	
	@ManyToOne // Muchos a uno - relacion que tiene
	@JoinColumn(name="cveprov_vid", referencedColumnName="cve_prov", insertable=false, updatable=false, nullable=false) //no se puede insertar ni actualizar desde aqui la tabla proveedor
	private Proveedor proveedor;
	private Proveedor getProveedor()
	{
		return proveedor;
	}
	public void setProveedor(Proveedor proveedor)
	{
		this.proveedor = proveedor;
	}
	private int cveprov_vid;
	private int inv_vid;
	
	
	public Videojuego() {}
	public Videojuego(Integer cve_vid, String tit_vid, float pre_vid, int cveprov_vid, int inv_vid) 
	{
		this.cve_vid = cve_vid;
		this.tit_vid = tit_vid;
		this.pre_vid = pre_vid;
		this.cveprov_vid = cveprov_vid;
		this.inv_vid = inv_vid;
	}
	public Videojuego(String tit_vid, float pre_vid, int cveprov_vid, int inv_vid) 
	{
		this.tit_vid = tit_vid;
		this.pre_vid = pre_vid;
		this.cveprov_vid = cveprov_vid;
		this.inv_vid = inv_vid;
	}
	
	public Integer getCve_vid() {
		return cve_vid;
	}
	public void setcve_vid(int cve_vid) {
		this.cve_vid = cve_vid;
	}
	public String getTit_vid() {
		return tit_vid;
	}
	public void settit_vid(String tit_vid) {
		this.tit_vid = tit_vid;
	}
	public float getPre_vid() {
		return pre_vid;
	}
	public void setpre_vid(float pre_vid) {
		this.pre_vid = pre_vid;
	}
	public int getCveprov_vid() {
		return cveprov_vid;
	}
	public void setcveprov_vid(int cveprov_vid) {
		this.cveprov_vid = cveprov_vid;
	}
	public int getInv_vid() {
		return inv_vid;
	}
	public void setinv_vid(int inv_vid) {
		this.inv_vid = inv_vid;
	}
	
	@Override
	public String toString() {
		return "Videojuego [cve_vid=" + cve_vid + ", tit_vid=" + tit_vid + ", pre_vid=" + pre_vid + ", cveprov_vid="
				+ cveprov_vid + ", inv_vid=" + inv_vid + "]";
	}
	//int cve, 
	public static void insertar(String titulo, float precio, int cveprov, int inventario) throws DataBaseException
	{
		//cve_vid, 
		//"+cve+",
		/*String query = "INSERT INTO videojuegos (tit_vid, pre_vid, cveprov_vid, inv_vid) VALUES ";
		query += "('"+titulo+"',"+precio+","+cveprov+","+inventario+")";
		DatabaseHelper dbh = new DatabaseHelper();
		dbh.insertarVideojuego(query);*/
		
		SessionFactory factoriaS = HibernateHelper.getSessionFactory();
		Session session = factoriaS.openSession();
		Transaction transaction = session.beginTransaction();
		Videojuego v = new Videojuego(titulo, precio, cveprov, inventario);
		session.persist(v); //session.saveOrUpdate(v);
		transaction.commit();
		
		/*EntityManagerFactory emf = Persistence.createEntityManagerFactory("JavaEE2022");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = null;
		tx = em.getTransaction();
		tx.begin();
		
		// Agregar Try/Catch
		em.persist(new Videojuego(titulo, precio, cveprov, inventario));
		tx.commit();
		em.close();*/
	}
	
	public static List<Videojuego> buscarTodos() throws DataBaseException
	{
		/*String query = "SELECT * FROM videojuegos";
		DatabaseHelper dbh = new DatabaseHelper();
		return dbh.executeQueryRS(query);*/
		
		/*System.out.println("Buscar Todos -- nuevo");
		String query = "SELECT * FROM videojuegos";
		DatabaseHelper dbh = new DatabaseHelper();
		return dbh.selectAll(query, Videojuego.class);*/
		
		SessionFactory factoriaS = HibernateHelper.getSessionFactory();
		Session session = factoriaS.openSession();
		Query consulta = session.createQuery("from Videojuego videojuegos");
		List<Videojuego> lista =  consulta.list();
		//List<Videojuego> lista = session.createQuery("from Videojuego videojuegos").list();
		session.close();
		
		/*EntityManagerFactory emf = Persistence.createEntityManagerFactory("JavaEE2022");
		EntityManager em = emf.createEntityManager();
		TypedQuery<Videojuego> query = em.createQuery("SELECT V FROM Videojuego V", Videojuego.class);
		List<Videojuego> lista = null;
		try {
			lista = query.getResultList();
		} catch(PersistenceException e) {
			e.printStackTrace();
		} finally {
			em.close();
		}*/
		return lista;
	}
	public static Videojuego getVideojuego(int cve)
	{
		/*String query = "SELECT * FROM videojuegos WHERE cve_vid="+cve;
		DatabaseHelper dbh = new DatabaseHelper();
		List<Videojuego> lista = dbh.executeQueryRS(query);
		return lista.get(0); //AGREGAR excepcion*/
		
		SessionFactory factoriaS = HibernateHelper.getSessionFactory();
		Session session = factoriaS.openSession();
		return (Videojuego) session.get(Videojuego.class, cve);
		
		/*EntityManagerFactory emf = Persistence.createEntityManagerFactory("JavaEE2022");
		EntityManager em = emf.createEntityManager();
		TypedQuery<Videojuego> query = em.createQuery("SELECT V FROM Videojuego V JOIN FETCH V.proveedor WHERE V.cve_vid = :cve", Videojuego.class);
		query.setParameter(1, cve);
		Videojuego videojuego = query.getSingleResult();
		em.close();
		return videojuego;*/
	}
	
	public static List<Videojuego> filtrarVideojuegosProv(int cveprov) throws DataBaseException
	{
		/*String query = "SELECT * FROM videojuegos WHERE cveprov_vid="+cveprov;
		DatabaseHelper dbh = new DatabaseHelper();
		return dbh.executeQueryRS(query);*/
		SessionFactory factoriaS = HibernateHelper.getSessionFactory();
		Session session = factoriaS.openSession();
		return session.createQuery("from Videojuego videojuegos WHERE videojuegos.cveprov_vid = "+cveprov).list();
	}
	
	public static void actualizarVideojuego(int cve, String titulo, float precio, int cveprov, int inventario)
	{
		/*String query = "UPDATE videojuegos "
				+ "SET tit_vid='"+titulo+"', pre_vid="+precio+", cveprov_vid="+cveprov+", inv_vid="+inventario+" "
				+ "WHERE cve_vid = "+cve;
		DatabaseHelper dbh = new DatabaseHelper();
		int n = dbh.insertarVideojuego(query);
		return n;*/
		
		SessionFactory factoriaS = HibernateHelper.getSessionFactory();
		Session session = factoriaS.openSession();
		Transaction transaction = session.beginTransaction();
		Videojuego v = new Videojuego(cve, titulo, precio, cveprov, inventario);
		session.saveOrUpdate(v); //session.saveOrUpdate(v);
		transaction.commit();
		
		/*EntityManagerFactory emf = Persistence.createEntityManagerFactory("JavaEE2022");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = null;
		tx = em.getTransaction();
		tx.begin();
		
		// Agregar Try/Catch
		em.merge(new Videojuego(cve, titulo, precio, cveprov, inventario));
		System.out.println("Se guardaron los cambios!!!");
		tx.commit();
		em.close();*/
	}
	
	public static boolean borrarVideojuego(int cve)
	{
		boolean resp = false;
		SessionFactory factoriaS = HibernateHelper.getSessionFactory();
		Session session = factoriaS.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			Videojuego v = (Videojuego) session.get(Videojuego.class, cve);
			session.remove(v);
			transaction.commit();
			resp = true;
		} catch(HibernateException e) {
			System.out.println(e.getMessage());
			transaction.rollback();
		} finally {
			session.close();
		}
		return resp;
		
		/*boolean resp = false;
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
		return resp;*/
	}
}
