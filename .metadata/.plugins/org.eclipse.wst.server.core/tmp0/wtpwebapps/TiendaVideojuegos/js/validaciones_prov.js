function validarForms()
{
	console.log("ENTRO A validarForms()")
	let nombre = document.getElementById("nombre").value;
	let email = document.getElementById("email").value;
	let telefono = document.getElementById("telefono").value;
	
	if(nombre == "" || email == "" || telefono == "") { 
		setWarnsMsj();
	}
	else
	{
		alert("\nNombre = "+nombre+"\nEmail = "+email+"\nTelefono = "+telefono+"\n");
		document.forms[0].action = "InsertarProveedor.jsp?nombre="+nombre+"&email="+email+"&telefono="+telefono;
		document.forms[0].method = "post";
		document.forms[0].submit();
		alert("Proveedor insertado");
	}
}

function validarFormsUpdate()
{
	console.log("ENTRO A validarFormsUpdate()")
	let clave = document.getElementById("clave").value;
	let titulo = document.getElementById("titulo").value;
	let precio = document.getElementById("precio").value;
	//let cveprov = document.getElementById("cveprov").value;
	let cveprov = document.getElementById("cveprov").value.split(" ")
	cveprov = cveprov[0];
	let inv = document.getElementById("inventario").value;
	
	if(titulo == "" || precio == "" || inv == "") { 
		setWarnsMsj();
	}
	else
	{
		alert("clave="+clave+"\ntitulo = "+titulo+"\nprecio = "+precio+"\ncveprov = "+cveprov+"\ninv = "+inv)
		document.forms[0].action = "ActualizarVideojuego.jsp?clave="+clave+"&titulo="+titulo+"&precio="+precio+"&cveprov="+cveprov+"&inventario="+inv;
		document.forms[0].method = "post";
		document.forms[0].submit();
		alert("Videojuego actualizado");
	}
}

function setWarnsMsj()
{
	if(nombre == "") document.getElementById("warn_nombre").innerHTML = "*Ingreseel nombre del proveedor";
	if(email == "") document.getElementById("warn_email").innerHTML = "*Ingrese el email del proveedor";
	if(telefono == "") document.getElementById("warn_tel").innerHTML = "*Ingrese el teléfono del proveedor proveedor";
	
	document.getElementById("ilistalert").innerHTML = "Todos los campos son obligatorios";
    document.getElementById("ilistalert").style.display = "inherit";
    setTimeout(function () {
      document.getElementById("ilistalert").style.display = "none";
    }, 5000);
}
