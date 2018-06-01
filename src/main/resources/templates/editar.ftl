<#include "base.ftl">

<#macro page_head>
<title>Nuevo formulario</title>
</#macro>

<#macro page_body>
<h3>Editar datos del estudainte</h3>
<form class="form-inline" method="POST" action="/editado/${mat}">
    Matricula: <input name="matricula" type="number"/><br/>
    Nombre: <input name="nombre" type="text"/><br/>
    Apellido: <input name="apellido" type="text"/><br/>
    Telefono: <input name="telefono" type="text"/><br/>
    <button type="submit" class="btn btn-default">Editar</button>

</form>
</#macro>