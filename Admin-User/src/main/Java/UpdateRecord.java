import DAO.EmployeeDaoImplementation;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/update")
public class UpdateRecord extends HttpServlet {
EmployeeDaoImplementation employeeDaoImplementation = new EmployeeDaoImplementation();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        String name = req.getParameter("name");
        String updated_name = req.getParameter("uname");

        ResultSet resultSet = employeeDaoImplementation.getEmployee(name);

        int id = 0;
        try{
            while (resultSet.next()) {
                if(name.equals(resultSet.getString(2))) {
                   id = resultSet.getInt(1);
                   break;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        int result = employeeDaoImplementation.updateEmployee(id, updated_name);

        if(result == 1) {
            resp.sendRedirect("AdminRecord.jsp");
        }
        else {
            RequestDispatcher rt1=req.getRequestDispatcher("UpdateRecord.jsp");
            rt1.include(req, resp);
        }
    }
    }

