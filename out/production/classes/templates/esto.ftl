<#include "base.ftl">

<#macro page_head>
<title>esto</title>
</#macro>

<#macro page_body>
<h1>Detalle estudainte</h1>
    <table>
        <tbody>
        <tr><td>Matricula</td><td>${est.matricula}</td></tr>
        <tr><td>Nombre</td><td>${est.nombre}</td></tr>
        <tr><td>Apellido</td><td>${est.apellido}</td></tr>
        <tr><td>Telefono</td><td>${est.telefono}</td></tr>
        </tbody>
    </table>

<div><h5><a href="/editar/${est.matricula}">Editar</a>   <a href="/delet/${est.matricula}">Borrar</a></h5></div>
</#macro>