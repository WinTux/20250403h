<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Lista de Estudiantes</title>
</head>
<body>

<h2>Lista de Estudiantes Registrados</h2>

<c:if test="${not empty ests}">
    <table>
        <thead>
            <tr>
                <th>Matrícula</th>
                <th>Nombre</th>
                <th>Apellido</th>
                <th>Fecha Nacimiento</th>
                <th>Email</th>
                <th>Estado</th>
                <th>Carrera</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="est" items="${ests}">
                <tr>
                    <td>${est.matricula}</td>
                    <td>${est.nombre}</td>
                    <td>${est.apellido}</td>
                    <td>${est.fechaNacimiento}</td>
                    <td>${est.email}</td>
                    <td>
                        <c:choose>
                            <c:when test="${est.estado}">Activo</c:when>
                            <c:otherwise>Inactivo</c:otherwise>
                        </c:choose>
                    </td>
                    <c:set var="carrera" value="${est.carrera}" />
                    <td>
                        <c:choose>
                            <c:when test="${carrera != null}">
                                ${carrera.nombre}
                            </c:when>
                            <c:otherwise>Sin carrera</c:otherwise>
                        </c:choose>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</c:if>
<h3>Rango d estudiantes (60060,60070)</h3>
<c:if test="${empty ests}">
    <p style="text-align:center;">No hay estudiantes registrados.</p>
</c:if>

<c:if test="${not empty estsRango}">
    <table>
        <thead>
            <tr>
                <th>Matrícula</th>
                <th>Nombre</th>
                <th>Apellido</th>
                <th>Fecha Nacimiento</th>
                <th>Email</th>
                <th>Estado</th>
                <th>Carrera</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="est" items="${estsRango}">
                <tr>
                    <td>${est.matricula}</td>
                    <td>${est.nombre}</td>
                    <td>${est.apellido}</td>
                    <td>${est.fechaNacimiento}</td>
                    <td>${est.email}</td>
                    <td>
                        <c:choose>
                            <c:when test="${est.estado}">Activo</c:when>
                            <c:otherwise>Inactivo</c:otherwise>
                        </c:choose>
                    </td>
                    <c:set var="carrera" value="${est.carrera}" />
                    <td>
                        <c:choose>
                            <c:when test="${carrera != null}">
                                ${carrera.nombre}
                            </c:when>
                            <c:otherwise>Sin carrera</c:otherwise>
                        </c:choose>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</c:if>

</body>
</html>
