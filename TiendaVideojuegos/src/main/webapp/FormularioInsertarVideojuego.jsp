<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w
3.org/TR/html4/strict.dtd">
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
							<!-- FORM -->
							<%@ page import="java.util.Objects" %>
							<%@ page import="mx.com.cursodia.javaEE2022.Beans.Videojuego"%>
							<% 
								String clave = request.getParameter("CVE");
								if(Objects.isNull(clave))
								{%>
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
										
										<%@ page import="mx.com.cursodia.javaEE2022.Beans.Proveedor"%>
										<%@ page import="java.util.List" %>
										<select class="form-select" aria-label="Default select example" id="selectprov" name="cveprov">							 
											<%			
												List<Proveedor> lista = Proveedor.getProveedores();
												for(Proveedor p:lista)
												{%>
													<option value="<%=p.getCve_prov()%>"><%=p.getCve_prov()%> - <%=p.getNom_prov()%></option>
												<%}
												//response.sendRedirect("FormularioInsertarVideojuego");
											%>
										</select>
										
										<!-- Inventario: -->
										<input class="form-control mt-2" id="inventario" type="text" name="inventario" placeholder="*Inventario">
										<div class="text-danger invalido" id="warn_inventario"></div>
										
										<button type="submit" class="button btn-insertar mt-3 mb-2" type="button" value="Insertar">INSERTAR</button>
										<input onclick="validarForms()" class="button btn-insertar mt-3 mb-2" type="button" value="Insertar">
										<a  role="button" class="button btn-cancelar  mb-3" href="MostrarVideojuegos.jsp"> Cancelar </a>
									
									</form>
								<%}
								else
								{
									int cve = Integer.parseInt(clave); 
									System.out.println("La clave es: "+cve);
									Videojuego v = Videojuego.getVideojuego(cve);
									System.out.println(v.toString());
									Proveedor prov = Proveedor.getProveedor(v.getCveprov_vid());
									%>
									
									<form action="InsertarVideojuego.do" method="GET">
										<!-- Clave:  -->
										<input class="form-control" id="clave"  type="text" name="cve" placeholder="*Clave" value="<%=v.getCve_vid()%>" disabled>
										
										<!-- Título: -->
										<input class="form-control mt-2" id="titulo" type="text" name="titulo" placeholder="*Titulo" value="<%=v.getTit_vid()%>">
										<div class="text-danger invalido" id="warn_titulo"></div>
										<!-- Precio: -->
										<input class="form-control mt-2" id="precio" type="text" name="precio" placeholder="*Precio" value="<%=v.getPre_vid()%>">
										<div class="text-danger invalido" id="warn_precio"></div>
										
										<!-- Clave del proveedor:  -->
										<input class="form-control mt-2" id="cveprov" type="text" name="cveprov" placeholder="*Clave del proveedor" value="<%=v.getCveprov_vid()%> - <%=prov.getNom_prov()%>" disabled>
																	
										
										<!-- Inventario: -->
										<input class="form-control mt-2" id="inventario" type="text" name="inventario" placeholder="*Inventario" value="<%=v.getInv_vid()%>">
										<div class="text-danger invalido" id="warn_inventario"></div>
										
										<input onclick="validarFormsUpdate()" class="button btn-actualizar mt-3 mb-2" type="button" value="Actualizar">
										<a  role="button" class="button btn-cancelar  mb-3" href="MostrarVideojuegos.jsp"> Cancelar </a>
									</form>
								<%}%>
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