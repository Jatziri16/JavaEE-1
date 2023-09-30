package mx.com.cursodia.javaEE2022.acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.com.cursodia.javaEE2022.Beans.Videojuego;
import mx.com.cursodia.javaEE2022.DataBaseH.DataBaseException;

public class ModificarVideojuegoAccion extends Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("--> ModificarVideojuegoAccion");
		
		System.out.println("cve = "+request.getParameter("clave"));
		System.out.println("titulo = "+request.getParameter("titulo"));
		System.out.println("precio = "+request.getParameter("precio"));
		System.out.println("cveprov = "+request.getParameter("cveprov"));
		System.out.println("inventario = "+request.getParameter("inventario"));
		
		int cve = Integer.parseInt(request.getParameter("clave"));
		String titulo = request.getParameter("titulo");
		float precio = Float.parseFloat(request.getParameter("precio"));
		int cveprov = Integer.parseInt(request.getParameter("cveprov"));
		int inventario = Integer.parseInt(request.getParameter("inventario"));
		
		Videojuego.actualizarVideojuego(cve, titulo, precio, cveprov, inventario);
		return "MostrarVideojuegos.do";
	}
}