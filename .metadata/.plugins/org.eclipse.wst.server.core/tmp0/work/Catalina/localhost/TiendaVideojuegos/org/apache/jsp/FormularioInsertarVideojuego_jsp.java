/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.78
 * Generated at: 2023-02-25 17:20:11 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Objects;
import mx.com.cursodia.javaEE2022.Beans.Videojuego;
import mx.com.cursodia.javaEE2022.Beans.Proveedor;
import java.util.List;

public final class FormularioInsertarVideojuego_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.util.Objects");
    _jspx_imports_classes.add("mx.com.cursodia.javaEE2022.Beans.Videojuego");
    _jspx_imports_classes.add("mx.com.cursodia.javaEE2022.Beans.Proveedor");
    _jspx_imports_classes.add("java.util.List");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01//EN\" \"http://www.w\r\n");
      out.write("3.org/TR/html4/strict.dtd\">\r\n");
      out.write("<html = lang \"es\"></html>\r\n");
      out.write("<html>\r\n");
      out.write("	<head>\r\n");
      out.write("		<meta charset=\"utf-8\">\r\n");
      out.write("		<title>Formulario Alta Videojuego</title>\r\n");
      out.write("		<link rel=stylesheet href=\"css/style.css\" type=\"text/css\">\r\n");
      out.write("		<!-- <link rel=\"stylesheet\" src=\"css/style.css\">-->\r\n");
      out.write("		<!-- Bootstrap -->\r\n");
      out.write("  		<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3\" crossorigin=\"anonymous\">\r\n");
      out.write("		<script type=\"text/javascript\" src=\"js/validaciones.js\"></script>\r\n");
      out.write("	</head>\r\n");
      out.write("	<body style='background-color: rgba(50, 50, 50, 0.3);'>\r\n");
      out.write("		<div id=\"fondo\">\r\n");
      out.write("			<h3 class=\"text-center mt-5 mb-1\">Formulario Alta de Nuevo Videojuego</h3>\r\n");
      out.write("			<div class=\"container rounded-3 contenedor\">\r\n");
      out.write("				<div class=\"row align-items-stretch justify-content-center\">\r\n");
      out.write("					<div class=\"login-container  col-7 col-sm-6 col-md-5 col-xl-5 rounded-end shadow\">\r\n");
      out.write("						<p class=\"text-center\">Ingresa los siguientes datos:</p>\r\n");
      out.write("						<div class=\"centrar\">\r\n");
      out.write("							<!-- FORM -->\r\n");
      out.write("							\r\n");
      out.write("							\r\n");
      out.write("							");
 
								String clave = request.getParameter("CVE");
								if(Objects.isNull(clave))
								{
      out.write("\r\n");
      out.write("									<form action=\"InsertarVideojuego.do\" method=\"GET\">\r\n");
      out.write("										<!-- Clave:\r\n");
      out.write("										<input class=\"form-control\" id=\"clave\"  type=\"text\" name=\"cve\" placeholder=\"*Clave\">\r\n");
      out.write("										<div class=\"text-danger invalido\" id=\"warn_clave\"></div>  -->\r\n");
      out.write("										<!-- TÃ­tulo: -->\r\n");
      out.write("										<input class=\"form-control mt-2\" id=\"titulo\" type=\"text\" name=\"titulo\" placeholder=\"*Titulo\">\r\n");
      out.write("										<div class=\"text-danger invalido\" id=\"warn_titulo\"></div>\r\n");
      out.write("										<!-- Precio: -->\r\n");
      out.write("										<input class=\"form-control mt-2\" id=\"precio\" type=\"text\" name=\"precio\" placeholder=\"*Precio\">\r\n");
      out.write("										<div class=\"text-danger invalido\" id=\"warn_precio\"></div>\r\n");
      out.write("										\r\n");
      out.write("										<!-- Clave del proveedor: \r\n");
      out.write("										<input class=\"form-control mt-2\" id=\"cveprov\" type=\"text\" name=\"cveprov\" placeholder=\"*Clave del proveedor\">\r\n");
      out.write("										<div class=\"text-danger invalido\" id=\"warn_cveprov\"></div>-->\r\n");
      out.write("										\r\n");
      out.write("										\r\n");
      out.write("										\r\n");
      out.write("										<select class=\"form-select\" aria-label=\"Default select example\" id=\"selectprov\" name=\"cveprov\">							 \r\n");
      out.write("											");
			
												List<Proveedor> lista = Proveedor.getProveedores();
												for(Proveedor p:lista)
												{
      out.write("\r\n");
      out.write("													<option value=\"");
      out.print(p.getCve_prov());
      out.write('"');
      out.write('>');
      out.print(p.getCve_prov());
      out.write(' ');
      out.write('-');
      out.write(' ');
      out.print(p.getNom_prov());
      out.write("</option>\r\n");
      out.write("												");
}
												//response.sendRedirect("FormularioInsertarVideojuego");
											
      out.write("\r\n");
      out.write("										</select>\r\n");
      out.write("										\r\n");
      out.write("										<!-- Inventario: -->\r\n");
      out.write("										<input class=\"form-control mt-2\" id=\"inventario\" type=\"text\" name=\"inventario\" placeholder=\"*Inventario\">\r\n");
      out.write("										<div class=\"text-danger invalido\" id=\"warn_inventario\"></div>\r\n");
      out.write("										\r\n");
      out.write("										<button type=\"submit\" class=\"button btn-insertar mt-3 mb-2\" type=\"button\" value=\"Insertar\">INSERTAR</button>\r\n");
      out.write("										<input onclick=\"validarForms()\" class=\"button btn-insertar mt-3 mb-2\" type=\"button\" value=\"Insertar\">\r\n");
      out.write("										<a  role=\"button\" class=\"button btn-cancelar  mb-3\" href=\"MostrarVideojuegos.jsp\"> Cancelar </a>\r\n");
      out.write("									\r\n");
      out.write("									</form>\r\n");
      out.write("								");
}
								else
								{
									int cve = Integer.parseInt(clave); 
									System.out.println("La clave es: "+cve);
									Videojuego v = Videojuego.getVideojuego(cve);
									System.out.println(v.toString());
									Proveedor prov = Proveedor.getProveedor(v.getCveprov_vid());
									
      out.write("\r\n");
      out.write("									\r\n");
      out.write("									<form action=\"InsertarVideojuego.do\" method=\"GET\">\r\n");
      out.write("										<!-- Clave:  -->\r\n");
      out.write("										<input class=\"form-control\" id=\"clave\"  type=\"text\" name=\"cve\" placeholder=\"*Clave\" value=\"");
      out.print(v.getCve_vid());
      out.write("\" disabled>\r\n");
      out.write("										\r\n");
      out.write("										<!-- TÃ­tulo: -->\r\n");
      out.write("										<input class=\"form-control mt-2\" id=\"titulo\" type=\"text\" name=\"titulo\" placeholder=\"*Titulo\" value=\"");
      out.print(v.getTit_vid());
      out.write("\">\r\n");
      out.write("										<div class=\"text-danger invalido\" id=\"warn_titulo\"></div>\r\n");
      out.write("										<!-- Precio: -->\r\n");
      out.write("										<input class=\"form-control mt-2\" id=\"precio\" type=\"text\" name=\"precio\" placeholder=\"*Precio\" value=\"");
      out.print(v.getPre_vid());
      out.write("\">\r\n");
      out.write("										<div class=\"text-danger invalido\" id=\"warn_precio\"></div>\r\n");
      out.write("										\r\n");
      out.write("										<!-- Clave del proveedor:  -->\r\n");
      out.write("										<input class=\"form-control mt-2\" id=\"cveprov\" type=\"text\" name=\"cveprov\" placeholder=\"*Clave del proveedor\" value=\"");
      out.print(v.getCveprov_vid());
      out.write(' ');
      out.write('-');
      out.write(' ');
      out.print(prov.getNom_prov());
      out.write("\" disabled>\r\n");
      out.write("																	\r\n");
      out.write("										\r\n");
      out.write("										<!-- Inventario: -->\r\n");
      out.write("										<input class=\"form-control mt-2\" id=\"inventario\" type=\"text\" name=\"inventario\" placeholder=\"*Inventario\" value=\"");
      out.print(v.getInv_vid());
      out.write("\">\r\n");
      out.write("										<div class=\"text-danger invalido\" id=\"warn_inventario\"></div>\r\n");
      out.write("										\r\n");
      out.write("										<input onclick=\"validarFormsUpdate()\" class=\"button btn-actualizar mt-3 mb-2\" type=\"button\" value=\"Actualizar\">\r\n");
      out.write("										<a  role=\"button\" class=\"button btn-cancelar  mb-3\" href=\"MostrarVideojuegos.jsp\"> Cancelar </a>\r\n");
      out.write("									</form>\r\n");
      out.write("								");
}
      out.write("\r\n");
      out.write("						</div>\r\n");
      out.write("					</div>\r\n");
      out.write("				</div>\r\n");
      out.write("				\r\n");
      out.write("				<div class=\"row mt-3 align-items-stretch justify-content-center\">\r\n");
      out.write("					<div class=\"col-7 col-sm-6 col-md-5 col-xl-5\">\r\n");
      out.write("						<div class=\"alert alert-danger\" role=\"alert\" id=\"ilistalert\" style=\"display:none\">hola</div>							\r\n");
      out.write("					</div>\r\n");
      out.write("				</div>\r\n");
      out.write("			</div>\r\n");
      out.write("		</div>\r\n");
      out.write("	</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
