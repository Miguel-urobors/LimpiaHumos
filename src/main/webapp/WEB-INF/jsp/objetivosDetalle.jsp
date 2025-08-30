<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <title>Crear Objetivo</title>
        <link rel="stylesheet" type="text/css" href="/css/estilos.css">
    </head>
    <body>

        <div class="container">
            <h1>Crear Nuevo Objetivo</h1>

            <form action="${pageContext.request.contextPath}/objetivos/guardar" method="post">
                <!-- Campo para el nombre del objetivo -->
                <label for="nombre_objetivo">Nombre del Objetivo:</label>
                <input type="text" id="nombre_objetivo" name="nombre_objetivo" required><br><br>

                <!-- Campo para el diario -->
                <label for="diario">Diario:</label>
                <input type="text" id="diario" name="diario" required><br><br>

                <!-- Campo para el tipo de objetivo -->
                <label for="tipo_objetivo">Tipo de Objetivo:</label>
                <input type="text" id="tipo_objetivo" name="tipo_objetivo" required><br><br>

                <!-- Campo para la fecha de inicio -->
                <label for="fecha_inicio_objetivo">Fecha de Inicio:</label>
                <input type="date" id="fecha_inicio_objetivo" name="fecha_inicio_objetivo" required><br><br>

                <!-- Campo para la fecha de fin -->
                <label for="fecha_fin_objetivo">Fecha de Fin:</label>
                <input type="date" id="fecha_fin_objetivo" name="fecha_fin_objetivo" required><br><br>

                <!-- Botón para enviar el formulario -->
                <button type="submit">Guardar Objetivo</button>
            </form>

            <br>
            <a href="${pageContext.request.contextPath}/objetivos">Volver a la lista de objetivos</a>
        </div>

    </body>
</html>
