<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel=stylesheet href="css/mostrarVideojuegos.css" type="text/css">
		<script type="text/javascript" src="js/validaciones.js"></script>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
		<title>Filtrar Videojuegos</title>
	</head>
	<body style='background-color: rgba(50, 50, 50, 0.3);'>
	<!-- Imports -->
		<%@ page import="mx.com.cursodia.javaEE2022.Beans.Videojuego"%>
		<%@ page import="java.sql.SQLException" %>
		<%@ page import="java.sql.ResultSet" %>
		
		<div class="container">
	        <br>
	        <h3>Filtrar Videojuegos por proveedor</h3> <!--Encabezado-->
	        <div class="row mt-3">
	        	<%@ page import="java.util.Objects" %>
				<%@ page import="mx.com.cursodia.javaEE2022.Beans.Proveedor"%>
				<% 
					String cveprov = request.getParameter("cveprov");
					if(Objects.isNull(cveprov))
					{
						System.out.println("clave de proveedor = null");
					}
					else
					{
						System.out.println("clave de proveedor = "+cveprov);
						//response.sendRedirect("MostrarVideojuegos.jsp?QUERY=SELECT * FROM videojuegos WHERE cveprov_vid="+clave);
					}
				%>
		  	</div>
	        
			
	        
			
		</div>
	</body>
</html>