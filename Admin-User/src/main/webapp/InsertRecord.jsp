<html>
<head>
<style>
body {
margin : 0px;
}
</style>
</head>
<body>

<div class = "header" style = "background-color : black; color : white; padding : 15px; text-align : center;">
<h2 >ADD RECORD</h2>
<hr>
</div>
<%
System.out.println(session.getAttribute("name"));
%>
<br><br>
<div align = "center">
<form action = "insert" >
<input type = "number" placeholder = "Enter id" name = "id" style = "padding : 10px; width : 35%;"/><br><br>
<input type = "text" placeholder = "Enter name" name = "name1" style = "padding : 10px; width : 35%;"/><br><br>
<input type = "text" placeholder = "Enter username" name = "username" style = "padding : 10px; width : 35%;"/><br><br>
<input type = "password" placeholder = "Enter password" name = "password" style = "padding : 10px; width : 35%;"/><br><br>
<input type = "submit" value = "ADD EMPLOYEE" style = "padding : 10px; width : 25%;">
</form>
</div>
</body>
</html>