package servlet;

import com.google.gson.Gson;
import dao.DonorDAO;
import model.Donor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/donor")
public class DonorServlet extends HttpServlet {
    private DonorDAO donorDAO;
    private Gson gson;

    @Override
    public void init() {
        donorDAO = new DonorDAO();
        gson = new Gson();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Donor> donors = donorDAO.getAllDonors();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(gson.toJson(donors));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String organ = request.getParameter("organ");

        Donor donor = new Donor();
        donor.setName(name);
        donor.setAge(age);
        donor.setOrgan(organ);

        donorDAO.registerDonor(donor);
        response.sendRedirect("organ.jsp?status=success");
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int donorId = Integer.parseInt(request.getParameter("id"));
        String status = request.getParameter("status");
        donorDAO.updateDonorStatus(donorId, status);
        response.setStatus(HttpServletResponse.SC_OK);
    }
}
