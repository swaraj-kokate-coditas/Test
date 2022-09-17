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

@WebServlet("/insert")
public class InsertRecord1 extends HttpServlet {
EmployeeDaoImplementation employeeDaoImplementation = new EmployeeDaoImplementation();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name1");
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        Employee employee = new Employee();
        employee.setId(id);
        employee.setName(name);
        employee.setUsername(username);
        employee.setPassword(password);

        int result = employeeDaoImplementation.insertEmployee(employee);
        System.out.println(req.getSession().getAttribute("name"));

        if(result == 1) {
            req.getRequestDispatcher("AdminRecord.jsp").forward(req, resp);
        }
        else {
            RequestDispatcher rt1=req.getRequestDispatcher("InsertRecord.jsp");
            rt1.include(req, resp);
        }

    }
}
