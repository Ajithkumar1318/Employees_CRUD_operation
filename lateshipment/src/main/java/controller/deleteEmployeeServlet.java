package controller;

import java.io.IOException;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.employeesDao;

@WebServlet("/deleteEmployeeServlet")
public class deleteEmployeeServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int employee_id=Integer.parseInt(req.getParameter("employee_id"));
		
		employeesDao dao=new employeesDao();
		
		dao.deleteByEmployee_Id(employee_id);
		
		req.getRequestDispatcher("viewEmployeeServlet").forward(req, resp);
	
	}

}
