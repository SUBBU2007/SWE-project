package dao;

import model.Assessment;
import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AssessmentDAO {

    public List<Assessment> getAllAssessmentRules() {
        List<Assessment> rules = new ArrayList<>();
        String query = "SELECT * FROM assessment_rules";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Assessment rule = new Assessment();
                rule.setId(resultSet.getInt("id"));
                rule.setSymptom(resultSet.getString("symptom"));
                rule.setSuggestion(resultSet.getString("suggestion"));
                rules.add(rule);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rules;
    }
}
