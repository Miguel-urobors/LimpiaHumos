<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <title>Lista de Metas</title>
    <link rel="stylesheet" type="text/css" href="/css/estilos.css">
</head>
<body>
    <div class="container">
        <h1>Metas Disponibles</h1>
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nombre de la Meta</th>
                    <th>Condición para Desbloqueo</th>
                </tr>
            </thead>
            <tbody>
                <%-- La clave 'items="${metas}"' coincide con el nombre que le diste en el controlador --%>
                <c:forEach var="meta" items="${metas}">
                    <tr>
                        <td>${meta.id_metas}</td>
                        <td>${meta.nombre}</td>
                        <td>${meta.condicion}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>