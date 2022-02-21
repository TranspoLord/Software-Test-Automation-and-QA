import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class ContactTest {
	
	//Confirms the creation of a contact
	@Test
	public void testContactClass() {
		Contact newContact = new Contact("123", "John", "Doe", "5556667777", "123 Main St. Example, MA 12345");
		assertTrue(newContact.getFirstName().equals("John"));
		assertTrue(newContact.getLastName().equals("Doe"));
		assertTrue(newContact.getContactID().equals("123"));
		assertTrue(newContact.getPhoneNum().equals("5556667777"));
		assertTrue(newContact.getAddress().equals("123 Main St. Example, MA 12345"));
	}
	
	//Tests ID long exception
	@Test
	public void testContactIDTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345678910","John","Smith","5556667777","123 Main St. Example, MA 12345");
		});
	}
	
	//Tests ID null exception
	@Test
	public void testContactIDNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(null,"John","Smith","5556667777","123 Main St. Example, MA 12345");
		});
	}
	
	//Tests first name to long catch
	@Test
	public void testFirstNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234567891","John5678910","Smith","5556667777","123 Main St. Example, MA 12345");
		});
	}
	
	//Tests first name null catch
	@Test
	public void testFirstNameNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234567891", null, "Smith","5556667777","123 Main St. Example, MA 12345");
		});
	}
	
	//Tests last name too long catch
	@Test
	public void testLastNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234567891","John","Smith678910","5556667777","123 Main St. Example, MA 12345");
		});
	}
	
	//Tests last name null catch
	@Test
	public void testLastNameNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234567891", "John", null,"5556667777","123 Main St. Example, MA 12345");
		});
	}
	
	//Tests phone number not 10 digits catch
	@Test
	public void testPhoneNot10() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234567891","John","Smith","55566677771","123 Main St. Example, MA 12345");
		});
	}
	
	//Tests phone null catch
	@Test
	public void testPhoneNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234567891", "John", "Smith", null,"123 Main St. Example, MA 12345");
		});
	}
	
	//Tests address too long catch
	@Test
	public void testAddressTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234567891","John","Smith","5556667777","123 Main St. Example, MA 12345 1234567");
		});
	}
	
	//Tests address null catch
	@Test
	public void testAddressNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234567891", null, "Smith","5556667777",null);
		});
	}
	
	//Tests the catches for the update to first name
	@Test
	public void testSetFirstName() {
		Contact newContact = new Contact("1234567891","John","Smith","5556667777","123 Main St. Example, MA 12345");
		newContact.setFirstName("Jared");
		assertTrue(newContact.getFirstName().equals("Jared"));
	}
	
	@Test
	public void testSetFirstNameLong() {
		Contact newContact = new Contact("1234567891","John","Smith","5556667777","123 Main St. Example, MA 12345");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			newContact.setFirstName("Jared678910");
		});
	}
	
	@Test
	public void testSetFirstNameNull() {
		Contact newContact = new Contact("1234567891","John","Smith","5556667777","123 Main St. Example, MA 12345");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			newContact.setFirstName(null);
		});
	}
	
	//Tests the catches for the update to last name
	@Test
	public void testSetLastName() {
		Contact newContact = new Contact("1234567891","John","Smith","5556667777","123 Main St. Example, MA 12345");
		newContact.setLastName("Doe");
		assertTrue(newContact.getLastName().equals("Doe"));
	}
	
	@Test
	public void testSetLastNameLong() {
		Contact newContact = new Contact("1234567891","John","Smith","5556667777","123 Main St. Example, MA 12345");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			newContact.setLastName("Smith678910");
		});
	}
	
	@Test
	public void testSetLastNameNull() {
		Contact newContact = new Contact("1234567891","John","Smith","5556667777","123 Main St. Example, MA 12345");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			newContact.setFirstName(null);
		});
	}
	
	//Tests the catches for the update to phone number
	@Test
	public void testSetPhoneNumber() {
		Contact newContact = new Contact("1234567891","John","Smith","5556667777","123 Main St. Example, MA 12345");
		newContact.setPhoneNum("1234567890");
		assertTrue(newContact.getPhoneNum().equals("1234567890"));
	}
	
	@Test
	public void testSetPhoneNumberNot10() {
		Contact newContact = new Contact("1234567891","John","Smith","5556667777","123 Main St. Example, MA 12345");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			newContact.setPhoneNum("123");
		});
	}
	
	@Test
	public void testSetPhoneNumberNull() {
		Contact newContact = new Contact("1234567891","John","Smith","5556667777","123 Main St. Example, MA 12345");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			newContact.setPhoneNum(null);
		});
	}
	
	//Tests the catch for phone number having a numeric value 
	@Test
	public void testSetPhoneNumberNotNumeric() {
		Contact newContact = new Contact("1234567891","John","Smith","5556667777","123 Main St. Example, MA 12345");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			newContact.setPhoneNum("abcde");
		});
	}
	
	//Tests the catches for the update to address
	@Test
	public void testSetAddress() {
		Contact newContact = new Contact("1234567891","John","Smith","5556667777","123 Main St. Example, MA 12345");
		newContact.setAddress("New Address");
		assertTrue(newContact.getAddress().equals("New Address"));
	}
	
	@Test
	public void testSetAddressTooLong() {
		Contact newContact = new Contact("1234567891","John","Smith","5556667777","123 Main St. Example, MA 12345");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			newContact.setAddress("New Address is wayyyy too long. Maybe add some numbers to the back of this to get it longer. 123");
		});
	}
	
	@Test
	public void testSetAddressNull() {
		Contact newContact = new Contact("1234567891","John","Smith","5556667777","123 Main St. Example, MA 12345");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			newContact.setAddress(null);
		});
	}
}
	
	