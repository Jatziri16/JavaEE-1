<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
	<%@ page import="mx.com.cursodia.javaEE2022.Beans.Videojuego"%>
	<%
		int cve = Integer.parseInt(request.getParameter("clave"));
		String titulo = request.getParameter("titulo");
		float precio = Float.parseFloat(request.getParameter("precio"));
		int cveprov = Integer.parseInt(request.getParameter("cveprov"));
		int inventario = Integer.parseInt(request.getParameter("inventario"));
		
		Videojuego.actualizarVideojuego(cve, titulo, precio, cveprov, inventario);
		response.sendRedirect("MostrarVideojuegos.jsp");
	 %>
<!-- 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>
 -->