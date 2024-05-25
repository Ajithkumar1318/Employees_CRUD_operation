package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.employeesDao;
import dto.employees;
@WebServlet("/updateEmployeeServlet")
public class updateEmployeeServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int employee_id=Integer.parseInt(req.getParameter("e_id"));
		String employee_name= req.getParameter("e_name");
		String employee_email =req.getParameter("e_email");
		String employee_password =req.getParameter("e_pass");
		Long employee_phone = Long.parseLong(req.getParameter("e_phone"));
		String employee_department=req.getParameter("e_dept");
		String employee_skills= req.getParameter("e_skills");
		
		String newSerializedSkills = String.join(",", employee_skills);
		
		employeesDao dao=new employeesDao();
		employees E=new employees();
		
		E.setEmployee_id(employee_id);
		E.setEmployee_name(employee_name);
		E.setEmployee_email(employee_email);
		E.setEmployee_password(employee_password);
		E.setEmployee_phone_number(employee_phone);
		E.setEmployee_department(employee_department);
		E.setEmployee_skills(newSerializedSkills);
		
		
		dao.updateEmployees(E);
		req.getRequestDispatcher("viewEmployeeServlet").forward(req, resp);
	}

}
