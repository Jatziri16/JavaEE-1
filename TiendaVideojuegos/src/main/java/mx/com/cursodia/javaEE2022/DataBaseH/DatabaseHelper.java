package mx.com.cursodia.javaEE2022.DataBaseH;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import mx.com.cursodia.javaEE2022.Beans.Proveedor;
import mx.com.cursodia.javaEE2022.Beans.Videojuego;

public class DatabaseHelper<T> extends Videojuego{

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
	
	@SuppressWarnings({ "unchecked", "removal" })
	public List<T> selectAll(String query, Class clase) throws DataBaseException
	{
		Connection con = null;
		Statement stm = null;
		ResultSet rs = null; //Serie de punteros que apuntan hacia los datos, si se cierra no acceden a los datos
		List<T> listaObjetos = new ArrayList<T>();
		try
		{
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL,USUARIO,CLAVE);
			stm = con.createStatement();
			rs = stm.executeQuery(query);
			//System.out.println("CLASE: "+Class.forName(clase.getName()));
			while(rs.next())
			{
				T objeto = null;
				Integer x = 1;
				String stringClase = ""+Class.forName(clase.getName());
				if(stringClase.equals("class java.lang.Integer"))
				{
					//objeto = (T) x; //new Integer(0);
					x = (rs.getInt("cveprov_vid"));
					listaObjetos.add((T) x);
				} 
				else
				{
					// puede ser método, tipo, clase (cualquier cosa)
					objeto = (T) Class.forName( //Trae la ruta de la clase
							clase.getName()).getDeclaredConstructor().newInstance();
					//Obtiene el nombre, // Obtiene su constructor declarado //Obtiene una instancia
					
					//Array de métodos (tambien existen: variables, clases)
					//objeto. 			 		Toma el objeto 
					//getClass().				Obtiene la clase(donde la va a encontrar(package)) 
					//getDeclaredMethods(); 	Trae todos los métodos internos que tiene
					Method[] metodos = objeto.getClass().getDeclaredMethods();
					
					//Recorre el arreglo de métodos
					for(int i=0; i<metodos.length; i++) 
					{
						//Si el método comienza con "set"
						if(metodos[i].getName().startsWith("set"))
						{
							//Toma el método, lo invoca
								//objeto, 			 						¿De dónde?, de la clase "Libro"
								//rs.getString(metodos[i].getName().		Trae el resto de la palabra
								//substring(3)));							
							
							//Configuración del tipo en que se traerá
							if(	(metodos[i].getName().substring(3)).equals("cve_vid") || 
								(metodos[i].getName().substring(3)).equals("cveprov_vid") || 
								(metodos[i].getName().substring(3)).equals("inv_vid") ||
								(metodos[i].getName().substring(3)).equals("cve_prov"))
							{
								metodos[i].invoke(objeto, rs.getInt(metodos[i].getName().substring(3)));
							}
							else if((metodos[i].getName().substring(3)).equals("pre_vid"))
							{
								metodos[i].invoke(objeto, rs.getFloat(metodos[i].getName().substring(3)));
							}
							else
							{
								metodos[i].invoke(objeto, rs.getString(metodos[i].getName().substring(3)));
							}
						} 
						else if(objeto.getClass().getName().equals("java.lang.Integer"))
						{
							//objeto = (T)(""+rs.getInt("cveprov_vid")); //Nombre del campo del que estamos trayendo de la BD
							x = (rs.getInt("cveprov_vid"));
						}
					}
					listaObjetos.add(objeto);
				}
			}
		} catch(ClassNotFoundException e) {
			System.out.println("Error al cargar la librería "+e.getMessage());
			System.out.println("Clase no encontrada"+e.getMessage());
			throw new DataBaseException("Clase no encontrada");
		} catch(SQLException e) {
			System.out.println("Error accediendo a la DB "+e.getMessage());
			throw new DataBaseException("Error de SQL", e);
		} catch (InstantiationException | SecurityException | NoSuchMethodException | InvocationTargetException | IllegalArgumentException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(stm!=null) stm.close();
				if(con!=null) con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return listaObjetos;
	}
}
