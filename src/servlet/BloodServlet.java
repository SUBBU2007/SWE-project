package servlet;

import com.google.gson.Gson;
import dao.BloodDAO;
import model.BloodBank;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/blood")
public class BloodServlet extends HttpServlet {
    private BloodDAO bloodDAO;
    private Gson gson;

    @Override
    public void init() {
        bloodDAO = new BloodDAO();
        gson = new Gson();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String city = request.getParameter("city");
        String bloodGroup = request.getParameter("blood_group");
        List<BloodBank> bloodBanks = bloodDAO.getBloodStockByCityAndGroup(city, bloodGroup);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(gson.toJson(bloodBanks));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String hospital = request.getParameter("hospital");
        String city = request.getParameter("city");
        String bloodGroup = request.getParameter("blood_group");
        int units = Integer.parseInt(request.getParameter("units"));

        BloodBank bloodBank = new BloodBank();
        bloodBank.setHospital(hospital);
        bloodBank.setCity(city);
        bloodBank.setBloodGroup(bloodGroup);
        bloodBank.setUnits(units);

        bloodDAO.addBloodStock(bloodBank);
        response.sendRedirect("admin/manage_blood.jsp");
    }
}
