package ru.aston.dao;



import ru.aston.model.Company;
import ru.aston.model.Employee;
import ru.aston.util.DataConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
    private final DataConnection dataConnection;

    public EmployeeDAO() {
        this.dataConnection = new DataConnection();
    }

    public Employee createEmployee(String name, int company_id){
        Employee employee = new Employee();
        String insert = "INSERT INTO Company(name, company_id) VALUES (?, ?)";
        try(Connection connection = dataConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(insert, PreparedStatement.RETURN_GENERATED_KEYS);){
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, company_id);
            preparedStatement.executeUpdate();
            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    employee.setId(generatedKeys.getInt(1));
                }
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return employee;
    }

    public List<Employee> showAllEmployee() {
        List<Employee> employeeList = new ArrayList<>();
        String select = "SELECT * FROM Department";
        try (Connection connection = dataConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(select);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                int companyId = resultSet.getInt("company_id");
                Company company = getCompanyById(companyId);
                Employee employee = new Employee(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        company
                );
                employeeList.add(employee);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return employeeList;
    }

    public void updateDepartment(int id, String newName) {
        String insert = "UPDATE department SET name_depart = ? WHERE id = ?";
        try (Connection connection = dataConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insert)) {
            preparedStatement.setString(1, newName);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteDepartment(int id) {
        String delete = "DELETE FROM department WHERE id = ?";
        try (Connection connection = dataConnection.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(delete);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Company getCompanyById(int companyId) {
        String insert = "SELECT * FROM Company WHERE id = ?";
        Company company = new Company();
        try (Connection connection = dataConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insert)) {
            preparedStatement.setInt(1, companyId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                company = new Company(
                        resultSet.getInt("id"),
                        resultSet.getString("name")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return company;
    }
}
