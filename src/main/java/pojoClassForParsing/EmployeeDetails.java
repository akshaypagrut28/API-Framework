package pojoClassForParsing;

public class EmployeeDetails 
{
	//Step1 :- Declare the variable globally
	String eName;
	String id;
	int phoneNo;
	String address;
	String mailId;
	
	//Step 2 :- create a constructor for initialization
	public EmployeeDetails(String eName, String id, int phoneNo, String address, String mailId) 
	{
		this.eName = eName;
		this.id = id;
		this.phoneNo = phoneNo;
		this.address = address;
		this.mailId = mailId;
	}

	public EmployeeDetails()
	{
		
	}
	//Step 3 :- create getters and setters for utilization
	public String geteName() {
		return eName;
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

	public int getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(int phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMailId() {
		return mailId;
	}

	public void setMailId(String mailId) {
		this.mailId = mailId;
	}
	
	

}
