<#include "base.ftl">

<#macro page_head>
<title>esto</title>
</#macro>

<#macro page_body>
<h3>Detalle estudainte</h3>
    <table>
        <tbody>
        <tr><td>Matricula</td><td>${est.matricula?string["0"]}</td></tr>
        <tr><td>Nombre</td><td>${est.nombre}</td></tr>
        <tr><td>Apellido</td><td>${est.apellido}</td></tr>
        <tr><td>Telefono</td><td>${est.telefono}</td></tr>
        </tbody>
    </table>

<div><h5><a href="/editar/${est.matricula?string["0"]}">Editar</a>   <a href="/delet/${est.matricula?string["0"]}">Borrar</a></h5></div>
</#macro>