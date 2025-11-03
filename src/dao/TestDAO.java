package dao;

import model.TestCost;
import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TestDAO {

    public List<TestCost> getTestCostsByName(String testName) {
        List<TestCost> testCosts = new ArrayList<>();
        String query = "SELECT * FROM lab_tests WHERE test_name ILIKE ?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, "%" + testName + "%");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                TestCost testCost = new TestCost();
                testCost.setId(resultSet.getInt("id"));
                testCost.setTestName(resultSet.getString("test_name"));
                testCost.setLabName(resultSet.getString("lab_name"));
                testCost.setCost(resultSet.getDouble("cost"));
                testCost.setInsurance(resultSet.getBoolean("insurance"));
                testCosts.add(testCost);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return testCosts;
    }

    public void addTest(TestCost testCost) {
        String query = "INSERT INTO lab_tests (test_name, lab_name, cost, insurance) VALUES (?, ?, ?, ?)";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, testCost.getTestName());
            statement.setString(2, testCost.getLabName());
            statement.setDouble(3, testCost.getCost());
            statement.setBoolean(4, testCost.isInsurance());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
