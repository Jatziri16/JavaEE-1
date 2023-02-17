package mx.com.cursodia.javaEE2022.DataBaseH;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import mx.com.cursodia.javaEE2022.Beans.Proveedor;
import mx.com.cursodia.javaEE2022.Beans.Videojuego;

public class DatabaseHelper {

	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost/gamers";
	private static final String USUARIO = "root";
	private static final String CLAVE = "";
	//public static void main(String[] args) { }
	public int insertarVideojuego(String query) throws DataBaseException
	{
		Connection con = null;
		Statement stm = null;
		int filas = 0;
		
		try
		{
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL,USUARIO,CLAVE);
			stm = con.createStatement();
			
			filas = stm.executeUpdate(query);
		} catch(ClassNotFoundException e) {
			//System.out.println("Error al cargar el driver"+e.getMessage());
			System.out.println("Clase no encontrada"+e.getMessage());
			throw new DataBaseException("Clase no encontrada");
		} catch(SQLException e) {
			System.out.println("Error accediendo a la DB "+e.getMessage());
			throw new DataBaseException("Error de SQL", e);
		} finally {
			
				try {
					if(stm!=null) stm.close();
					if(con!=null) con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
		return filas;
	}
	
	public List<Videojuego> executeQueryRS(String query) throws DataBaseException
	{
		Connection con = null;
		Statement stm = null;
		ResultSet rs = null; //Serie de punteros que apuntan hacia los datos, si se cierra no acceden a los datos
		List<Videojuego> lista = new ArrayList<Videojuego>();
		try
		{
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL,USUARIO,CLAVE);
			stm = con.createStatement();
			rs = stm.executeQuery(query);
			while(rs.next())
			{
				lista.add(new Videojuego(rs.getInt("cve_vid"), rs.getString("tit_vid"), rs.getFloat("pre_vid"), 
						rs.getInt("cveprov_vid"), rs.getInt("inv_vid")));
			}
		} catch(ClassNotFoundException e) {
			System.out.println("Error al cargar la librería "+e.getMessage());
			System.out.println("Clase no encontrada"+e.getMessage());
			throw new DataBaseException("Clase no encontrada");
		} catch(SQLException e) {
			System.out.println("Error accediendo a la DB "+e.getMessage());
			throw new DataBaseException("Error de SQL", e);
		} finally {
			
				try {
					if(stm!=null) stm.close();
					if(con!=null) con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
		return lista;
	}
	
	public List<Proveedor> executeQueryProv(String query) throws DataBaseException
	{
		Connection con = null;
		Statement stm = null;
		ResultSet rs = null; //Serie de punteros que apuntan hacia los datos, si se cierra no acceden a los datos
		List<Proveedor> lista = new ArrayList<Proveedor>();
		try
		{
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL,USUARIO,CLAVE);
			stm = con.createStatement();
			rs = stm.executeQuery(query);
			while(rs.next())
			{
				lista.add(new Proveedor(rs.getInt("cve_prov"), rs.getString("nom_prov"), rs.getString("email_prov"), 
						rs.getString("tel_prov")));
			}
		} catch(ClassNotFoundException e) {
			System.out.println("Error al cargar la librería "+e.getMessage());
			throw new DataBaseException("Clase no encontrada");
		} catch(SQLException e) {
			System.out.println("Error accediendo a la DB "+e.getMessage());
			throw new DataBaseException("Error de SQL", e);
		} finally {
			try {
				if(stm!=null) stm.close();
				if(con!=null) con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return lista;
	}
}
