package model;

import java.sql.Date;

public class Employee extends BaseModel{
	private int empID;
	private String empName;
	private Date empDOB;
	private String empPhone;
	private double empSalary;
	private String empGender;
	private String empAddress;
	private String empPosition;
	private Date empSWD;
	private int empStatus;
	private String empNote;
	private String empPassword;
	private String empRole;
	
	public Employee(int empID, String empName, Date empDOB, String empPhone, double empSalary, String empGender,
			String empAddress, String empPosition, Date empSWD, int empStatus, String empNote, String empPassword,
			String empRole) {
		super();
		this.empID = empID;
		this.empName = empName;
		this.empDOB = empDOB;
		this.empPhone = empPhone;
		this.empSalary = empSalary;
		this.empGender = empGender;
		this.empAddress = empAddress;
		this.empPosition = empPosition;
		this.empSWD = empSWD;
		this.empStatus = empStatus;
		this.empNote = empNote;
		this.empPassword = empPassword;
		this.empRole = empRole;
	}

	public Employee() {
		super();
	}

	public int getEmpID() {
		return empID;
	}

	public void setEmpID(int empID) {
		this.empID = empID;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Date getEmpDOB() {
		return empDOB;
	}

	public void setEmpDOB(Date empDOB) {
		this.empDOB = empDOB;
	}

	public String getEmpPhone() {
		return empPhone;
	}

	public void setEmpPhone(String empPhone) {
		this.empPhone = empPhone;
	}

	public double getEmpSalary() {
		return empSalary;
	}

	public void setEmpSalary(double empSalary) {
		this.empSalary = empSalary;
	}

	public String getEmpGender() {
		return empGender;
	}

	public void setEmpGender(String empGender) {
		this.empGender = empGender;
	}

	public String getEmpAddress() {
		return empAddress;
	}

	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}

	public String getEmpPosition() {
		return empPosition;
	}

	public void setEmpPosition(String empPosition) {
		this.empPosition = empPosition;
	}

	public Date getEmpSWD() {
		return empSWD;
	}

	public void setEmpSWD(Date empSWD) {
		this.empSWD = empSWD;
	}

	public int getEmpStatus() {
		return empStatus;
	}

	public void setEmpStatus(int empStatus) {
		this.empStatus = empStatus;
	}

	public String getEmpNote() {
		return empNote;
	}

	public void setEmpNote(String empNote) {
		this.empNote = empNote;
	}

	public String getEmpPassword() {
		return empPassword;
	}

	public void setEmpPassword(String empPassword) {
		this.empPassword = empPassword;
	}

	public String getEmpRole() {
		return empRole;
	}

	public void setEmpRole(String empRole) {
		this.empRole = empRole;
	}

	@Override
	public String toString() {
		return "Employee [empID=" + empID + ", empName=" + empName + ", empDOB=" + empDOB + ", empPhone=" + empPhone
				+ ", empSalary=" + empSalary + ", empGender=" + empGender + ", empAddress=" + empAddress
				+ ", empPosition=" + empPosition + ", empSWD=" + empSWD + ", empStatus=" + empStatus + ", empNote="
				+ empNote + ", empPassword=" + empPassword + ", empRole=" + empRole + "]";
	}
	
	
	
}
