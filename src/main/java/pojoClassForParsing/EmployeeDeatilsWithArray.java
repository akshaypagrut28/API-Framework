package pojoClassForParsing;

public class EmployeeDeatilsWithArray 
{
	//Declare
	String eName;
	String id;
	int[] phoneNo;
	int salary;
	String[] mailId;
	Object SpouseDetails;
	//constructor
	public EmployeeDeatilsWithArray(String eName, String id, int[] phoneNo, int salary, String[] mailId, Object spouseDetails) 
	{
		super();
		this.eName = eName;
		this.id = id;
		this.phoneNo = phoneNo;
		this.salary = salary;
		this.mailId = mailId;
		SpouseDetails = spouseDetails;
	}

	public EmployeeDeatilsWithArray() 
	{
		
	}
	//create getters and setters
	
	public String geteName() {
		return eName;
	}

	public Object getSpouseDetails() {
		return SpouseDetails;
	}

	public void setSpouseDetails(Object spouseDetails) {
		SpouseDetails = spouseDetails;
	}

	public void seteName(String eName) {
		this.eName = eName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int[] getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(int[] phoneNo) {
		this.phoneNo = phoneNo;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String[] getMailId() {
		return mailId;
	}

	public void setMailId(String[] mailId) {
		this.mailId = mailId;
	}
	
	
	
}
