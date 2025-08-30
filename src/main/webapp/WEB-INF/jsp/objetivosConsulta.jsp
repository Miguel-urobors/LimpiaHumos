<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <title>Consulta de Objetivos</title>
        <link rel="stylesheet" type="text/css" href="/css/estilos.css">
    </head>
    <body>

        <div class="container">
            <h1>Lista de Objetivos</h1>

            <!-- Botón para añadir un nuevo objetivo -->
            <a href="${pageContext.request.contextPath}/objetivos/crear">
                <button>Añadir Nuevo Objetivo</button>
            </a>

            <!-- Mostrar la tabla con los objetivos -->
            <table border="1">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nombre</th>
                        <th>Diario</th>
                        <th>Tipo de Objetivo</th>
                        <th>Fecha de Inicio</th>
                        <th>Fecha de Fin</th>
                        <th>Operaciones</th> <!-- Columna para las operaciones -->
                    </tr>
                </thead>
                <tbody>
                    <!-- Iterar sobre la lista de objetivos -->
                    <c:forEach var="objetivo" items="${objetivosList}">
                        <tr>
                            <td>${objetivo.id_objetivos}</td>
                            <td>${objetivo.nombre_objetivo}</td>
                            <td>${objetivo.diario}</td>
                            <td>${objetivo.tipo_objetivo}</td>
                            <td>${objetivo.fecha_inicio_objetivo}</td>
                            <td>${objetivo.fecha_fin_objetivo}</td>
                            <td>
                                <!-- Enlace para editar el objetivo -->
                                <a href="${pageContext.request.contextPath}/objetivos/editar/${objetivo.id_objetivos}">Editar</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>

        </div>

    </body>
</html>
