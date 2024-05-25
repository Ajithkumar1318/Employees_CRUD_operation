
<%@ page import="dto.employees" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style type="text/css">
body{
	margin: 0px;
	height: 100%;
	width:100%;
	display: flex;
	align-items: center;
	justify-content:center;
	background-color: aqua;
	position: absolute;
}
.container{
background-color: pink;
height: 700px;
width:900px;
font-size: 20px;
display: flex;
align-items: center;
justify-content: center;
}
form{
display: flex;
align-items: center;
justify-content: center
}
td{
padding: 5px 10px;
width: 250px
}
span{
padding: 5px 10px;
width: 200px
}
tr:hover{
background-color:silver;

}
.btn:hover {
	background-color:white;
	height: 45px;
	width: 110px;
	border: solid black 2px
}
.btn{
border-radius: 5px;
border: none;
height: 40px;
width :100px;

}
input,.dropdown{
width: 350px;
height: 30px;
border-radius: 10px;
}
.table1{
cellspacing:0px;
padding: 0px;
}
.head{
display: flex;
align-items: center;
justify-content: center;
column-span: 2;
}
</style>
</head>
<body>
<%employees E=(employees)request.getAttribute("E"); %>

<div class="container" >
		<form action="updateEmployeeServlet" >
		<table cellspacing="0px" class="table">
		<tr>
		<td></td>
		<td  class="head" ><h1><u>Update</u></h1></td>
		</tr>
	
			<tr class="e_id">
				<td for="e_id">employee id:</td>
				<td><input type="number" placeholder="Id" name="e_id"  value="<%=E.getEmployee_id()%>"  readonly="readonly"></td>
			</tr>
			<tr class="e_name">
				<td for="e_name">employee Name:</td>
				<td><input type="text" placeholder="Name" name="e_name"  value="<%= E.getEmployee_name()%>"></td>
			</tr>
			<tr class="e_email">
				<td for="e_email">employee Email:</td>
				<td><input type="email" placeholder="Email" name="e_email" value="<%=E.getEmployee_email()%>"></td>
			</tr>
            <tr class="e_pass">
				<td for="e_pass">employee password:</td>
				<td><input type="password" placeholder="password" name="e_pass" value="<%=E.getEmployee_password()%>"></td>
			</tr>
			<tr class="e_phone">
				<td for="e_phone">employee phone:</td>
				<td><input type="number" placeholder="Phone number" name="e_phone" value="<%=E.getEmployee_phone_number()%>"></td>
			</tr>
			<tr class="e_dept">
				<td for="e_dept">employee department:</td>
				<td><select name="e_dept" placeholder="department" class="dropdown"  value="<%=E.getEmployee_department()%>">
					<option value="development">development</option>
					<option value="testing">testing</option>
				</select></td>
			</tr>
			<tr>
			<td >employee Skills:</td>
	       <td>
	       		 <table class="table1" cellpadding="0px" cellspacing="0px">
	       <tr>
	       <td><span>java</span></td>
	       <td> <input type="checkbox"   name="e_skills"  value="<%=E.getEmployee_skills()%>"></td>
	        </tr>
	        <tr>
	        <td><span>sql</span></td>
	        <td> <input type="checkbox" name="e_skills"  value="<%=E.getEmployee_skills()%>"></td>
	        </tr>
	        <tr>
	        <td><span>Html5</span></td>
	        <td><input type="checkbox"  name="e_skills"  value="<%=E.getEmployee_skills()%>"></td>
	        </tr>
	        <tr>
	        <td><span >css3</span></td>
	        <td><input type="checkbox" name="e_skills"  value="<%=E.getEmployee_skills()%>"></td>
	        </tr>
	        <tr>
	        <td><span>javascript</span></td>
	        <td><input type="checkbox"  name="e_skills"  value="<%=E.getEmployee_skills()%>"></td>
	        </tr>
	       </table>
	        </td>
	        </tr>
	        <tr>
	        <td></td>
	        <td><button class="btn" type="submit">sumbit</button></td>
	        </tr>
	        </table>
			
	</form>
	
	</div>

	

</body>
</html>