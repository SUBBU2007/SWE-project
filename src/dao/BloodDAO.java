package dao;

import model.BloodBank;
import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BloodDAO {

    public List<BloodBank> getBloodStockByCityAndGroup(String city, String bloodGroup) {
        List<BloodBank> bloodBanks = new ArrayList<>();
        String query = "SELECT * FROM blood_bank WHERE city = ? AND blood_group = ?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, city);
            statement.setString(2, bloodGroup);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                BloodBank bloodBank = new BloodBank();
                bloodBank.setId(resultSet.getInt("id"));
                bloodBank.setHospital(resultSet.getString("hospital"));
                bloodBank.setCity(resultSet.getString("city"));
                bloodBank.setBloodGroup(resultSet.getString("blood_group"));
                bloodBank.setUnits(resultSet.getInt("units"));
                bloodBanks.add(bloodBank);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bloodBanks;
    }

    public void addBloodStock(BloodBank bloodBank) {
        String query = "INSERT INTO blood_bank (hospital, city, blood_group, units) VALUES (?, ?, ?, ?)";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, bloodBank.getHospital());
            statement.setString(2, bloodBank.getCity());
            statement.setString(3, bloodBank.getBloodGroup());
            statement.setInt(4, bloodBank.getUnits());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
