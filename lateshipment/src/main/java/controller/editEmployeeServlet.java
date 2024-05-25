package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.employeesDao;
import dto.employees;
@WebServlet("/editEmployeeServlet")
public class editEmployeeServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int employee_id=Integer.parseInt(req.getParameter("employee_id"));
		employeesDao dao= new employeesDao();
		
			employees E=dao.fetchByEmployee_Id(employee_id);
			req.setAttribute("E", E);
			req.getRequestDispatcher("updateEmployee.jsp").forward(req, resp);
		
	}

}
