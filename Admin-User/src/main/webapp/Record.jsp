<%@page import="DAO.EmployeeDaoImplementation,java.sql.*" %>

<html>
<head>
<style>
th,td {
padding : 20px;
text-align : center;
}
body {
margin : 0px;
}
</style>
</head>
<body>

<%
String name = (String) session.getAttribute("name");
ResultSet resultSet = new EmployeeDaoImplementation().getEmployee(name);
%>
<div class = "header" style = "background-color : black; color : white; padding : 20px;">
<h2 >Welcome <%= name %></h2>
<hr>
</div>

<%
        out.println("<table border = '5' style = 'width : 100%;'margin : 20px>");
                out.println("<tr>");
                out.println("<th colspan = '4'>ID</th>");
                out.println("<th colspan = '4'>NAME</th>");
                out.println("<th colspan = '4'>USERNAME</th>");
                out.println("</tr>");
                try {
                    while(resultSet.next()) {
                        out.println("<tr><td colspan = '4'>" + resultSet.getInt(1) + "</td><td colspan = '4'>" + resultSet.getString(2) +
                        "</td><td colspan = '4'>" + resultSet.getString(3) + "</td></tr>");
                    }
                    out.println("</table>");
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
%>
<br><br>
<button style = "background-color : red; margin : 10px; padding : 10px; width : 25%;"><a href = "Logout.jsp" style = "color : white;">LOGOUT</a></button>
</body>
</html>