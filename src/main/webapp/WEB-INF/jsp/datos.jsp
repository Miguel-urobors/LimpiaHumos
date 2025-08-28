<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<!DOCTYPE html>
<html>
<head>
    <title>Página de Inicio</title>
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
        <h1>Bienvenido a la Aplicación</h1>
        <p>${mensaje}</p>
        <a href="${pageContext.request.contextPath}/limpiaHumos/registrarse">Registrarse</a>
    </div>
    
</body>
</html>