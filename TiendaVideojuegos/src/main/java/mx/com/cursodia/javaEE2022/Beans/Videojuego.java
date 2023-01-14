package mx.com.cursodia.javaEE2022.Beans;

import java.sql.ResultSet;
import java.sql.SQLException;

import mx.com.cursodia.javaEE2022.DataBaseH.DatabaseHelper;

public class Videojuego {
	private int cve_vid;
	private String tit_vid;
	private float pre_vid;
	private int cveprov_vid;
	private int inv_vid;
	
	
	public Videojuego() {}
	public Videojuego(int cve_vid, String tit_vid, float pre_vid, int cveprov_vid, int inv_vid) 
	{
		this.cve_vid = cve_vid;
		this.tit_vid = tit_vid;
		this.pre_vid = pre_vid;
		this.cveprov_vid = cveprov_vid;
		this.inv_vid = inv_vid;
	}
	
	public int getCve_vid() {
		return cve_vid;
	}
	/*public void setCve_vid(int cve_vid) {
		this.cve_vid = cve_vid;
	}*/
	public String getTit_vid() {
		return tit_vid;
	}
	public void setTit_vid(String tit_vid) {
		this.tit_vid = tit_vid;
	}
	public float getPre_vid() {
		return pre_vid;
	}
	public void setPre_vid(float pre_vid) {
		this.pre_vid = pre_vid;
	}
	public int getCveprov_vid() {
		return cveprov_vid;
	}
	public void setCveprov_vid(int cveprov_vid) {
		this.cveprov_vid = cveprov_vid;
	}
	public int getInv_vid() {
		return inv_vid;
	}
	public void setInv_vid(int inv_vid) {
		this.inv_vid = inv_vid;
	}

	public static ResultSet buscarTodosLosProveedores() //throws SQLException
	{
		String query = "SELECT cve_prov, nom_prov FROM proveedores";
		DatabaseHelper dbh = new DatabaseHelper();
		return dbh.executeQueryRS(query);
	}
	
	//int cve, 
	public static void insertar(String titulo, float precio, int cveprov, int inventario)
	{
		//cve_vid, 
		//"+cve+",
		String query = "INSERT INTO videojuegos (tit_vid, pre_vid, cveprov_vid, inv_vid) VALUES ";
		query += "('"+titulo+"',"+precio+","+cveprov+","+inventario+")";
		DatabaseHelper dbh = new DatabaseHelper();
		dbh.insertarVideojuego(query);
	}
	
	public static ResultSet buscarTodos()
	{
		String query = "SELECT * FROM videojuegos";
		DatabaseHelper dbh = new DatabaseHelper();
		return dbh.executeQueryRS(query);
	}
}
