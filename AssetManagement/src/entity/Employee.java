package entity;

public class Employee {

	private static long employeeId = 2200;
	long id;
	String contactNumber;
	String name;
	String username;
	String role;
	String email;
	String password;
	float amount_due;
	char borrowing_allowed;

	public Employee(long id, String contactNumber, String name, String role, String email, String password,
			float amount_due, char borrowing_allowed, String username) {
		super();
		this.id = id;
		this.contactNumber = contactNumber;
		this.name = name;
		this.role = role;
		this.email = email;
		this.password = password;
		this.amount_due = amount_due;
		this.borrowing_allowed = borrowing_allowed;
		this.username = username;
	}

	public Employee(String contactNumber, String name, String role, String email, String password, float amount_due,
			char borrowing_allowed, String username) {
		super();
		this.contactNumber = contactNumber;
		this.name = name;
		this.role = role;
		this.email = email;
		this.password = password;
		this.amount_due = amount_due;
		this.borrowing_allowed = borrowing_allowed;
		this.id = generateId();
		this.username = username;
	}

	public Employee(String contactNumber, String name, String role, String email, String password,String username) {
		super();
		this.contactNumber = contactNumber;
		this.name = name;
		this.role = role;
		this.email = email;
		this.password = password;
		this.id = generateId();
		this.username = username;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public float getAmount_due() {
		return amount_due;
	}

	public void setAmount_due(float amount_due) {
		this.amount_due = amount_due;
	}

	public char getBorrowing_allowed() {
		return borrowing_allowed;
	}

	public void setBorrowing_allowed(char borrowing_allowed) {
		this.borrowing_allowed = borrowing_allowed;
	}

	private long generateId() {
		Employee.employeeId++;
		return Employee.employeeId;
	}

	public Employee() {
	}

}