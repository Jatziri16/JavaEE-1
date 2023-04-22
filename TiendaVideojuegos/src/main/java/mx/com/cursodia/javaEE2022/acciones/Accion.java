package mx.com.cursodia.javaEE2022.acciones;

import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class Accion 
{
	public abstract String ejecutar(HttpServletRequest request, HttpServletResponse response);
	
	public static Accion getAccion(String tipo)
	{
		Accion accion = null;
		tipo = tipo.substring(1, tipo.length());
		tipo = tipo.substring(0, tipo.length()-3);
		
		String text = Accion.class.getPackage()+"."+tipo+"Accion";
		text = text.substring(8, text.length());
		System.out.println(text);
		
		try {
			Class c = Class.forName(text);
			accion = (Accion)c.getDeclaredConstructor().newInstance();
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		/*if(tipo.equals("/MostrarVideojuegos.do"))
		{
			accion = new MostrarVideojuegosAccion();
		} else if(tipo.equals("/FormularioInsertarVideojuego.do"))
		{
			accion = new FormularioInsertarVideojuegoAccion();
		} else if(tipo.equals("/InsertarVideojuego.do"))
		{
			accion = new InsertarVideojuegoAccion();
		} else if(tipo.equals("/BorrarVideojuego.do"))
		{
			accion = new BorrarVideojuegoAccion();
		} else if(tipo.equals("/FiltrarVideojuegosPorProveedor.do"))
		{
			System.out.println("Crea accion FiltrarVideojuegosPorProveedor");
			accion = new FiltrarVideojuegosPorProveedorAccion();
		} else if(tipo.equals("/FormularioEditarVideojuego.do"))
		{
			accion = new FormularioEditarVideojuegoAccion();
		} else if(tipo.equals("/ModificarVideojuego.do"))
		{
			accion = new ModificarVideojuegoAccion();
		}*/
		return accion;
	}
}
