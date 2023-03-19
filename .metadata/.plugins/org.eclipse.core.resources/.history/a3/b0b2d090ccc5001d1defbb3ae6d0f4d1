function filtrarVideojuegos()
{
	let cveprov = document.getElementById("selectprov").value;
	console.log("filtrar cvprov = "+cveprov);
	if(cveprov==0)
	{
		document.forms[0].action = "MostrarVideojuegos.jsp?query=SELECT * FROM videojuegos";
		document.forms[0].method = "post";
		document.forms[0].submit();
	}
	else
	{
		document.forms[0].action = "FiltrarVideojuegos-Prov.jsp?CVE="+cveprov+"";
		document.forms[0].method = "post";
		document.forms[0].submit();
	}
}