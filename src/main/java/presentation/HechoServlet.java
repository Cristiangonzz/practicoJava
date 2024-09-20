package presentation;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.*;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import bussines.Controllers.HechosControllerLocal;


@WebServlet(name = "HechoServlet", urlPatterns = {"/hechos"})
public class HechoServlet extends HttpServlet {

	@Inject
    private HechosControllerLocal hechosControllerLocal;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String descripcion = request.getParameter("description");
	    String fechaStr = request.getParameter("date");
	    String nivelExactitud = request.getParameter("nivelExactitud");

	    try {
	        Date fecha = new SimpleDateFormat("yyyy-MM-dd").parse(fechaStr);
	        Hecho hecho = new Hecho(descripcion, fecha, nivelExactitud);
	        hechosControllerLocal.agregarHecho(hecho);
	        response.sendRedirect(request.getContextPath() + "/index.jsp?success=true");
	    } catch (Exception e) {
	        response.sendRedirect(request.getContextPath() + "/index.jsp?error=true");
	    }
	}

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("hechos", hechosControllerLocal.obtenerHechos());
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
