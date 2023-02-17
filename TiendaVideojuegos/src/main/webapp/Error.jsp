<%@ page isErrorPage="true" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
	<head>
		<title>Ha ocurrido un error</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	</head>
	<body>
		
		<% if (exception != null) {%>
			<pre>
				<div class="row">
					<div class="col">
						Ha ocurrido un error en la aplicación: <%=exception.getMessage() %>
					
						Error interno: <%=exception.getCause().getMessage()%>
					</div>
				</div>
			</pre>
			
		<%} else {
			System.out.println("Excepcion null");
			
		}%>
	</body>
</html>