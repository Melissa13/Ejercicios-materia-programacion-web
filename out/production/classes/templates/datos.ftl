<#include "base.ftl">

<#macro page_head>
<title>esto</title>
</#macro>

<#macro page_body>
<h1>Datos Cambiados</h1>
    <table>
        <tbody>
        <tr><td>Matricula</td><td>${est.matricula}</td></tr>
        <tr><td>Nombre</td><td>${est.nombre}</td></tr>
        <tr><td>Apellido</td><td>${est.apellido}</td></tr>
        <tr><td>Telefono</td><td>${est.telefono}</td></tr>
        </tbody>
    </table>
</#macro>