package DAO;

import Model.Employee;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeDaoImplementation implements EmployeeDAO{

    public int insertEmployee(Employee employee) {
        String query = "insert into EmployeeTable(id, name, username, password) values(?, ?, ?, ?)";

        try{
            PreparedStatement preparedStatement = ConnectDatabase.connect().prepareStatement(query);
            preparedStatement.setInt(1,employee.getId());
            preparedStatement.setString(2,employee.getName());
            preparedStatement.setString(3,employee.getUsername());
            preparedStatement.setString(4,employee.getPassword());

            int result = preparedStatement.executeUpdate();
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int deleteEmployee(int id) {
        String query = "delete from EmployeeTable where id = ?";

        try{
            PreparedStatement preparedStatement = ConnectDatabase.connect().prepareStatement(query);
            preparedStatement.setInt(1,id);

            int result = preparedStatement.executeUpdate();

            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ResultSet getEmployees() {
        String query = "select * from EmployeeTable";

        try{
            PreparedStatement preparedStatement = ConnectDatabase.connect().prepareStatement(query);

            ResultSet resultSet = preparedStatement.executeQuery();

            return resultSet;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ResultSet getEmployee(String name) {
        String query = "select * from EmployeeTable where name = '" + name + "'";

        try{
            PreparedStatement preparedStatement = ConnectDatabase.connect().prepareStatement(query);

            ResultSet resultSet = preparedStatement.executeQuery();

            return resultSet;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int updateEmployee(int id ,String name) {
        String query = "update EmployeeTable set name = ? where id = ?";

        try{
            PreparedStatement preparedStatement = ConnectDatabase.connect().prepareStatement(query);

            preparedStatement.setString(1,name);
            preparedStatement.setInt(2,id);

            int result = preparedStatement.executeUpdate();
            return result;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
