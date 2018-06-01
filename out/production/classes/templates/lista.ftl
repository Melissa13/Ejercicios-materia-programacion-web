<#include "base.ftl">

<#macro page_head>
<title>Lista de Estudiantes</title>
</#macro>

<#macro page_body>
<h1>pagina de listas</h1>
    <p>
    <h5>Cantidad de estudiantes: ${lista?size}</h5>
        <table>
            <tr><th>Matricula</th><th>Nombre</th><th>Apellido</th><th>Telefono</th><th>ver</th></tr>
<#list lista as estudiante>
    <tr><td>${estudiante.matricula?string["0"]}</td><td>${estudiante.nombre}</td><td>${estudiante.apellido}</td><td>${estudiante.telefono}</td><td><a href="/ruta/${estudiante.matricula?string["0"]}" name="nombre">ver</a></td></tr>
</#list>
        </table>
    </p>
</#macro>