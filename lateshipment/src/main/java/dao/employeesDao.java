package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;
import dto.employees;

public class employeesDao {
	static String classname = "com.mysql.cj.jdbc.Driver";
	static String dburl = "jdbc:mysql://localhost:3306/employees?user=root&password=root";

	public void saveEmployees(employees E) {

		try {
			Class.forName(classname);
			Connection c = DriverManager.getConnection(dburl);
			PreparedStatement ps = c.prepareStatement("insert into employees values (?,?,?,?,?,?,?)");
			ps.setInt(1, E.getEmployee_id());
			ps.setString(2, E.getEmployee_name());
			ps.setString(3, E.getEmployee_email());
			ps.setString(4, E.getEmployee_password());
			ps.setLong(5, E.getEmployee_phone_number());
			ps.setString(6, E.getEmployee_department());
			ps.setString(7, E.getEmployee_skills());

			ps.executeUpdate();
			c.close();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public employees fetchByEmail(String email) {
		try {
			Class.forName(classname);
			Connection c = DriverManager.getConnection(dburl);

			PreparedStatement ps = c.prepareStatement("select * from employees where employee_email=?");
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				employees E = new employees();

				E.setEmployee_id(rs.getInt("employee_id"));
				E.setEmployee_name(rs.getString("employee_name"));
				;
				E.setEmployee_email(rs.getString("employee_email"));
				E.setEmployee_password(rs.getString("employee_password"));
				E.setEmployee_phone_number(rs.getLong("employee_phone_number"));
				E.setEmployee_department(rs.getString("employee_department"));
				E.setEmployee_skills(rs.getString("employee_skills"));

				return E;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<employees> getAllemployees() {
		try {
			Class.forName(classname);
			Connection c = DriverManager.getConnection(dburl);
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery("select * from employees");
			ArrayList<employees> list = new ArrayList<employees>();

			while (rs.next()) {
				employees E = new employees();
				E.setEmployee_id(rs.getInt("employee_id"));
				E.setEmployee_name(rs.getString("employee_name"));
				E.setEmployee_email(rs.getString("employee_email"));
				E.setEmployee_password(rs.getString("employee_password"));
				E.setEmployee_phone_number(rs.getLong("employee_phone_number"));
				E.setEmployee_department(rs.getString("employee_department"));
				E.setEmployee_skills(rs.getString("employee_skills"));
				list.add(E);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public employees fetchByEmployee_Id(int employee_id) {
		try {
			Class.forName(classname);
			Connection c = DriverManager.getConnection(dburl);
			PreparedStatement ps = c.prepareStatement("select * from employees where employee_id=?");
			ps.setInt(1, employee_id);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				employees E = new employees();

				E.setEmployee_id(rs.getInt("employee_id"));
				E.setEmployee_name(rs.getString("employee_name"));
				E.setEmployee_email(rs.getString("employee_email"));
				E.setEmployee_password(rs.getString("employee_password"));
				E.setEmployee_phone_number(rs.getLong("employee_phone_number"));
				E.setEmployee_department(rs.getString("employee_department"));
				E.setEmployee_skills(rs.getString("employee_skills"));

				return E;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void updateEmployees(employees E) {
		try {
			Class.forName(classname);
			Connection c = DriverManager.getConnection(dburl);
			PreparedStatement ps = c.prepareStatement("update employees set employee_name=?,"
					+ "employee_email=?,employee_password=?,employee_phone_number=?,"
					+ "employee_department=?,employee_skills=? where employee_id=?");
			ps.setInt(7, E.getEmployee_id());
			ps.setString(1, E.getEmployee_name());
			ps.setString(2, E.getEmployee_email());
			ps.setString(3, E.getEmployee_password());
			ps.setLong(4, E.getEmployee_phone_number());
			ps.setString(5, E.getEmployee_department());
			ps.setString(6, E.getEmployee_skills());

			ps.executeUpdate();
			c.close();
			System.out.println("data updated");

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	public void deleteByEmployee_Id(int employee_id) {
		try {
			Class.forName(classname);
			Connection c = DriverManager.getConnection(dburl);
			PreparedStatement ps = c.prepareStatement("delete from employees where employee_id=? ");
			ps.setInt(1, employee_id);
			ps.executeUpdate();
			c.close();

			System.out.println("Data deleted");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean checkEmail(String  email) {

		try {
			Class.forName(classname);
			Connection c = DriverManager.getConnection(dburl);

			PreparedStatement ps = c.prepareStatement("select *   from   employees where employee_email = ?");
			ps.setString(1, email);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				return true;

			} else {
				return false;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return  false;
		}
		

	}
	
	public boolean checkEmployeeId(int employee_id) {
		try {
		Class.forName(classname);
		Connection c = DriverManager.getConnection(dburl);

		PreparedStatement ps = c.prepareStatement("select *   from   employees where employee_id = ?");
		ps.setInt(1, employee_id);

		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			return true;

		} else {
			return false;
		}

	} catch (Exception e) {
		e.printStackTrace();
		return  false;
	}
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	} 

}
