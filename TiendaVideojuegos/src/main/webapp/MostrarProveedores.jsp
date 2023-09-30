<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel=stylesheet href="css/mostrarVideojuegos.css" type="text/css">
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
		<title>Mostrar Proveedores</title>
	</head>
	<body style='background-color: rgba(50, 50, 50, 0.3);'>
		<!-- Imports -->
		<%@ page import="mx.com.cursodia.javaEE2022.Beans.Proveedor"%>
		<%@ page import="java.util.List" %>
		
		<div class="container">
	        <br>
	        <div class="d-flex justify-content-between mt-3">
	        	<h3>Lista de Proveedores</h3>
	        	<div>
			        <a class="btn btn-secondary" href="FormularioInsertarProveedor.jsp" role="button"> Agregar Proveedor </a>
			        <a class="btn btn-secondary" href="MostrarVideojuegos.do" role="button"> Videojuegos </a>
	        	</div>
	        </div>
	        
			<table id="dtBasicExample" class="table table-striped mt-4">
	        	<thead>
	            	<tr>
	              		<th>ID</th>
	              		<th>Nombre</th>
	              		<th>Email</th>
	              		<th>Teléfono</th>
	            	</tr>
	          	</thead>
	          	<tbody>
	            	<%			
						List<Proveedor> lista = Proveedor.getProveedores();
						for(Proveedor v:lista)
						{%>
							<tr>
								<th><%=v.getCve_prov()%></th>
								<td><%=v.getNom_prov()%></td>
								<td><%=v.getEmail_prov()%></td>
								<td><%=v.getTel_prov()%></td>
							</tr>
						<%}
					%>
	          	</tbody>
	        </table>
		</div>
	</body>
</html>