function validarForms()
{
	//let clave = document.getElementById("clave").value;
	let titulo = document.getElementById("titulo").value;
	let precio = document.getElementById("precio").value;
	//let cveprov = document.getElementById("cveprov").value;
	let cveprov = document.getElementById("selectprov").value;
	let inv = document.getElementById("inventario").value;
	
	console.log("selected prov: "+cveprov);
	//clave == "" || 
	if(titulo == "" || precio == "" || cveprov == "" || inv == "") { 
		//if(clave == "") document.getElementById("warn_clave").innerHTML = "*Ingrese una clave";
		if(titulo == "") document.getElementById("warn_titulo").innerHTML = "*Ingrese un titulo";
		if(precio == "") document.getElementById("warn_precio").innerHTML = "*Ingrese el precio del libro";
		if(cveprov == "") document.getElementById("warn_cveprov").innerHTML = "*Ingrese la clave del proveedor";
		if(inv == "") document.getElementById("warn_inventario").innerHTML = "*Ingrese la cantidad en existencia";
		
		document.getElementById("ilistalert").innerHTML = "Todos los campos son obligatorios";
	    document.getElementById("ilistalert").style.display = "inherit";
	    setTimeout(function () {
	      document.getElementById("ilistalert").style.display = "none";
	    }, 5000);
	}
	else
	{
		//"clave = "+clave+
		alert("\ntitulo = "+titulo+"\nprecio = "+precio+"\ncveprov = "+cveprov+"\ninv = "+inv)
		//clave="+clave+"&
		document.forms[0].action = "InsertarVideojuego.jsp?titulo="+titulo+"&precio="+precio+"&cveprov="+cveprov+"&inventario="+inv;
		document.forms[0].method = "post";
		document.forms[0].submit();
		alert("Videojuego insertado");
	}
}