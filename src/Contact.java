
public class Contact {
	static final int CONTACT_PERSONAL_ID = 10;
	static final int FIRST_NAME_LENGTH = 10;
	static final int LAST_NAME_LENGTH = 10;
	static final int PHONE_LENGTH = 10;
	static final int ADDRESS_LENGTH = 30;
	
	private String contactID;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String address;
	
	public Contact(String ID, String fName, String lName, String phoneNum, String address) {
		setContactID(ID);
		setFirstName(fName);
		setLastName(lName);
		setPhoneNum(phoneNum);
		setAddress(address);
	}
	
	protected void setContactID(String IDString) {
		if(IDString == null) {
			throw new IllegalArgumentException("ID String cannot be empty");
		}
		else if (IDString.length() > CONTACT_PERSONAL_ID) {
			throw new IllegalArgumentException("ID String is " + (IDString.length()-CONTACT_PERSONAL_ID) + " character(s) too long");
		}
		else {
			this.contactID = IDString;
		}
	}
	
	protected void setFirstName(String fnString) {
		if(fnString == null) {
			throw new IllegalArgumentException("First name cannot be empty");
		}
		else if (fnString.length() > FIRST_NAME_LENGTH) {
			throw new IllegalArgumentException("First name is " + (fnString.length()-FIRST_NAME_LENGTH) + " character(s) too long");
		}
		else {
			this.firstName = fnString;
		}
	}
	
	protected void setLastName(String lnString) {
		if(lnString == null) {
			throw new IllegalArgumentException("Last name cannot be empty");
		}
		else if (lnString.length() > LAST_NAME_LENGTH) {
			throw new IllegalArgumentException("Last name is " + (lnString.length()-LAST_NAME_LENGTH) + " character(s) too long");
		}
		else {
			this.lastName = lnString;
		}
	}
	
	protected void setPhoneNum(String phoneNum) {
		if(phoneNum == null) {
			throw new IllegalArgumentException("Phone Number cannot be empty");
		}
		else if (phoneNum.length() != PHONE_LENGTH) {
			throw new IllegalArgumentException("Phone number must be " + PHONE_LENGTH + " characters long. No dashes(-)");
		}
		else {
			if(phoneNum.matches("[0-9]+"))
				this.phoneNumber = phoneNum;
			else
				throw new IllegalArgumentException("Phone number can only contain numbers. No dashes(-)");
		}
	}
	
	protected void setAddress(String adrsString) {
		if(adrsString == null) {
			throw new IllegalArgumentException("Address cannot be empty");
		}
		else if (adrsString.length() > ADDRESS_LENGTH) {
			throw new IllegalArgumentException("Last name is " + (adrsString.length()-ADDRESS_LENGTH) + " character(s) too long");
		}
		else {
			this.address = adrsString;
		}
	}
	
	
	public String getContactID() {return this.contactID;}
	
	public String getFirstName() {return this.firstName;}
	
	public String getLastName() {return this.lastName;}
	
	public String getPhoneNum() {return this.phoneNumber;}
	
	public String getAddress() {return this.address;}
	
}
