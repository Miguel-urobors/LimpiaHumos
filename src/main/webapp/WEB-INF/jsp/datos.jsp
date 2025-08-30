<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>



<!DOCTYPE html>
<html>
    <head>
        <title>Página de Inicio</title>
        <link rel="stylesheet" type="text/css" href="/css/estilos.css">
    </head>
    <body>

        <div class="container">
            <div class="estadistica-detalle">
                <p><strong>Dinero Ahorrado:</strong> <c:out value="${estadisticas.dinero_ahorrado}" /> €</p>
                <p><strong>Tiempo sin fumar:</strong> <c:out value="${estadisticas.tiempo_sin_fumar}" /> días</p>
                <p><strong>Cigarrillos no fumados:</strong> <c:out value="${estadisticas.cigarillos_no_fumados}" /></p>
            </div>
        </div>

        <form action="${pageContext.request.contextPath}/limpiaHumos/metas" method="get">
            <button type="submit">Ir a Metas</button>
        </form>

        <form action="${pageContext.request.contextPath}/limpiaHumos/objetivos" method="get">
            <input type="hidden" name="id_usuario" value="${estadisticas.usuario.id_usuario}" />
            <button type="submit">Ir a Objetivos</button>
        </form>

    </body>
</html>