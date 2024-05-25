package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.employeesDao;
import dto.employees;
@WebServlet("/viewEmployeeServlet")
public class viewEmployeeServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		employeesDao dao=new employeesDao();
		List<employees> list= dao.getAllemployees();
		req.setAttribute("list",list);
		req.getRequestDispatcher("viewEmployee.jsp").forward(req, resp);
		
	}
}
