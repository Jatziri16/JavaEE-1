function validarForms()
{
	console.log("ENTRO A validarForms()")
	//let clave = document.getElementById("clave").value;
	let titulo = document.getElementById("titulo").value;
	let precio = document.getElementById("precio").value;
	//let cveprov = document.getElementById("cveprov").value;
	let cveprov = document.getElementById("selectprov").value;
	let inv = document.getElementById("inventario").value;
	
	console.log("selected prov: "+cveprov);
	//clave == "" || 
	if(titulo == "" || precio == "" || cveprov == "" || inv == "") { 
		setWarnsMsj();
	}
	else
	{
		//"clave = "+clave+
		alert("\ntitulo = "+titulo+"\nprecio = "+precio+"\ncveprov = "+cveprov+"\ninv = "+inv)
		//clave="+clave+"&
		document.forms[0].action = "InsertarVideojuego.do?titulo="+titulo+"&precio="+precio+"&cveprov="+cveprov+"&inventario="+inv;
		document.forms[0].method = "get";
		document.forms[0].submit();
		alert("Videojuego insertado");
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
    //if(clave == "") document.getElementById("warn_clave").innerHTML = "*Ingrese una clave";
	if(titulo == "") document.getElementById("warn_titulo").innerHTML = "*Ingrese un titulo";
	if(precio == "") document.getElementById("warn_precio").innerHTML = "*Ingrese el precio del videojuego";
	//if(cveprov == "") document.getElementById("warn_cveprov").innerHTML = "*Ingrese la clave del proveedor";
	//if(inv == "") document.getElementById("warn_inventario").innerHTML = "*Ingrese la cantidad en existencia";
	
	document.getElementById("ilistalert").innerHTML = "Todos los campos son obligatorios";
    document.getElementById("ilistalert").style.display = "inherit";
    setTimeout(function () {
      document.getElementById("ilistalert").style.display = "none";
    }, 5000);
}

function filtrarVideojuegos()
{
	const claveProv = document.getElementById("selectprov").value;
	console.log("selected prov: "+claveProv);
}