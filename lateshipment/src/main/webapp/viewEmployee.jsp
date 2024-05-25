<%@page import="dto.employees" %>
<%@page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
th{
background-color: lime;
}
</style>
</head>
<body>
<% 
List<employees> list=(List<employees>)request.getAttribute("list");
String msg=(String)request.getAttribute("msg");
%>
<table border="2px" cellspacing="0px" cellpadding="2px">
<tr>
	<th>EMPLOYEE_ID</th>
	<th>EMPLOYEE_NAME</th>
	<th>EMPLOYEE_EMAIL</th>
	<th>EMPLOYEE_PASSWORD</th>
	<th>EMPLOYEE_PHONE</th>
	<th>EMPLOYEE_DEPARTMENT</th>
	<th>EMPLOYEE_SKILLS</th>
	<th>DELETE</th>
	<th>EDIT</th>
</tr>
<tr>
	
	<%for(employees E:list){ %>

<td><%=E.getEmployee_id() %></td>
<td><%=E.getEmployee_name() %></td>
<td><%=E.getEmployee_email()%></td>
<td><%=E.getEmployee_password()%></td>
<td><%=E.getEmployee_phone_number()%></td>
<td><%=E.getEmployee_department()%></td>
<td><%=E.getEmployee_skills()%></td>
<td> <a href="editEmployeeServlet?employee_id=<%= E.getEmployee_id()%>">edit</a></td>
<td> <a href="deleteEmployeeServlet?employee_id=<%=E.getEmployee_id()%>">delete</a></td>
</tr>
<%} %>
</table>




</body>
</html>