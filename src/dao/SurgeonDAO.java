package dao;

import model.Surgeon;
import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SurgeonDAO {

    public List<Surgeon> getSurgeonsBySpecialty(String specialty) {
        List<Surgeon> surgeons = new ArrayList<>();
        String query = "SELECT * FROM surgeons WHERE specialty ILIKE ?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, "%" + specialty + "%");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Surgeon surgeon = new Surgeon();
                surgeon.setId(resultSet.getInt("id"));
                surgeon.setName(resultSet.getString("name"));
                surgeon.setSpecialty(resultSet.getString("specialty"));
                surgeon.setHospital(resultSet.getString("hospital"));
                surgeon.setLocation(resultSet.getString("location"));
                surgeon.setContact(resultSet.getString("contact"));
                surgeons.add(surgeon);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return surgeons;
    }
}
