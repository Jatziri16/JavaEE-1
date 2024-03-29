package mx.com.cursodia.javaEE2022.Beans;

import java.util.List;

import mx.com.cursodia.javaEE2022.DataBaseH.DataBaseException;
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
		String query = "INSERT INTO videojuegos (tit_vid, pre_vid, cveprov_vid, inv_vid) VALUES ";
		query += "('"+titulo+"',"+precio+","+cveprov+","+inventario+")";
		DatabaseHelper dbh = new DatabaseHelper();
		dbh.insertarVideojuego(query);
	}
	
	@SuppressWarnings("unchecked")
	public static List<Videojuego> buscarTodos() throws DataBaseException
	{
		/*String query = "SELECT * FROM videojuegos";
		DatabaseHelper dbh = new DatabaseHelper();
		return dbh.executeQueryRS(query);*/
		System.out.println("Buscar Todos -- nuevo");
		String query = "SELECT * FROM videojuegos";
		DatabaseHelper dbh = new DatabaseHelper();
		return dbh.selectAll(query, Videojuego.class);
	}
	public static Videojuego getVideojuego(int cve) throws DataBaseException
	{
		String query = "SELECT * FROM videojuegos WHERE cve_vid="+cve;
		DatabaseHelper dbh = new DatabaseHelper();
		List<Videojuego> lista = dbh.executeQueryRS(query);
		return lista.get(0); //AGREGAR excepcion
	}
	
	public static List<Videojuego> filtrarVideojuegosProv(int cveprov) throws DataBaseException
	{
		String query = "SELECT * FROM videojuegos WHERE cveprov_vid="+cveprov;
		DatabaseHelper dbh = new DatabaseHelper();
		return dbh.executeQueryRS(query);
	}
	
	public static int actualizarVideojuego(int cve, String titulo, float precio, int cveprov, int inventario) throws DataBaseException
	{
		String query = "UPDATE videojuegos "
				+ "SET tit_vid='"+titulo+"', pre_vid="+precio+", cveprov_vid="+cveprov+", inv_vid="+inventario+" "
				+ "WHERE cve_vid = "+cve;
		DatabaseHelper dbh = new DatabaseHelper();
		int n = dbh.insertarVideojuego(query);
		return n;
	}
}
