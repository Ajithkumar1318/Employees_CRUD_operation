package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.employeesDao;
import dto.employees;

@WebServlet("/loginEmployeeServlet")
public class loginEmployeeServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String email=req.getParameter("email");
		String pass=req.getParameter("pass");
		
		employeesDao dao=new employeesDao();
		employees E=dao.fetchByEmail(email);
		if(E!=null) {
			if (E.getEmployee_password().equals(pass)) {
				req.setAttribute("msg", "login succesful");
				req.getRequestDispatcher("viewEmployeeServlet").forward(req, res);
				}
			else {
				req.setAttribute("msg","Incorrect Password");
				
			 req.getRequestDispatcher("employeeLogin.jsp").forward(req, res); ;
				
			}
		}
		else {
			req.setAttribute("msg","Email not found please sign up first");
			
			RequestDispatcher dispatcher=req.getRequestDispatcher("employeeLogin.jsp");
			dispatcher.forward(req, res);
		}
		
	}
}
