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
        <div class="form-container">
            <h1>${titulo}</h1>

            <c:set var="isNew" value="${empty objetivo.id_objetivos}" />
            <!-- Formulario para crear un objetivo -->
            <form action="${pageContext.request.contextPath}/limpiaHumos/objetivos/guardar" method="post">
                <!-- Campo oculto para el id_usuario -->
                <input type="hidden" name="id_usuario" value="${id_usuario}" />
                <c:if test="${!isNew}">
                    <!-- Campo oculto con el ID del objetivo, solo si es edición -->
                    <input type="hidden" name="id_objetivos" value="${objetivo.id_objetivos}" />
                </c:if>

                <!-- Nombre del Objetivo -->
                <label for="nombre_objetivo">Nombre del Objetivo:</label>
                <input type="text" id="nombre_objetivo" name="nombre_objetivo" value="${objetivo.nombre_objetivo}" required />

                <!-- Diario -->
                <label for="diario">Diario:</label>
                <textarea id="diario" name="diario" rows="5" required>${objetivo.diario}</textarea>

                <!-- Tipo de Objetivo como ComboBox -->
                <label for="tipo_objetivo">Tipo de Objetivo:</label>
                <select id="tipo_objetivo" name="tipo_objetivo" required>
                    <option value="">Elegir</option>
                    <option value="Deporte" ${objetivo.tipo_objetivo == 'Deporte' ? 'selected' : ''}>Deporte</option>
                    <option value="Acciones cotidianas" ${objetivo.tipo_objetivo == 'Acciones cotidianas' ? 'selected' : ''}>Acciones cotidianas</option>
                    <option value="Alimentación" ${objetivo.tipo_objetivo == 'Alimentación' ? 'selected' : ''}>Alimentación</option>
                    <option value="Higiene" ${objetivo.tipo_objetivo == 'Higiene' ? 'selected' : ''}>Higiene</option>
                    <option value="Familia y relaciones" ${objetivo.tipo_objetivo == 'Familia y relaciones' ? 'selected' : ''}>Familia y relaciones</option>
                    <option value="Trabajo o estudio" ${objetivo.tipo_objetivo == 'Trabajo o estudio' ? 'selected' : ''}>Trabajo o estudio</option>
                    <option value="Otro" ${objetivo.tipo_objetivo == 'Otro' ? 'selected' : ''}>Otro</option>
                </select>

                <!-- Fecha de Inicio -->
                <label for="fecha_inicio_objetivo">Fecha de Inicio:</label>
                <input type="date" id="fecha_inicio_objetivo" name="fecha_inicio_objetivo" value="${objetivo.fecha_inicio_objetivo}" required />

                <!-- Fecha de Fin -->
                <label for="fecha_fin_objetivo">Fecha de Fin:</label>
                <input type="date" id="fecha_fin_objetivo" name="fecha_fin_objetivo" value="${objetivo.fecha_fin_objetivo}" />

                <button type="submit">
                    <c:choose>
                        <c:when test="${isNew}">Crear Objetivo</c:when>
                        <c:otherwise>Actualizar Objetivo</c:otherwise>
                    </c:choose>
                </button>
            </form>
        </div>
    </body>
</html>

