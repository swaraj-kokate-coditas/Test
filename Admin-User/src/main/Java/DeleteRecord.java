import DAO.EmployeeDaoImplementation;
import Model.Employee;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/delete")
public class DeleteRecord extends HttpServlet {
    EmployeeDaoImplementation employeeDaoImplementation = new EmployeeDaoImplementation();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        int id = Integer.parseInt(req.getParameter("id"));

        int result = employeeDaoImplementation.deleteEmployee(id);

        if(result > 0) {
            resp.sendRedirect("AdminRecord.jsp");
        }
        else {
            RequestDispatcher rt1=req.getRequestDispatcher("DeleteRecord.jsp");
            rt1.include(req, resp);
        }
    }
}
