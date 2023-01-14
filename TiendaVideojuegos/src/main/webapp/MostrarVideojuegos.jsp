<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel=stylesheet href="css/mostrarVideojuegos.css" type="text/css">
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
		<title>Mostrar Videojuegos</title>
	</head>
	<body style='background-color: rgba(50, 50, 50, 0.3);'>
	<!-- Imports -->
		<%@ page import="mx.com.cursodia.javaEE2022.Beans.Videojuego"%>
		<%@ page import="java.sql.SQLException" %>
		<%@ page import="java.sql.ResultSet" %>
		
		<div class="container">
	        <br>
	        <div class="d-flex justify-content-between mt-3">
	        	<h3>Lista de Videojuegos</h3> <!--Encabezado-->
		        <a class="btn btn-secondary" href="FormularioInsertarVideojuego.jsp" role="button"> Insertar Videojuego </a>
	       		<!-- <a href="FormularioInsertarVideojuego.jsp"> Insertar Videojuego </a> -->
	        </div>
	        
			<table id="dtBasicExample" class="table table-striped mt-4"> <!-- class="table table-striped mt-5"        matSort (matSortChange)="sortData($event)"-->
	        	<thead>
	            	<tr>
	              		<th>ID</th>
	              		<th>Nombre</th>
	              		<th>Precio</th>
	              		<th>Cve Prov</th>
	              		<th>Inventario</th>
	            	</tr>
	          	</thead>
	          	<tbody>
	            	<%
						ResultSet rs = null;
						try {				
							rs = Videojuego.buscarTodos();
							
							while(rs.next())
							{%>
								<tr>
									<th><%=rs.getInt("cve_vid")%></th>
									<td><%=rs.getString("tit_vid")%></td>
									<td><%=rs.getFloat("pre_vid")%></td>
									<td><%=rs.getInt("cveprov_vid")%></td>
									<td><%=rs.getInt("inv_vid")%></td>
								</tr>
							<%}
							//response.sendRedirect("FormularioInsertarVideojuego");
						} catch(SQLException e) {
							System.out.println("Error accediendo a la DB "+e.getMessage());
						} finally {
							if(rs!=null) rs.close();
						}
					%>
	          	</tbody>
	        </table>
		</div>
	</body>
</html>