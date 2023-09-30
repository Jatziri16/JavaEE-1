package mx.com.cursodia.javaEE2022.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import mx.com.cursodia.javaEE2022.Beans.Proveedor;
import mx.com.cursodia.javaEE2022.DataBaseH.DataBaseException;
import mx.com.cursodia.javaEE2022.DataBaseH.HibernateHelper;

public interface ProveedorDAO {

	/*public abstract static List<Proveedor> getProveedores(); //throws SQLException
	public abstract static Proveedor getProveedor(int cve); //throws SQLException
	public abstract static void insertar(String nombre, String email, String tel);*/
}
