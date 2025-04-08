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
        <label for="nombre">Nombre:</label>
        <input type="text" name="nombre" required /><br/><br/>

        <label for="apellido">Apellido:</label>
        <input type="text" name="apellido" required /><br/><br/>

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
