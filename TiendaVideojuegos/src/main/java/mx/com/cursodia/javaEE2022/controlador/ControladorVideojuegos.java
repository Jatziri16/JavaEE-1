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
import mx.com.cursodia.javaEE2022.acciones.Accion;

public class ControladorVideojuegos extends HttpServlet {

	Accion accion;
	/**
	 * Diplomado Java EE 2022 1er Servlet
	 */
	private static final long serialVersionUID = 1L;

	//Capturar los do
	@SuppressWarnings("static-access")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		System.out.println("!!! Entró al controlador");
		
		//el verbo do será capturado por el conbtrolador que recibira una peticion (request) y una respuesta (response)
		RequestDispatcher despachador = null; //Elemento que atienda las peticiones
		
		//try {
			if(request.getServletPath().equals("/ControladorVideojuegos.do"))
			{
				System.out.println("--> ControladorVideojuegos.do");
				if(request.getParameter("Proveedor").equals("Todos"))
				{
					System.out.println("Muestra todos los videojuegos");
					//accion.getAccion("/MostrarVideojuegos.do");
					//response.sendRedirect(accion.getAccion("/MostrarVideojuegos.do").ejecutar(request, response));
					despachador = request.getRequestDispatcher(accion.getAccion("/MostrarVideojuegos.do").ejecutar(request, response));
					
					
				}
				else
				{
					System.out.println("Filtra por proveedor: "+request.getParameter("Proveedor"));
					//accion.getAccion("/FiltrarVideojuegosPorProveedor.do");
					//response.sendRedirect(accion.getAccion("/FiltrarVideojuegosPorProveedor.do").ejecutar(request, response));
					despachador = request.getRequestDispatcher(accion.getAccion("/FiltrarVideojuegosPorProveedor.do").ejecutar(request, response));
				}
				//Despues de que haga su trabajo a donde se va a redirijisr
				//despachador = request.getRequestDispatcher(accion.ejecutar(request, response));
				//Empaquetamos la respuesta
				despachador.forward(request, response);
				
				
				/*List<Videojuego> listaVideojuegos = Videojuego.buscarTodos();;
				if(!request.getParameter("Proveedor").equals("Todos"))
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
				despachador.forward(request, response);*/
			}
			if(request.getServletPath().equals("/MostrarVideojuegos.do"))
			{
				/*System.out.println("MostrarVideojuegos.do");
				List<Videojuego> listaVideojuegos = Videojuego.buscarTodos();
				List<Proveedor> listaProveedores = Proveedor.getListProveedores();
				
				//Asignamos un atributo a la petición para que accedan con ese nombre ""
				request.setAttribute("listaVideojuegos", listaVideojuegos);
				request.setAttribute("listaProveedores", listaProveedores);*/
				
				//Despues de que haga su trabajo a donde se va a redirijisr
				despachador = request.getRequestDispatcher(accion.getAccion("/MostrarVideojuegos.do").ejecutar(request, response));
				
				//Empaquetamos la respuesta
				despachador.forward(request, response);
			}
			else if(request.getServletPath().equals("/FormularioInsertarVideojuego.do"))
			{
				//accion.getAccion("/FormularioInsertarVideojuego.do").ejecutar(request, response);
				
				
				System.out.println("--> FormularioInsertarVideojuego.do");
				//List<Proveedor> listaProveedores = Proveedor.getProveedores();
				//request.setAttribute("listaProveedores", listaProveedores);
				despachador = request.getRequestDispatcher(accion.getAccion("/FormularioInsertarVideojuego.do").ejecutar(request, response));
				
				//Empaquetamos la respuesta
				despachador.forward(request, response);
			}
			else if(request.getServletPath().equals("/InsertarVideojuego.do"))
			{
				System.out.println("--> InsertarVideojuego.do");
				//accion = new InsertarVideojuegoAccion();
				//response.sendRedirect(accion.ejecutar(request, response));
				response.sendRedirect(accion.getAccion("/InsertarVideojuego.do").ejecutar(request, response));
				//response.sendRedirect("MostrarVideojuegos.do");
			} else if(request.getServletPath().equals("/ModificarVideojuego.do"))
			{
				System.out.println("--> ModificarVideojuego.do");
				//accion = new InsertarVideojuegoAccion();
				//response.sendRedirect(accion.ejecutar(request, response));
				response.sendRedirect(accion.getAccion("/ModificarVideojuego.do").ejecutar(request, response));
				//response.sendRedirect("MostrarVideojuegos.do");
			} else if(request.getServletPath().equals("/BorrarVideojuego.do"))
			{
				System.out.println("--> BorrarVideojuego.do");
				//accion = new InsertarVideojuegoAccion();
				//response.sendRedirect(accion.ejecutar(request, response));
				response.sendRedirect(accion.getAccion("/BorrarVideojuego.do").ejecutar(request, response));
			}
		/*} catch (DataBaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
}
