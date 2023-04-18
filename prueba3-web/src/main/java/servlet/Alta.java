package servlet;

import datatypes.DtProceso;
import excepciones.ProcesoRepetido;
import jakarta.ejb.EJB;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.awt.Color;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/Alta")
public class Alta extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */

    @EJB
    logica.ControladorProcesoRemote cpr;

    //@EJB(lookup = "ejb:prueba3/prueba3-ejb/ControladorProceso!logica.ControladorProcesoRemote")
    //logica.ControladorProcesoRemote cpr;

    public Alta() { super(); }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt((request.getParameter("id")));
        String descripcion = request.getParameter("descripcion");

        DtProceso dtp = new DtProceso(id, descripcion);

        try {
            cpr.agregarProceso(dtp);
        }catch (ProcesoRepetido e) {
            request.setAttribute("mensaje", "Ya existe un Proceso con ID: " + id);
        }

        RequestDispatcher rd;
        request.setAttribute("mensaje", "Se agrego el id " + id + " correctamente.");
        rd = request.getRequestDispatcher("/Notificaciones.jsp");
        rd.forward(request,response);
    }
}
