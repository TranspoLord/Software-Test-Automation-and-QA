import java.util.ArrayList;
import java.util.List;

public class ContactService {
	private int currentID = 0;
	private static List<Contact> contactList = new ArrayList<>();
	
	public static Contact ContactSearch(String contactID) {
		Contact contactToReturn = null;
		try {
			contactToReturn = contactList.stream().filter(contact -> contact.getContactID() == contactID).findFirst().get();
		} catch (Exception e) {
			return contactToReturn;
		}
		return contactToReturn;
	}
	
	private String getNewID() {
		currentID++;
		return String.valueOf(currentID);
	}
	
	public Contact newContact(String firstn, String lastn, String phoneNumber, String address) {
		Contact contact = new Contact(getNewID(), firstn, lastn, phoneNumber, address);
		ContactService.contactList.add(contact);
		return contact;
	}
	
	public void deleteContact(String contactID) {
		if(ContactSearch(contactID) != null) {
			ContactService.contactList.remove(ContactSearch(contactID));
		}
	}
	
	public void updateFirstName(String contactID, String name) {
		ContactSearch(contactID).setFirstName(name);
	}
	
	public void updateLastName(String contactID, String name) {
		ContactSearch(contactID).setLastName(name);
	}
	
	public void updatePhone(String contactID, String phone) {
		ContactSearch(contactID).setPhoneNum(phone);
	}
	
	public void updateAddress(String contactID, String address) {
		ContactSearch(contactID).setAddress(address);
	}
}
