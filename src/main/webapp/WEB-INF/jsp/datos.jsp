<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<!DOCTYPE html>
<html>
    <head>
        <title>Página de Inicio</title>
        <link rel="stylesheet" type="text/css" href="/css/estilos.css">
    </head>
    <body>
        <div class="container">
            <display:table name="estadisticas" requestURI="" pagesize="10" sort="list" >
                <display:column property="fecha_estadistica" title="Fecha" />
                <display:column property="dinero_ahorrado" title="Dinero Ahorrado" />
                <display:column property="tiempo_sin_fumar" title="Tiempo sin fumar" />
                <display:column property="cigarillos_no_fumados" title="Cigarillos no fumados" />
            </display:table>
        </div>

    </body>
</html>