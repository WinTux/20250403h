package com.wintux.jakarta.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.wintux.jakarta.dao.EstudianteDAO;
import com.wintux.jakarta.models.Estudiante;

/**
 * Servlet implementation class EstudianteController
 */
@WebServlet("/estudiantes")
public class EstudianteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EstudianteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EstudianteDAO dao = new EstudianteDAO();
		List<Estudiante> estudiantes = dao.obtenerTodosEst();
		request.setAttribute("ests", estudiantes);
		request
			.getRequestDispatcher("tablaEstudiantes.jsp")
			.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
