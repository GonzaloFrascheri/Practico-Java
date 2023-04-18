package servlet;

import datatypes.DtProceso;
import jakarta.ejb.EJB;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/Listar")
public class Listar extends HttpServlet {


    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */

    @EJB
    logica.ControladorProcesoRemote cpr;

    public Listar(){
        super();
    }

    /**
     * @see HttpServlet#doGet(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response)
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
        List<DtProceso> dtp = cpr.getProcesos();

        if(dtp.size() > 0){
            RequestDispatcher rd;
            request.setAttribute("mensaje", dtp);
            rd = request.getRequestDispatcher("/Notificaciones.jsp");
            rd.forward(request, response);//Redirige solicitudes HTTP a otro recurso en el mismo servidor
        }
    }
}
