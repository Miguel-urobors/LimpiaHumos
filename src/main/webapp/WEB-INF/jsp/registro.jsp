<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<!DOCTYPE html>
<html>
    <head>
        <title>Formulario de Registro</title>

        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #f4f4f4;
                text-align: center;
                padding-top: 50px;
            }
            .container {
                background-color: white;
                border-radius: 10px;
                display: inline-block;
                padding: 30px 50px;
                box-shadow: 0 0 10px rgba(0,0,0,0.1);
            }
            h1 {
                color: #333;
            }
            p {
                color: #555;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <form:form action="/limpiaHumos/registrarse/crearUsuario" method="post" modelAttribute="usuario">
                Nombre: <form:input path="nombre" /><br/>
                Edad: <form:input path="edad" /><br/>
                Correo: <form:input path="correo" /><br/>
                Genero: 
                <select name="genero" id="genero">
                    <option value="Hombre">Hombre</option>
                    <option value="Mujer">Mujer</option>
                    <option value="Otro">Otro</option>
                </select><br/>

                Fecha nacimiento: <form:input path="fecha_nacimiento" type="date" /><br/>


                Contraseña: <form:input path="contraseña" type="password" /><br/>

                ¿A que edad empezaste a fumar?: <form:input path="cuestionario.edad_empezar" /><br/>
                ¿Cuantos cigarrillos fumas al dia?: <form:input path="cuestionario.cigarrillos_dia" /><br/>
                ¿Cuantas veces ha intentado para de fumar ?: <form:input path="cuestionario.intentos_parar" /><br/>

                Su razon para parar de fumar: <textarea path="cuestionario.razon_parar" rows="4" cols="50"></textarea><br/>

                <input type="submit" value="Enviar" />
            </form:form>

    </body>
</html>