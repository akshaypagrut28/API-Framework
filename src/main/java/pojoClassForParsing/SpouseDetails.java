package pojoClassForParsing;

public class SpouseDetails 
{
	String sName;
	String id;
	int[] phoneNo;
	String address;
	
	public SpouseDetails(String sName, String id, int[] phoneNo, String address) 
	{
		this.sName = sName;
		this.id = id;
		this.phoneNo = phoneNo;
		this.address = address;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	

}
