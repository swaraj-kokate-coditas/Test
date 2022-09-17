<%@page import="DAO.EmployeeDaoImplementation, java.sql.*,javax.servlet.http.HttpSession" %>

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
<%!

 %>
<%

String name = (String) session.getAttribute("name");

%>
<div class = "header" style = "background-color : black; color : white; padding : 20px;">
<h2 >Welcome <%= name%></h2>
<hr>
</div>

<%

if(name!=null) {
ResultSet resultSet = new EmployeeDaoImplementation().getEmployees();

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
                           %>
                           <br><br>
                           <div class = "Buttons" style = "width : 100%;">
                           <button style = "margin : 25px; width : 20%; padding : 20px; background-color : blue; "><a href = "InsertRecord.jsp" style = "color : white;">INSERT</a></button>
                           <button style = "margin : 25px; width : 20%; padding : 20px; background-color : brown; "><a href = "DeleteRecord.jsp" target = "_blank" style = "color : white;">DELETE</a>
                           <button style = "margin : 25px; width : 20%; padding : 20px; background-color : yellow; "><a href = "UpdateRecord.jsp" target = "_blank" style = "color : black;">UPDATE</a>
                           <button style = "background-color : red; margin : 25px; width : 20%; padding : 20px;"><a href = "Logout.jsp" style = "color : white;">LOGOUT</a></button>
  <%
                       } catch (SQLException e) {
                           throw new RuntimeException(e);
                       }
       } else {
             out.println("You Are New User");
       }
%>

</body>
</html>