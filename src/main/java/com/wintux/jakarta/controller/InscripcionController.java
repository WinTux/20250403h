package com.wintux.jakarta.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import com.wintux.jakarta.dao.InscripcionDAO;
import com.wintux.jakarta.models.Inscripcion;

/**
 * Servlet implementation class InscripcionController
 */
@WebServlet("/inscripcion")
public class InscripcionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	InscripcionDAO inscripcionDAO;
    public InscripcionController() {
        super();
        inscripcionDAO = new InscripcionDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Inscripcion> inscripciones = inscripcionDAO.obtenerTodas();
        request.setAttribute("inscripciones", inscripciones);
        request.getRequestDispatcher("tablainscripcion.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String consulta = request.getParameter("consulta");
        String valor = request.getParameter("valor");
        
        // Primera tabla
        List<Inscripcion> inscripciones = inscripcionDAO.obtenerTodas();
        request.setAttribute("inscripciones", inscripciones);
        
        // Procesar la consulta seleccionada
        Object resultadoConsulta = procesarConsulta(consulta, valor);
        request.setAttribute("resultadoConsulta", resultadoConsulta);
        request.setAttribute("tipoConsulta", consulta);
        
        request.getRequestDispatcher("tablainscripcion.jsp").forward(request, response);
	}
	private Object procesarConsulta(String consulta, String valor) {
        switch (consulta) {
            case "uso de like":
                return inscripcionDAO.buscarPorNombreEstudiante(valor);
                
            case "uso de ordenamiento":
                return inscripcionDAO.obtenerOrdenadasPorFecha();
                
            case "uso de seleccion where":
                return inscripcionDAO.filtrarPorCalificacionMinima(new BigDecimal(valor));
                
            case "consulta sobre fechas":
                // Implementar según necesidades específicas de fechas
                return inscripcionDAO.obtenerTodas();
                
            case "uso de sum":
                return inscripcionDAO.obtenerSumaCalificaciones();
                
            case "uso de count":
                return inscripcionDAO.contarInscripciones();
                
            case "uso de max y min":
                return inscripcionDAO.obtenerMaxMinCalificaciones();
                
            case "uso de avg":
                return inscripcionDAO.obtenerPromedioCalificaciones();
                
            case "uso de proyección":
                return inscripcionDAO.obtenerProyeccionFechasCalificaciones();
                
            default:
                return null;
        }
    }

}
