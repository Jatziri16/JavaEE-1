package mx.com.cursodia.javaEE2022.acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mx.com.cursodia.javaEE2022.Beans.Videojuego;
import mx.com.cursodia.javaEE2022.DataBaseH.DataBaseException;

public class InsertarVideojuegoAccion extends Accion 
{
	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("InsertarVideojuego.do");
		//int cve = Integer.parseInt(request.getParameter("clave"));
		System.out.println("titulo = "+request.getParameter("titulo"));
		System.out.println("precio = "+request.getParameter("precio"));
		System.out.println("cveprov = "+request.getParameter("cveprov"));
		System.out.println("inventario = "+request.getParameter("inventario"));
		
		String titulo = request.getParameter("titulo");
		float precio = Float.parseFloat(request.getParameter("precio"));
		int cveprov = Integer.parseInt(request.getParameter("cveprov"));
		int inventario = Integer.parseInt(request.getParameter("inventario"));
		
		try
		{
			Videojuego.insertar(titulo, precio, cveprov, inventario);
		} catch (DataBaseException e) {
			e.printStackTrace();
		}
		//response.sendRedirect("MostrarVideojuegos.do");
		return "MostrarVideojuegos.do";
	}

}
