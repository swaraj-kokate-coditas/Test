import DAO.EmployeeDaoImplementation;
import Model.Employee;

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

@WebServlet("/index")
public class Front extends HttpServlet {
    EmployeeDaoImplementation employeeDaoImplementation = new EmployeeDaoImplementation();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        String username = req.getParameter("username");
        String password = req.getParameter("password");



        ResultSet resultSet = employeeDaoImplementation.getEmployees();
        HttpSession session = req.getSession();
        int flag = 0;
        if (username.equals("admin")) {
            if (password.equals("admin123")) {
                flag = 1;

                session.setAttribute("name", username);
                req.getRequestDispatcher("AdminRecord.jsp").forward(req, resp);
            }
        } else {
            try {
                while (resultSet.next()) {
                    if (username.equals(resultSet.getString(3))) {
                        if (password.equals(resultSet.getString(4))) {
                            flag = 1;

                            session.setAttribute("name", username);
                            RequestDispatcher requestDispatcher = req.getRequestDispatcher("Record.jsp");
                            requestDispatcher.forward(req, resp);
                            break;
                        }
                    }
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        if(flag == 0) {
            out.println("<h2 style = 'text-align : center;'>Invalid Username or Password</h2>");
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.jsp");
            requestDispatcher.include(req, resp);
        }
    }

}