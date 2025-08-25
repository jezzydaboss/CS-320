import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class ContactTest {

    // Constructor signature reminder:
    // Contact(String contactId, String firstName, String lastName, String phone, String address)

    // Success case: valid contact creation
    @Test
    void testCreateContact_WithValidData_ShouldSucceed() {
        Contact contact = new Contact("123456", "Omar", "Toledo", "5616998563", "5645 Pacific Blvd");

        assertNotNull(contact);
        assertEquals("123456", contact.getContactId());
        assertEquals("Omar", contact.getFirstName());
        assertEquals("Toledo", contact.getLastName());
        assertEquals("5645 Pacific Blvd", contact.getAddress());
        assertEquals("5616998563", contact.getPhone());
    }

    // Failure cases: invalid inputs

    @Test
    void testCreateContact_WithTooLongContactId_ShouldThrowException() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("12345678901", "Omar", "Toledo", "4802929112", "2801 91ST"));
    }

    @Test
    void testCreateContact_WithTooLongFirstName_ShouldThrowException() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("123456", "Omarrrrrrrrrrr", "Toledo", "4802929112", "1111 E Road Street"));
    }

    @Test
    void testCreateContact_WithTooLongLastName_ShouldThrowException() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("123456", "Omar", "Toledoooooooooooooo", "4802929112", "1111 E Road Street"));
    }

    @Test
    void testCreateContact_WithTooLongAddress_ShouldThrowException() {
        String longAddress = "1234567890123456789012345678901234567890"; // > 30 chars
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("123456", "Omar", "Toledo", "4802929112", longAddress));
    }

    @Test
    void testCreateContact_WithTooLongPhoneNumber_ShouldThrowException() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("123456", "Omar", "Toledo", "123456789012", "2801 91ST"));
    }

    @Test
    void testCreateContact_WithTooShortPhoneNumber_ShouldThrowException() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("123456", "Omar", "Toledo", "1234567", "2801 91ST"));
    }

    @Test
    void testCreateContact_WithNonDigitPhone_ShouldThrowException() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("123456", "Omar", "Toledo", "12345abcde", "2801 91ST"));
    }

    // Update tests

    @Test
    void testUpdateContactFirstName_WithValidData_ShouldSucceed() {
        Contact contact = new Contact("123456", "Omar", "Toledo", "5616998563", "5645 Pacific Blvd");
        contact.setFirstName("Alex");
        assertEquals("Alex", contact.getFirstName());
    }

    @Test
    void testUpdateContactPhone_WithInvalidData_ShouldThrowException() {
        Contact contact = new Contact("123456", "Omar", "Toledo", "5616998563", "5645 Pacific Blvd");
        assertThrows(IllegalArgumentException.class, () -> contact.setPhone("123")); // too short
    }
}