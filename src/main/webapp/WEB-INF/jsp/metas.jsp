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
        <h1 class="titulo-fondo">LIMPIA HUMOS</h1>
        <div class="containerMetas">
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

                            <td>${meta.nombre}</td>
                            <td>${meta.condicion}</td>
                            <td>${meta.fecha_desbloqueo}</td>
                            <td>${meta.desbloqueada}</td>
                            <td>
                                <c:choose>
                                    <c:when test="${meta.desbloqueada}">
                                        <span class="icono-verde">&#10004;</span>
                                    </c:when>
                                    <c:otherwise>
                                        <span class="icono-rojo">&#10008;</span>
                                    </c:otherwise>
                                </c:choose>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <div class="volver-btn-container">
                <a href="${pageContext.request.contextPath}/limpiaHumos/datos?id_usuario=${id_usuario}">
                    <button type="button" style="background-color: #3498db;">
                        Volver
                    </button>
                </a>
            </div>        
        </div>
    </body>
</html>