package servlet;

import com.google.gson.Gson;
import dao.SurgeonDAO;
import model.Surgeon;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/surgeon")
public class SurgeonServlet extends HttpServlet {
    private SurgeonDAO surgeonDAO;
    private Gson gson;

    @Override
    public void init() {
        surgeonDAO = new SurgeonDAO();
        gson = new Gson();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String specialty = request.getParameter("specialty");
        List<Surgeon> surgeons = surgeonDAO.getSurgeonsBySpecialty(specialty);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(gson.toJson(surgeons));
    }
}
