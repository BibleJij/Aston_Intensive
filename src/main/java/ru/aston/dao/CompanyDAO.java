package ru.aston.dao;


import ru.aston.model.Company;
import ru.aston.util.DataConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CompanyDAO {

    private final DataConnection dataConnection;

    public CompanyDAO() {
        this.dataConnection = new DataConnection();
    }

    public Company createCompany(String name){
        Company company = new Company();
        String insert = "INSERT INTO Company(name) VALUES (?)";
        try(Connection connection = dataConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(insert, PreparedStatement.RETURN_GENERATED_KEYS);){
            preparedStatement.setString(1, name);
            preparedStatement.executeUpdate();
            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    company.setId(generatedKeys.getInt(1));
                }
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return company;
    }

    public List<Company> showAllCompany() {
        List<Company> companyList = new ArrayList<>();
        String select = "SELECT * FROM Company";
        try (Connection connection = dataConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(select);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                Company company = new Company(
                        resultSet.getInt("id"),
                        resultSet.getString("name")
                );
                companyList.add(company);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return companyList;
    }

    public void updateCompany(int id, String newName) {
        String insert = "UPDATE Department SET name_depart = ? WHERE id = ?";
        try (Connection connection = dataConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insert)) {
            preparedStatement.setString(1, newName);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteCompany(int id) {
        String delete = "DELETE FROM company WHERE id = ?";
        try (Connection connection = dataConnection.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(delete);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
