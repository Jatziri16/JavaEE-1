package mx.com.cursodia.javaEE2022.controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.com.cursodia.javaEE2022.Beans.Proveedor;
import mx.com.cursodia.javaEE2022.Beans.Videojuego;
import mx.com.cursodia.javaEE2022.DataBaseH.DataBaseException;

public class ControladorVideojuegos extends HttpServlet {

	/**
	 * Diplomado Java EE 2022 1er Servlet
	 */
	private static final long serialVersionUID = 1L;

	//Capturar los do
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		System.out.println("!!! Entró al controlador");
		
		//el verbo do será capturado por el conbtrolador que recibira una peticion (request) y una respuesta (response)
		RequestDispatcher despachador = null; //Elemento que atienda las peticiones
		
		try {
			if(request.getServletPath().equals("/ControladorVideojuegos.do"))
			{
				List<Videojuego> listaVideojuegos = Videojuego.buscarTodos();;
				if(!request.getParameter("Proveedor").equals("Seleccionar"))
				{
					int prov = Integer.parseInt(request.getParameter("Proveedor"));
					listaVideojuegos = Videojuego.filtrarVideojuegosProv(prov);
				}
				List<Proveedor> listaProveedores = Proveedor.getProveedores();
				
				//Asignamos un atributo a la petición para que accedan con ese nombre ""
				request.setAttribute("listaVideojuegos", listaVideojuegos);
				request.setAttribute("listaProveedores", listaProveedores);
				
				//Despues de que haga su trabajo a donde se va a redirijisr
				despachador = request.getRequestDispatcher("MostrarVideojuegos.jsp");
				
				//Empaquetamos la respuesta
				despachador.forward(request, response);
			}
			if(request.getServletPath().equals("/MostrarVideojuegos.do"))
			{
				System.out.println("MostrarVideojuegos.do");
				List<Videojuego> listaVideojuegos = Videojuego.buscarTodos();
				List<Proveedor> listaProveedores = Proveedor.getProveedores();
				
				//Asignamos un atributo a la petición para que accedan con ese nombre ""
				request.setAttribute("listaVideojuegos", listaVideojuegos);
				request.setAttribute("listaProveedores", listaProveedores);
				
				//Despues de que haga su trabajo a donde se va a redirijisr
				despachador = request.getRequestDispatcher("MostrarVideojuegos.jsp");
				
				//Empaquetamos la respuesta
				despachador.forward(request, response);
			}
			else if(request.getServletPath().equals("/FormularioInsertarVideojuego.do"))
			{
				System.out.println("FormularioInsertarVideojuego.do");
				List<Proveedor> listaProveedores = Proveedor.getProveedores();
				request.setAttribute("listaProveedores", listaProveedores);
				despachador = request.getRequestDispatcher("FormularioInsertarVideojuego.jsp");
				
				//Empaquetamos la respuesta
				despachador.forward(request, response);
			}
			else if(request.getServletPath().equals("/InsertarVideojuego.do"))
			{
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
				
				Videojuego.insertar(titulo, precio, cveprov, inventario);
				response.sendRedirect("MostrarVideojuegos.do");
			}
		} catch (DataBaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
