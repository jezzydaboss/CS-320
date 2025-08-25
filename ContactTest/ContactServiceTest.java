import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

	
	public class ContactServiceTest {

    // Verifies that adding a contact stores it correctly
		
    @Test
    public void testAddContact_WithValidData_ShouldSucceed() {
        ContactService service = new ContactService();
        boolean added = service.addContact("001", "Alice", "Wong", "1234567890", "10 Apple Ln");

        assertTrue(added);
        Contact contact = service.getContact("001");
        assertNotNull(contact);
        assertEquals("Alice", contact.getFirstName());
        assertEquals("Wong", contact.getLastName());
    }

    // Tests that a contact can be deleted
    @Test
    public void testDeleteContact_WithExistingId_ShouldRemoveContact() {
        ContactService service = new ContactService();
        service.addContact("001", "Bob", "Lee", "1234567890", "20 Banana Rd");

        boolean deleted = service.deleteContact("001");
        assertTrue(deleted);
        assertNull(service.getContact("001"));
    }

    // Confirms first name update works
    @Test
    public void testUpdateContactFirstName_WithValidData_ShouldSucceed() {
        ContactService service = new ContactService();
        service.addContact("001", "Chloe", "Kim", "1234567890", "30 Cherry Ct");

        boolean updated = service.updateContactFirstName("001", "Chris");
        assertTrue(updated);
        assertEquals("Chris", service.getContact("001").getFirstName());
    }

    //Confirms phone number update works
    @Test
    public void testUpdateContactPhone_WithValidData_ShouldSucceed() {
        ContactService service = new ContactService();
        service.addContact("001", "Chloe", "Kim", "1234567890", "30 Cherry Ct");

        boolean updated = service.updateContactPhone("001", "0987654321");
        assertTrue(updated);
        assertEquals("0987654321", service.getContact("001").getPhone());
    }

    // Confirms update fails for non-existent contact
    @Test
    public void testUpdateContactFirstName_WithInvalidId_ShouldFail() {
        ContactService service = new ContactService();
        boolean updated = service.updateContactFirstName("999", "Chris");

        assertFalse(updated);
    }
}
