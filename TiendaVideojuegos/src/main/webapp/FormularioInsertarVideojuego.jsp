<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html = lang "es"></html>
<html>
	<head>
		<meta charset="utf-8">
		<title>Formulario Alta Videojuego</title>
		<link rel=stylesheet href="css/style.css" type="text/css">
		<!-- <link rel="stylesheet" src="css/style.css">-->
		<!-- Bootstrap -->
  		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
  
		<script type="text/javascript" src="js/validaciones.js"></script>
	</head>
	<body style='background-color: rgba(50, 50, 50, 0.3);'>
		<div id="fondo">
			<h3 class="text-center mt-5 mb-1">Formulario Alta de Nuevo Videojuego</h3>
			<div class="container rounded-3 contenedor">
				<div class="row align-items-stretch justify-content-center">
					<div class="login-container  col-7 col-sm-6 col-md-5 col-xl-5 rounded-end shadow">
						<p class="text-center">Ingresa los siguientes datos:</p>
						<div class="centrar">
							<form action="InsertarVideojuego.do" method="GET">
								<!-- Clave:
								<input class="form-control" id="clave"  type="text" name="cve" placeholder="*Clave">
								<div class="text-danger invalido" id="warn_clave"></div>  -->
								<!-- Título: -->
								<input class="form-control mt-2" id="titulo" type="text" name="titulo" placeholder="*Titulo">
								<div class="text-danger invalido" id="warn_titulo"></div>
								<!-- Precio: -->
								<input class="form-control mt-2" id="precio" type="text" name="precio" placeholder="*Precio">
								<div class="text-danger invalido" id="warn_precio"></div>
								
								<!-- Clave del proveedor: 
								<input class="form-control mt-2" id="cveprov" type="text" name="cveprov" placeholder="*Clave del proveedor">
								<div class="text-danger invalido" id="warn_cveprov"></div>-->
								
								<%@ page import="mx.com.cursodia.javaEE2022.Beans.Videojuego"%>
								<%@ page import="java.sql.ResultSet"%>
								<%@ page import="java.sql.SQLException"%>
								<select class="form-select" aria-label="Default select example" id="selectprov">							 
									<%
										ResultSet rs = null;
										try {				
											rs = Videojuego.buscarTodosLosProveedores();
											
											while(rs.next())
											{%>
												<option value="<%=rs.getInt("cve_prov")%>"><%=rs.getInt("cve_prov")%> - <%=rs.getString("nom_prov")%></option>
											<%}
											//response.sendRedirect("FormularioInsertarVideojuego");
										} catch(SQLException e) {
											System.out.println("Error accediendo a la DB "+e.getMessage());
										} finally {
											if(rs!=null) rs.close();
										}
									%>
								</select>
								
								
								<!-- Inventario: -->
								<input class="form-control mt-2" id="inventario" type="text" name="inventario" placeholder="*Inventario">
								<div class="text-danger invalido" id="warn_inventario"></div>
								
								<input onclick="validarForms()" class="button btn-insertar mt-3 mb-3" type="button" value="Insertar">
								<input onclick="hola()" class="button btn-insertar mt-3 mb-3" type="button" value="Hola">
							</form>
						</div>
					</div>
				</div>
				
				<div class="row mt-3 align-items-stretch justify-content-center">
					<div class="col-7 col-sm-6 col-md-5 col-xl-5">
						<div class="alert alert-danger" role="alert" id="ilistalert" style="display:none">hola</div>							
					</div>
				</div>
			</div>
		</div>
	</body>
</html>