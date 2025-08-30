<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<!DOCTYPE html>
<html>
    <head>
        <title>Crear Objetivo</title>
        <link rel="stylesheet" type="text/css" href="/css/estilos.css">
    </head>
    <body>

        <h1>Crear Objetivo</h1>

        <!-- Formulario para crear un objetivo -->
        <form action="${pageContext.request.contextPath}/limpiaHumos/objetivos/guardar" method="post">
            <!-- Campo oculto para el id_usuario -->
            <input type="hidden" name="id_usuario" value="${id_usuario}" />

            <!-- Campo para el nombre del objetivo -->
            <label for="nombre_objetivo">Nombre del Objetivo:</label>
            <input type="text" id="nombre_objetivo" name="nombre_objetivo" value="${objetivo.nombre_objetivo}" required><br><br>

            <!-- Campo para el diario -->
            <label for="diario">Diario:</label>
            <input type="text" id="diario" name="diario" value="${objetivo.diario}" required><br><br>

            <!-- Campo para el tipo de objetivo -->
            <label for="tipo_objetivo">Tipo de Objetivo:</label>
            <input type="text" id="tipo_objetivo" name="tipo_objetivo" value="${objetivo.tipo_objetivo}" required><br><br>

            <!-- Campo para la fecha de inicio -->
            <label for="fecha_inicio_objetivo">Fecha de Inicio:</label>
            <input type="date" id="fecha_inicio_objetivo" name="fecha_inicio_objetivo" value="${objetivo.fecha_inicio_objetivo}" required><br><br>

            <!-- Campo para la fecha de fin -->
            <label for="fecha_fin_objetivo">Fecha de Fin:</label>
            <input type="date" id="fecha_fin_objetivo" name="fecha_fin_objetivo" value="${objetivo.fecha_fin_objetivo}"><br><br>

            <!-- Botón para enviar el formulario -->
            <button type="submit">Guardar Objetivo</button>
        </form>

    </body>
</html>

