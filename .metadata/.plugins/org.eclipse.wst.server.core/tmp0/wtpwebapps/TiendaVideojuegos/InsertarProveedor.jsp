<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- Imports -->
<%@ page import="mx.com.cursodia.javaEE2022.Beans.Proveedor"%>
<%
	//1
	//int cve = Integer.parseInt(request.getParameter("clave"));
	String nombre = request.getParameter("nombre");
	String email = request.getParameter("email");
	String tel = request.getParameter("telefono");
	
	//cve, 
	Proveedor.insertar(nombre,email, tel);
	response.sendRedirect("MostrarVideojuegos.jsp");
 %>