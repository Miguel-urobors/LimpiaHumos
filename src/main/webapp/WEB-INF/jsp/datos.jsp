<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>



<!DOCTYPE html>
<html>
    <head>
        <title>Página de Inicio</title>
        <link rel="stylesheet" type="text/css" href="/css/estilos.css">
    </head>
    <body>
        <h1 class="titulo-fondo">LIMPIA HUMOS</h1>
        <div class="containerDatos">

            <div class="estadisticas-grid">
                <div class="estadistica-bloque">
                    <h1><c:out value="${estadisticas.dinero_ahorrado / 100}" /> €</h1>
                    <strong>Dinero Ahorrado</strong>
                </div>

                <div class="estadistica-bloque">
                    <h1><c:out value="${estadisticas.tiempo_sin_fumar}" /></h1>
                    <strong>Días sin fumar</strong>
                </div>

                <div class="estadistica-bloque">
                    <h1><c:out value="${estadisticas.cigarillos_no_fumados}" /></h1>
                    <strong>Cigarrillos no fumados</strong>
                </div>
            </div>

            <div class="botones-navegacion">
                <form action="${pageContext.request.contextPath}/limpiaHumos/metas" method="get">
                    <input type="hidden" name="id_usuario" value="${estadisticas.usuario.id_usuario}" />
                    <button type="submit">Ir a Metas</button>
                </form>

                <form action="${pageContext.request.contextPath}/limpiaHumos/objetivos" method="get">
                    <input type="hidden" name="id_usuario" value="${estadisticas.usuario.id_usuario}" />
                    <button type="submit">Ir a Objetivos</button>
                </form>
            </div>

        </div>
    </body>
</html>