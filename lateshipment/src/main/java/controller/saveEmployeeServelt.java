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
@WebServlet("/saveEmployees")
public class saveEmployeeServelt extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		employeesDao dao=new employeesDao();
		employees E=new employees();
		
			
			int employee_id=Integer.parseInt(req.getParameter("e_id"));
			String employee_name= req.getParameter("e_name");
			String employee_email =req.getParameter("e_email");
			Long employee_phone = Long.parseLong(req.getParameter("e_phone"));
			String employee_department=req.getParameter("e_dept");
			String[] employee_skills= req.getParameterValues("e_skills");
			String employee_passord =req.getParameter("e_pass");
			
			if(!dao.checkEmployeeId(employee_id)) {
			if(!dao.checkEmail(employee_email) ) {
			
			String serializedSkills = String.join(",", employee_skills);
		
			E.setEmployee_id(employee_id);
			E.setEmployee_name(employee_name);
			E.setEmployee_email(employee_email);
			E.setEmployee_phone_number(employee_phone);
			E.setEmployee_department(employee_department);
			E.setEmployee_skills(serializedSkills);
			E.setEmployee_password(employee_passord);
			
			dao.saveEmployees(E);
			res.getWriter().print("<h1>Data Saved</h1>");
			req.getRequestDispatcher("employeeLogin.jsp").forward(req, res);
			}else {
				req.setAttribute("msg","Email already exsit");
				
				RequestDispatcher dispatcher=req.getRequestDispatcher("signin.jsp");
				dispatcher.forward(req, res);
			}
			
		}
			else {
				req.setAttribute("msg"," id already exsit");
				
				RequestDispatcher dispatcher=req.getRequestDispatcher("signin.jsp");
				dispatcher.forward(req, res);
			}
			}
	
	}	
	
			
