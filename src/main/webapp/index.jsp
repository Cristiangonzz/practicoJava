<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gestión de Hechos</title>
<style>
    .alert {
        padding: 15px;
        margin-bottom: 20px;
        border: 1px solid transparent;
        border-radius: 4px;
    }
    .alert-success {
        color: #155724;
        background-color: #d4edda;
        border-color: #c3e6cb;
    }
    .alert-danger {
        color: #721c24;
        background-color: #f8d7da;
        border-color: #f5c6cb;
    }
</style>
</head>
<body>
<%-- Mostrar mensaje de éxito o error basado en el parámetro de solicitud --%>
<% 
    String successParam = request.getParameter("success");
    String errorParam = request.getParameter("error");
    if ("true".equals(successParam)) {
%>
    <div class="alert alert-success">Hecho agregado exitosamente.</div>
<% 
    } else if ("true".equals(errorParam)) {
%>
    <div class="alert alert-danger">Error al agregar el hecho. Por favor, inténtelo de nuevo.</div>
<% 
    }
%>
<h2>Agregar Hecho</h2>
<form method="post" action="hechos">
    Descripción: <input type="text" name="description"/><br/>
    Fecha: <input type="date" name="date"/><br/>
    Nivel de Exactitud: <input type="text" name="nivelExactitud"/><br/>
    <input type="submit" value="Agregar Hecho"/>
</form>

<h2>Lista de Hechos</h2>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Descripción</th>
        <th>Fecha</th>
        <th>Nivel de Exactitud</th>
    </tr>
    <c:forEach var="hecho" items="${hechos}">
        <tr>
            <td>${hecho.id}</td>
            <td>${hecho.description}</td>
            <td>${hecho.date}</td>
            <td>${hecho.nivelExactitud}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>