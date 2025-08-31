<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Página de Inicio</title>
    <link rel="stylesheet" type="text/css" href="/css/estilos.css">
</head>
<body>
    <div class="container">
        <h1>Bienvenido a la Aplicación</h1>
        <p>${mensaje}</p>

        <!-- Formulario de Login con Spring -->
        <form:form method="post" action="${pageContext.request.contextPath}/limpiaHumos/inicio/login" modelAttribute="usuarioLogin">
            <label for="nombre">Nombre:</label>
            <form:input path="nombre" id="nombre" required="required" />

            <label for="contraseña">Contraseña:</label>
            <form:password path="contraseña" id="contraseña" required="required" />

            <button type="submit">Iniciar Sesión</button>
        </form:form>

        <a href="${pageContext.request.contextPath}/limpiaHumos/registrarse">Registrarse</a>

        <c:if test="${not empty error}">
            <p style="color: red">${error}</p>
        </c:if>
    </div>
</body>
</html>
    