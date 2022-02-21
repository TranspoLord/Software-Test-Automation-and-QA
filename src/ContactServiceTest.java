import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class ContactServiceTest {
	
	//Confirms the adding of a contact
	@Test
	public void testContactService() {
		ContactService contacts = new ContactService();
		Contact testContact = contacts.newContact("John", "Doe","5554447777","123 Main St. MA 12345");
		assertNotNull(testContact);
		
		assertTrue(ContactService.ContactSearch(testContact.getContactID()).getFirstName().equals("John"));		
		assertTrue(ContactService.ContactSearch(testContact.getContactID()).getLastName().equals("Doe"));
		assertTrue(ContactService.ContactSearch(testContact.getContactID()).getPhoneNum().equals("5554447777"));
		assertTrue(ContactService.ContactSearch(testContact.getContactID()).getAddress().equals("123 Main St. MA 12345"));
	}
	
	//Confirms the removal of an entry
	@Test
	public void testContactServiceRemove() {
		ContactService contacts = new ContactService();
		Contact testContact = contacts.newContact("John", "Doe","5554447777","123 Main St. MA 12345");
		assertNotNull(testContact);
		
		contacts.deleteContact(ContactService.ContactSearch(testContact.getContactID()).getContactID());
		assertNull(ContactService.ContactSearch(testContact.getContactID()));
	}
	
	//Confirms update to first name
	@Test
	public void testContactServiceSetFirstName() {
		ContactService contacts = new ContactService();
		Contact testContact = contacts.newContact("John", "Doe","5554447777","123 Main St. MA 12345");
		assertNotNull(testContact);
		try {
			contacts.updateFirstName(testContact.getContactID(), "New Name");
			
			Contact contactFound = ContactService.ContactSearch(testContact.getContactID());
			assertNotNull(contactFound);
			
			assertEquals(contactFound.getFirstName(), "New Name");
		} catch (Exception e) {
			fail();
		}		
	}
	
	//Confirms update to last name
	@Test
	public void testContactServiceSetLastName() {
		ContactService contacts = new ContactService();
		Contact testContact = contacts.newContact("John", "Doe","5554447777","123 Main St. MA 12345");
		assertNotNull(testContact);
		try {
			contacts.updateLastName(testContact.getContactID(), "New Name");
			
			Contact contactFound = ContactService.ContactSearch(testContact.getContactID());
			assertNotNull(contactFound);
			
			assertEquals(contactFound.getLastName(), "New Name");
		} catch (Exception e) {
			fail();
		}
	}
	
	//Confirms update to phone
	@Test
	public void testContactServiceSetPhone() {
		ContactService contacts = new ContactService();
		Contact testContact = contacts.newContact("John", "Doe","5554447777","123 Main St. MA 12345");
		assertNotNull(testContact);
		try {
			contacts.updatePhone(testContact.getContactID(), "6664448888");
			
			Contact contactFound = ContactService.ContactSearch(testContact.getContactID());
			assertNotNull(contactFound);
			
			assertEquals(contactFound.getPhoneNum(), "6664448888");
		} catch (Exception e) {
			fail();
		}
	}
	
	//Confirms update to address
	@Test
	public void testContactServiceSetAddress() {
		ContactService contacts = new ContactService();
		Contact testContact = contacts.newContact("John", "Doe","5554447777","123 Main St. MA 12345");
		assertNotNull(testContact);
		try {
			contacts.updateAddress(testContact.getContactID(), "New address");
			
			Contact contactFound = ContactService.ContactSearch(testContact.getContactID());
			assertNotNull(contactFound);
			
			assertEquals(contactFound.getAddress(), "New address");
		} catch (Exception e) {
			fail();
		}
	}
}