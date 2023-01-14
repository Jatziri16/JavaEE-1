package mx.com.cursodia.javaEE2022.DataBaseH;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseHelper {

	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost/gamers";
	private static final String USUARIO = "root";
	private static final String CLAVE = "";
	//public static void main(String[] args) { }
	public int insertarVideojuego(String query)
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
			System.out.println("Error al cargar el driver"+e.getMessage());
		} catch(SQLException e) {
			System.out.println("Error accediendo a la DB "+e.getMessage());
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
	
	public ResultSet executeQueryRS(String query)
	{
		Connection con = null;
		Statement stm = null;
		ResultSet rs = null; //Serie de punteros que apuntan hacia los datos, si se cierra no acceden a los datos
		
		try
		{
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL,USUARIO,CLAVE);
			stm = con.createStatement();
			rs = stm.executeQuery(query);
		} catch(ClassNotFoundException e) {
			System.out.println("Error al cargar la librería "+e.getMessage());
		} catch(SQLException e) {
			System.out.println("Error accediendo a la DB "+e.getMessage());
		} finally {
			/*try {
				//if(stm!=null) stm.close();
				//if(con!=null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}*/
		}
		return rs;
	}
}
