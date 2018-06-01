<#include "base.ftl">

<#macro page_head>
<title>esto</title>
</#macro>

<#macro page_body>
<h3>Datos agregados</h3>
    <table>
        <tbody>
        <tr><td>Matricula</td><td>${est.matricula?string["0"]}</td></tr>
        <tr><td>Nombre</td><td>${est.nombre}</td></tr>
        <tr><td>Apellido</td><td>${est.apellido}</td></tr>
        <tr><td>Telefono</td><td>${est.telefono}</td></tr>
        </tbody>
    </table>
</#macro>