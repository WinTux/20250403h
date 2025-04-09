package com.wintux.jakarta.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.wintux.jakarta.dao.CarreraDAO;
import com.wintux.jakarta.dao.EstudianteDAO;
import com.wintux.jakarta.models.Carrera;
import com.wintux.jakarta.models.Estudiante;

/**
 * Servlet implementation class RegistroEstudianteController
 */
@WebServlet("/RegistroEstudiante")
public class RegistroEstudianteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EstudianteDAO estudianteDAO = new EstudianteDAO();
    private CarreraDAO carreraDAO = new CarreraDAO();
    public RegistroEstudianteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Carrera> carreras = carreraDAO.obtenerTodasLasCarreras();
        request.setAttribute("carreras", carreras);
        RequestDispatcher dispatcher = request.getRequestDispatcher("registroEstudiante.jsp");
        dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int matricula = Integer.parseInt(request.getParameter("matricula"));
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String fechaNacimientoTxt = request.getParameter("fechaNacimiento");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        boolean estado = Boolean.parseBoolean(request.getParameter("estado"));
        int carreraId = Integer.parseInt(request.getParameter("carreraId"));

        java.sql.Date fechaNacimiento = null;
        if (fechaNacimientoTxt != null && !fechaNacimientoTxt.isEmpty()) {
            fechaNacimiento = java.sql.Date.valueOf(fechaNacimientoTxt);
        }
        Carrera carrera = carreraDAO.obtenerCarreraPorId(carreraId);

        Estudiante estudiante = new Estudiante();
        estudiante.setMatricula(matricula);
        estudiante.setNombre(nombre);
        estudiante.setApellido(apellido);
        estudiante.setFechaNacimiento(fechaNacimiento);
        estudiante.setEmail(email);
        estudiante.setPassword(password);
        estudiante.setEstado(estado);
        estudiante.setCarrera(carrera);

        estudianteDAO.guardarEst(estudiante);

        response.sendRedirect("RegistroEstudiante");// O a una nueva vista de tabla de estudiantes
	}

}
