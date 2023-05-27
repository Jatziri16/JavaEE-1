package mx.com.cursodia.javaEE2022.Beans;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Persistence;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.query.Query;

import mx.com.cursodia.javaEE2022.DataBaseH.DataBaseException;
import mx.com.cursodia.javaEE2022.DataBaseH.DatabaseHelper;
import mx.com.cursodia.javaEE2022.DataBaseH.HibernateHelper;

@Entity
@Table(name="proveedores")
public class Proveedor {
	@Id
	@PrimaryKeyJoinColumn(name = "cve_prov")
	private Integer cve_prov;
	public int hashCode()
	{
		return cve_prov.hashCode();
	}
	String nom_prov;
	@Fetch(value = FetchMode.SELECT) //Como se van a ir leyendo cada uno de los registros
	@OneToMany
	@JoinColumn(name="cve_prov")
	private List<Videojuego> listaVideojuegos;
	String email_prov;
	String tel_prov;
	
	
	public Proveedor(int cve_prov, String nom_prov, String email_prov, String tel_prov) {
		super();
		this.cve_prov = cve_prov;
		this.nom_prov = nom_prov;
		this.email_prov = email_prov;
		this.tel_prov = tel_prov;
	}
	public Proveedor(String nom_prov, String email_prov, String tel_prov) {
		super();
		this.nom_prov = nom_prov;
		this.email_prov = email_prov;
		this.tel_prov = tel_prov;
	}
	public Proveedor() {}
	
	public int getCve_prov() {
		return cve_prov;
	}
	public void setcve_prov(int cve_prov) {
		this.cve_prov = cve_prov;
	}
	public String getNom_prov() {
		return nom_prov;
	}
	public void setnom_prov(String nom_prov) {
		this.nom_prov = nom_prov;
	}
	public String getEmail_prov() {
		return email_prov;
	}
	public void setemail_prov(String email_prov) {
		this.email_prov = email_prov;
	}
	public String getTel_prov() {
		return tel_prov;
	}
	public void settel_prov(String tel_prov) {
		this.tel_prov = tel_prov;
	}
	
	
	
	
	
	@SuppressWarnings("unchecked")
	public static List<Proveedor> getProveedores() throws DataBaseException//throws SQLException
	{
		/*String query = "SELECT * FROM proveedores";
		DatabaseHelper dbh = new DatabaseHelper();
		//return dbh.executeQueryProv(query);
		return dbh.selectAll(query, Proveedor.class);*/
		
		/*SessionFactory factoriaS = HibernateHelper.getSessionFactory();
		Session session = factoriaS.openSession();
		Query consulta = session.createQuery("from Proveedor proveedores");
		List<Proveedor> lista =  consulta.list();
		session.close();
		return lista;*/
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JavaEE2022");
		EntityManager em = emf.createEntityManager();
		TypedQuery<Proveedor> query = em.createQuery("SELECT P FROM Proveedor P", Proveedor.class);
		List<Proveedor> lista = query.getResultList();
		return lista;
	}
	public static Proveedor getProveedor(int cve) throws DataBaseException//throws SQLException
	{
		/*String query = "SELECT * FROM proveedores WHERE cve_prov="+cve;
		DatabaseHelper dbh = new DatabaseHelper();
		List<Proveedor> lista =  dbh.executeQueryProv(query);
		return lista.get(0);*/
		
		SessionFactory factoriaS = HibernateHelper.getSessionFactory();
		Session session = factoriaS.openSession();
		return (Proveedor) session.get(Proveedor.class, cve);
	}
	
	public static void insertar(String nombre, String email, String tel)
	{
		/*String query = "INSERT INTO proveedores (nom_prov, email_prov, tel_prov) VALUES ";
		query += "('"+nombre+"','"+email+"','"+tel+"')";
		DatabaseHelper dbh = new DatabaseHelper();
		dbh.insertarVideojuego(query);*/
		
		/*SessionFactory factoriaS = HibernateHelper.getSessionFactory();
		Session session = factoriaS.openSession();
		Transaction transaction = session.beginTransaction();
		Proveedor p = new Proveedor(nombre, email, tel);
		session.persist(p); //session.saveOrUpdate(v);
		transaction.commit();*/
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JavaEE2022");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = null;
		tx = em.getTransaction();
		tx.begin();
		em.persist(new Proveedor(nombre, email, tel));
		tx.commit();
		em.close();
	}
}
