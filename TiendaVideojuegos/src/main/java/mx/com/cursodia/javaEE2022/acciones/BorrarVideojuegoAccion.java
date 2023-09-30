package mx.com.cursodia.javaEE2022.acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.com.cursodia.javaEE2022.Beans.Videojuego;
import mx.com.cursodia.javaEE2022.dao.VideojuegoDAOJPAImpl;

public class BorrarVideojuegoAccion extends Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int cve = Integer.parseInt(request.getParameter("CVE"));
		
		if(Videojuego.borrarVideojuego(cve))
		{
			System.out.println("Videojuego Borrado con Éxito!");
		}
		else {
			System.out.println("OH NO! Ocurrió un error al tratar de eliminar el videojuegi:(");
		}
		
		/*VideojuegoDAOJPAImpl vidDAO = new VideojuegoDAOJPAImpl();
		vidDAO.borrar(vidDAO.seleccionar(cve));*/
		
		return "MostrarVideojuegos.do";
	}
}
