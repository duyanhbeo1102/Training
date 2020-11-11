package DAL;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.Employee;

public class EmployeeDAO extends BaseDAO<Employee>{

	@Override
	public ArrayList<Employee> all() {
		ArrayList<Employee> employees = new ArrayList<>();
		String query = "{ call GET_ALL_EMP }";
		ResultSet rs;
		try {
			CallableStatement stsm = connection.prepareCall(query);
			rs = stsm.executeQuery();
			while(rs.next()) {
				Employee emp = new Employee();
				emp.setEmpID(rs.getInt("EMP_ID"));
				emp.setEmpPassword(rs.getString("EMP_PASSWORD"));
				System.out.println();
				employees.add(emp);
				
				}
		}
		catch (SQLException e) {
			Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, e);
		}
		return employees;
	}

	@Override
	public Employee get(int id) {
		return null;
	}
	
	public Employee getEmpAccount(int id, String password) {
		Employee emp = new Employee();
		String query = "{ call GET_EMP_ACCOUNT(?,?) }";
		ResultSet rs;
		try {
			CallableStatement stsm = connection.prepareCall(query);
			stsm.setInt(1, id);
			stsm.setString(2, password);
			rs = stsm.executeQuery();
			if(rs.next()) {
				emp.setEmpID(rs.getInt("EMP_ID"));
				emp.setEmpPassword(rs.getString("EMP_PASSWORD"));
				emp.setEmpRole(rs.getString("EMP_ROLE"));
				}
		}
		catch (SQLException e) {
			Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, e);
		}
		finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return emp;
	}
	@Override
	public void insert(Employee model) {
		// TODO Auto-generated method stub
		
	}
	
}
