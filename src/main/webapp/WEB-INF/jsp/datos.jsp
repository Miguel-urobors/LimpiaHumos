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
        <h1>Bienvenido a la Aplicación</h1>
        <p>${mensaje}</p>
        <a href="${pageContext.request.contextPath}/limpiaHumos/registrarse">Registrarse</a>
    </div>
    
</body>
</html>