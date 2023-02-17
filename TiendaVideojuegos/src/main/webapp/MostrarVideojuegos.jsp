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
		<%@ page import="java.util.List" %>
		
		<div class="container">
	        <br>
	        <div class="d-flex justify-content-between mt-3">
	        	<h3>Lista de Videojuegos</h3>
	        	<div>
			        <a class="btn btn-secondary" href="FormularioInsertarVideojuego.jsp" role="button"> Agregar Videojuego </a>
			        <a class="btn btn-secondary" href="MostrarProveedores.jsp" role="button"> Proveedores </a>
	        	</div>
	        </div>
	        
	        <%@ page import="mx.com.cursodia.javaEE2022.Beans.Proveedor"%>
	        <%@ page import="java.util.Objects" %>
			<% 
				String query = request.getParameter("query");
				if(Objects.isNull(query))
				{
					System.out.println("clave de proveedor = null");%>
					
					Filtrar videojuegos por proveedor: 
					<select class="form-select" aria-label="Default select example" id="selectprov" onchange="filtrarVideojuegos()">
						<option value="0">Todos</option>							 
						<%			
							List<Proveedor> prov_list = Proveedor.getProveedores();
							for(Proveedor p:prov_list)
							{%>
								<option value="<%=p.getCve_prov()%>"><%=p.getCve_prov()%> - <%=p.getNom_prov()%></option>
							<%}
						%>
					</select>
			        
					<table id="dtBasicExample" class="table table-striped mt-4">
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
								List<Videojuego> vid_list = Videojuego.buscarTodos();
								for(Videojuego v:vid_list)
								{%>
									<tr>
										<th><%=v.getCve_vid()%></th>
										<td><%=v.getTit_vid()%></td>
										<td><%=v.getPre_vid()%></td>
										<td><%=v.getCveprov_vid()%></td>
										<td><%=v.getInv_vid()%></td>
										<td>
											<input type="button" class="edit" value="Editar" onclick="location.href= 'FormularioInsertarVideojuego.jsp?CVE=<%=v.getCve_vid()%>'"/>
										<!-- <a href="FormularioInsertarVideojuego.jsp?CVE=<%v.getCve_vid();%>">Editar</a></td> -->
									</tr>
								<%}
							%>
			          	</tbody>
			        </table>
	        
				<%}
				else
				{
					System.out.println("clave de proveedor = "+query);
					//response.sendRedirect("MostrarVideojuegos.jsp?QUERY=SELECT * FROM videojuegos WHERE cveprov_vid="+clave);
				}
			%>
				
	        
		</div>
	</body>
</html>