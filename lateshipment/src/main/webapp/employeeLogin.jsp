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
height: 350px;
width:500px;
font-size: 26px;
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
padding: 10px 20px;
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
input{
width: 300px;
height: 30px;
border-radius: 10px
}

</style>
</head>
<body>

<div >

<div class="container" >
	<form action="loginEmployeeServlet"  class="login">
        <table cellspacing="0px">
        <tr>
        <td colspan="2">
        <%
	String message=(String)request.getAttribute("msg");
	if(message!=null){
%>
<h1><%=message %></h1>
<%} %>
        </td>
        
        </tr>
		<tr>
			<td>Email:</td>
			<td><input type="email" placeholder="email" name="email"></td>
		</tr>
		<tr>
			<td>Password:</td>
			<td><input type="password" placeholder="password" name="pass"></td>
		</tr>
		<tr>
			
			<td><button type="submit" class="btn">submit</button>
			</form>
			</td>
			<td>
			<div>
				<form action="signin.jsp">
					<button type="submit" class="btn" >sign-up</button>
				</form>
			</div></td>
		</tr>
		
		</table>
	
</div>
	
</div>


</body>
</html>