<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>



<!DOCTYPE html>
<html>
    <head>
        <title>Formulario de Registro</title>
        <link rel="stylesheet" type="text/css" href="/css/estilos.css">
    </head>
    <body>
        <h1 class="titulo-fondo">LIMPIA HUMOS</h1>
        <div class="registro-cuestionario-container">
            <form:form action="/limpiaHumos/registrarse/crearUsuario" method="post" modelAttribute="usuario">

                Nombre: <form:input path="nombre" />
                <form:errors path="nombre" cssClass="error"/><br/>

                Edad: <form:input path="edad" />
                <form:errors path="edad" cssClass="error"/><br/>

                Correo: <form:input path="correo" />
                <form:errors path="correo" cssClass="error"/><br/>

                Género: 
                <form:select path="genero">
                    <form:option value="" label="Elige..."/>
                    <form:option value="Hombre" label="Hombre"/>
                    <form:option value="Mujer" label="Mujer"/>
                    <form:option value="Otro" label="Otro"/>
                </form:select>
                <form:errors path="genero" cssClass="error"/>
                <br/>
                <br/>

                Fecha nacimiento: <form:input path="fecha_nacimiento" type="date" />
                <form:errors path="fecha_nacimiento" cssClass="error"/>
                <br/>
                <br/>

                Contraseña: <form:input path="contraseña" type="password" />
                <form:errors path="contraseña" cssClass="error"/>
                <br/>
                <br/>

                ¿A qué edad empezaste a fumar?: <form:input path="cuestionario.edad_empezar" />
                <form:errors path="cuestionario.edad_empezar" cssClass="error"/>
                <br/>
                <br/>
                ¿Cuántos cigarrillos fumas al día?: <form:input path="cuestionario.cigarrillos_dia" />
                <form:errors path="cuestionario.cigarrillos_dia" cssClass="error"/>
                <br/>
                <br/>

                ¿Cuántas veces ha intentado parar de fumar?: <form:input path="cuestionario.intentos_parar" />
                <form:errors path="cuestionario.intentos_parar" cssClass="error"/>
                <br/>
                <br/>

                Su razón para parar de fumar: 
                <form:textarea path="cuestionario.razon_parar" rows="4" cols="50"></form:textarea>
                <form:errors path="cuestionario.razon_parar" cssClass="error"/>
                <br/>
                <br/>

                <input type="submit" value="Enviar" />

            </form:form>
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