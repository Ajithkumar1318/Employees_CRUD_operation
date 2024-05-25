package dto;

public class employees {
	private int employee_id;
	private String employee_name;
	private String employee_email;
	private String employee_password;
	private long employee_phone_number;
	private String employee_department;
	private String employee_skills;
	
	public String getEmployee_password() {
		return employee_password;
	}
	public void setEmployee_password(String employee_password) {
		this.employee_password = employee_password;
	}
	
	public int getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}
	public String getEmployee_name() {
		return employee_name;
	}
	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}
	public String getEmployee_email() {
		return employee_email;
	}
	public void setEmployee_email(String employee_email) {
		this.employee_email = employee_email;
	}
	public long getEmployee_phone_number() {
		return employee_phone_number;
	}
	public void setEmployee_phone_number(long employee_phone_number) {
		this.employee_phone_number = employee_phone_number;
	}
	public String getEmployee_department() {
		return employee_department;
	}
	public void setEmployee_department(String employee_department) {
		this.employee_department = employee_department;
	}
	public String getEmployee_skills() {
		return employee_skills;
	}
	public void setEmployee_skills(String employee_skills) {
		this.employee_skills = employee_skills;
	}
}
