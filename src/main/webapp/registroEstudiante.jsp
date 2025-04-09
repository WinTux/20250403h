<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.wintux.jakarta.models.Carrera" %>
<!DOCTYPE html>
<html>
<head>
    <title>Registrar Estudiante</title>
</head>
<body>
    <h1>Registrar Estudiante</h1>

    <form action="RegistroEstudiante" method="post">
        <label for="matricula">Matrícula:</label><br>
        <input type="number" id="matricula" name="matricula" required><br><br>

        <label for="nombre">Nombre:</label><br>
        <input type="text" id="nombre" name="nombre" required><br><br>

        <label for="apellido">Apellido:</label><br>
        <input type="text" id="apellido" name="apellido" required><br><br>

        <label for="fechaNacimiento">Fecha de Nacimiento:</label><br>
        <input type="date" id="fechaNacimiento" name="fechaNacimiento"><br><br>

        <label for="email">Correo Electrónico:</label><br>
        <input type="email" id="email" name="email" required><br><br>

        <label for="password">Contraseña:</label><br>
        <input type="password" id="password" name="password" required><br><br>

        <label for="estado">Estado:</label><br>
        <select id="estado" name="estado">
            <option value="true">Activo</option>
            <option value="false">Inactivo</option>
        </select><br><br>
        <label for="carreraId">Carrera:</label>
        <select name="carreraId" required>
            <%
                List<Carrera> carreras = (List<Carrera>) request.getAttribute("carreras");
                if (carreras != null && !carreras.isEmpty()) {
                    for (Carrera c : carreras) {
            %>
                        <option value="<%= c.getCarreraID() %>"><%= c.getNombre() %> - Edificio: <%= c.getEdificio() %></option>
            <%
                    }
                } else {
            %>
                    <option disabled selected>No hay carreras disponibles</option>
            <%
                }
            %>
        </select><br/><br/>

        <input type="submit" value="Registrar" />
    </form>
</body>
</html>
