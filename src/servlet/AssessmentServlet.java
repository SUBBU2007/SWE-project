package servlet;

import com.google.gson.Gson;
import dao.AssessmentDAO;
import model.Assessment;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/assessment")
public class AssessmentServlet extends HttpServlet {
    private AssessmentDAO assessmentDAO;
    private Gson gson;

    @Override
    public void init() {
        assessmentDAO = new AssessmentDAO();
        gson = new Gson();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userSymptoms = request.getParameter("symptoms");
        List<Assessment> allRules = assessmentDAO.getAllAssessmentRules();
        List<String> suggestions = allRules.stream()
                .filter(rule -> userSymptoms.toLowerCase().contains(rule.getSymptom().toLowerCase()))
                .map(Assessment::getSuggestion)
                .collect(Collectors.toList());

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(gson.toJson(suggestions));
    }
}
