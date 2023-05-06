package mx.com.cursodia.javaEE2022.acciones;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.com.cursodia.javaEE2022.Beans.Proveedor;
import mx.com.cursodia.javaEE2022.Beans.Videojuego;
import mx.com.cursodia.javaEE2022.DataBaseH.DataBaseException;

public class FiltrarVideojuegosPorProveedorAccion extends Accion{

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Proveedor a filtrar");
		List<Videojuego> listaVideojuegos = null;
		List<Proveedor> listaProveedores = null;
		try 
		{
			listaVideojuegos = Videojuego.buscarTodos();
			if(!request.getParameter("Proveedor").equals("Todos"))
			{
				int prov = Integer.parseInt(request.getParameter("Proveedor"));
				System.out.println("Proveedor a filtrar === "+prov);
				listaVideojuegos = Videojuego.filtrarVideojuegosProv(prov);
			}
			listaProveedores = Proveedor.getProveedores();
		} catch (DataBaseException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		
		//Asignamos un atributo a la petición para que accedan con ese nombre ""
		request.setAttribute("listaVideojuegos", listaVideojuegos);
		request.setAttribute("listaProveedores", listaProveedores);
		
		return "MostrarVideojuegos.do";
	}

}
