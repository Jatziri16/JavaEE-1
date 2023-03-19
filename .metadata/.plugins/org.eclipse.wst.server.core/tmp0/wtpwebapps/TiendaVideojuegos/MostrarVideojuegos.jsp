<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel=stylesheet href="css/mostrarVideojuegos.css" type="text/css">
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
		<script type="text/javascript" src="js/filtrar_vid.js"></script>
		<title>Mostrar Videojuegos</title>
	</head>
	<body style='background-color: rgba(50, 50, 50, 0.3);'>
		<!-- Imports -->
		<%@ page import="mx.com.cursodia.javaEE2022.Beans.Videojuego"%>
		<%@ page import="mx.com.cursodia.javaEE2022.Beans.Proveedor"%>
		<%@ page import="java.util.List" %>
		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		
		<div class="container">
	        <br>
	        <div class="d-flex justify-content-between mt-3">
	        	<h3>Lista de Videojuegos</h3>
	        	<div>
			        <a class="btn btn-secondary" href="FormularioInsertarVideojuego.do" role="button"> Agregar Videojuego </a>
			        <a class="btn btn-secondary" href="MostrarProveedores.jsp" role="button"> Proveedores </a>
	        	</div>
	        </div>
	        
	        <%@ page import="java.util.Objects" %>
	        <form name="filtroProveedor" action="ControladorVideojuegos.do" method="GET">
				Filtrar videojuegos por proveedor: 
				<select name="Proveedor" class="form-select" id="selectprov" onchange="this.form.submit()">
					<option value="" disabled selected>Selecciona un proveedor</option>
					<option value="Todos">Todos</option>
					<!-- Segunda opcion para mostrar los proveedores MEJORADA - JSTL -->
					<%
						List<Proveedor> listaProveedores = null;
						listaProveedores = (List<Proveedor>)request.getAttribute("listaProveedores"); %>
						
						<c:forEach var="Proveedor" items="${listaProveedores}">
							<option value="${Proveedor.cve_prov}">${Proveedor.cve_prov} - ${Proveedor.nom_prov}</option>
						</c:forEach>	
												 
					<!-- Primera opcion para mostrar los proveedores
					<%			
						List<Proveedor> prov_list = (List<Proveedor>)request.getAttribute("listaProveedores"); //Proveedor.getProveedores();
						for(Proveedor p:prov_list)
						{%>
							<option value="<%=p.getCve_prov()%>"><%=p.getCve_prov()%> - <%=p.getNom_prov()%></option>
						<%}
					%> -->
				</select>
			</form>
			
	        
			<table id="dtBasicExample" class="table table-striped mt-4 mb-5">
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
					<%List<Videojuego> listaVideojuegos= (List<Videojuego>)request.getAttribute("listaVideojuegos");%>
					<c:forEach var="Videojuego" items="${listaVideojuegos}">
						<tr>
							<th>${Videojuego.cve_vid}</th>
							<td>${Videojuego.tit_vid}</td>
							<td>${Videojuego.pre_vid}</td>
							<td>${Videojuego.cveprov_vid}</td>
							<td>${Videojuego.inv_vid}</td>
							<td>
								<input type="button" class="edit" value="Editar" onclick="location.href= 'FormularioInsertarVideojuego.do?CVE=${Videojuego.cve_vid}'"/>
							</td>
						</tr>
					</c:forEach>
	          	</tbody>
	        </table>
		</div>
	</body>
</html>