package servlet;

import com.google.gson.Gson;
import dao.TestDAO;
import model.TestCost;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/test")
public class TestServlet extends HttpServlet {
    private TestDAO testDAO;
    private Gson gson;

    @Override
    public void init() {
        testDAO = new TestDAO();
        gson = new Gson();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String testName = request.getParameter("test_name");
        List<TestCost> testCosts = testDAO.getTestCostsByName(testName);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(gson.toJson(testCosts));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String testName = request.getParameter("test_name");
        String labName = request.getParameter("lab_name");
        double cost = Double.parseDouble(request.getParameter("cost"));
        boolean insurance = request.getParameter("insurance") != null;

        TestCost testCost = new TestCost();
        testCost.setTestName(testName);
        testCost.setLabName(labName);
        testCost.setCost(cost);
        testCost.setInsurance(insurance);

        testDAO.addTest(testCost);
        response.sendRedirect("admin/manage_tests.jsp");
    }
}
