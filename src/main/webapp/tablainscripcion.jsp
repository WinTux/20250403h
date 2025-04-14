<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Inscripciones</title>
</head>
<body>
    <h1>Lista de Inscripciones</h1>
    
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Fecha</th>
                <th>Calificación</th>
                <th>Asignatura</th>
                <th>Estudiante</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${inscripciones}" var="insc">
                <tr>
                    <td>${insc.inscripcionID}</td>
                    <td>${insc.fechaInscripcion}</td>
                    <td>${insc.calificacion}</td>
                    <td>${insc.asig.sigla}</td>
                    <td>${insc.est.nombre} ${insc.est.apellido}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    
    <div class="form-section">
        <h2>Consultas Especiales</h2>
        <form method="post">
            <label for="consulta">Seleccione consulta:</label>
            <select id="consulta" name="consulta" onchange="mostrarInput(this.value)">
                <option value="">-- Seleccione --</option>
                <option value="uso de like">Uso de LIKE</option>
                <option value="uso de ordenamiento">Uso de ordenamiento</option>
                <option value="uso de seleccion where">Uso de selección WHERE</option>
                <option value="consulta sobre fechas">Consulta sobre fechas</option>
                <option value="uso de sum">Uso de SUM</option>
                <option value="uso de count">Uso de COUNT</option>
                <option value="uso de max y min">Uso de MAX y MIN</option>
                <option value="uso de avg">Uso de AVG</option>
                <option value="uso de proyección">Uso de proyección</option>
            </select>
            
            <div id="inputContainer" style="margin-top: 10px; display: none;">
                <label for="valor">Valor:</label>
                <input type="text" id="valor" name="valor">
            </div>
            
            <button type="submit" style="margin-top: 10px;">Ejecutar Consulta</button>
        </form>
    </div>
    
    <c:if test="${not empty resultadoConsulta}">
        <h2>Resultado de: ${tipoConsulta}</h2>
        <table>
            <c:choose>
                <c:when test="${tipoConsulta == 'uso de sum' || tipoConsulta == 'uso de count' || tipoConsulta == 'uso de avg'}">
                    <tr>
                        <th>Resultado</th>
                    </tr>
                    <tr>
                        <td>${resultadoConsulta}</td>
                    </tr>
                </c:when>
                
                <c:when test="${tipoConsulta == 'uso de max y min'}">
                    <tr>
                        <th>Máximo</th>
                        <th>Mínimo</th>
                    </tr>
                    <tr>
                        <td>${resultadoConsulta[0]}</td>
                        <td>${resultadoConsulta[1]}</td>
                    </tr>
                </c:when>
                
                <c:when test="${tipoConsulta == 'uso de proyección'}">
                    <tr>
                        <th>Fecha</th>
                        <th>Calificación</th>
                    </tr>
                    <c:forEach items="${resultadoConsulta}" var="proj">
                        <tr>
                            <td>${proj[0]}</td>
                            <td>${proj[1]}</td>
                        </tr>
                    </c:forEach>
                </c:when>
                
                <c:otherwise>
                    <tr>
                        <th>ID</th>
                        <th>Fecha</th>
                        <th>Calificación</th>
                        <th>Asignatura</th>
                        <th>Estudiante</th>
                    </tr>
                    <c:forEach items="${resultadoConsulta}" var="insc">
                        <tr>
                            <td>${insc.inscripcionID}</td>
                            <td>${insc.fechaInscripcion}</td>
                            <td>${insc.calificacion}</td>
                            <td>${insc.asig.sigla}</td>
                            <td>${insc.est.nombre} ${insc.est.apellido}</td>
                        </tr>
                    </c:forEach>
                </c:otherwise>
            </c:choose>
        </table>
    </c:if>
    
    <script>
        function mostrarInput(consulta) {
            const inputContainer = document.getElementById('inputContainer');
            const necesitaInput = [
                'uso de like', 
                'uso de seleccion where', 
                'consulta sobre fechas'
            ].includes(consulta);
            
            if (necesitaInput) {
                inputContainer.style.display = 'block';
            } else {
                inputContainer.style.display = 'none';
            }
        }
    </script>
</body>
</html>