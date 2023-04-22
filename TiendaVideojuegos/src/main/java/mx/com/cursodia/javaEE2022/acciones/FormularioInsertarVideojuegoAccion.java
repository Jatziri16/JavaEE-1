package mx.com.cursodia.javaEE2022.acciones;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.com.cursodia.javaEE2022.Beans.Proveedor;
import mx.com.cursodia.javaEE2022.DataBaseH.DataBaseException;

public class FormularioInsertarVideojuegoAccion extends Accion{

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {

		
		System.out.println("FormularioInsertarVideojuego.do");
		List<Proveedor> listaProveedores = null;
		try {
			listaProveedores = Proveedor.getProveedores();
		} catch (DataBaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("listaProveedores", listaProveedores);
		
		return "FormularioInsertarVideojuego.jsp";
	}

}
