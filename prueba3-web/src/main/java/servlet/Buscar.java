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

@WebServlet("/Buscar")
public class Buscar extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */

    @EJB
    logica.ControladorProcesoRemote cpr;

    public Buscar(){
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
        int id = Integer.parseInt(request.getParameter("id"));

        DtProceso dtp = cpr.buscarProceso(id);

        if(dtp != null){
            RequestDispatcher rd;
            request.setAttribute("mensaje", dtp);
            rd = request.getRequestDispatcher("/Notificaciones.jsp");
            rd.forward(request,response);
        }else{
            RequestDispatcher rd;
            request.setAttribute("mensaje", "Lo sentimos, no encontramos ese Proceso");
            rd = request.getRequestDispatcher("/Notificaciones.jsp");
            rd.forward(request, response);
        }
    }
}
