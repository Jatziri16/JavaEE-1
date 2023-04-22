package mx.com.cursodia.javaEE2022.acciones;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.com.cursodia.javaEE2022.Beans.Proveedor;
import mx.com.cursodia.javaEE2022.Beans.Videojuego;
import mx.com.cursodia.javaEE2022.DataBaseH.DataBaseException;

public class MostrarVideojuegosAccion extends Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("MostrarVideojuegos.do");
		List<Videojuego> listaVideojuegos = null;
		List<Proveedor> listaProveedores = null;
		try {
			listaVideojuegos = Videojuego.buscarTodos();
			listaProveedores = Proveedor.getProveedores();
		} catch (DataBaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Asignamos un atributo a la petición para que accedan con ese nombre ""
		request.setAttribute("listaVideojuegos", listaVideojuegos);
		request.setAttribute("listaProveedores", listaProveedores);
		
		return "MostrarVideojuegos.jsp";
	}

}
