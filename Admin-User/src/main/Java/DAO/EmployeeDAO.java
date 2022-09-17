package DAO;

import Model.Employee;

import java.sql.ResultSet;

public interface EmployeeDAO {

    public int insertEmployee(Employee employee);
    public int deleteEmployee(int id);
    public ResultSet getEmployees();
    public ResultSet getEmployee(String username);
}
