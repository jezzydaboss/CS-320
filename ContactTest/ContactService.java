import java.util.*;


public class ContactService {

    private Map<String, Contact> contacts = new HashMap<>();

    public boolean addContact(String contactId, String firstName, String lastName, String phone, String address) {
        if (contacts.containsKey(contactId)) return false;
        contacts.put(contactId, new Contact(contactId, firstName, lastName, phone, address));
        return true;
    }

    public boolean deleteContact(String contactId) {
        return contacts.remove(contactId) != null;
    }

    public Contact getContact(String contactId) {
        return contacts.get(contactId);
    }

    public boolean updateContactFirstName(String contactId, String firstName) {
        Contact contact = contacts.get(contactId);
        if (contact != null) {
            contact.setFirstName(firstName);
            return true;
        }
        return false;
    }

    public boolean updateContactLastName(String contactId, String lastName) {
        Contact contact = contacts.get(contactId);
        if (contact != null) {
            contact.setLastName(lastName);
            return true;
        }
        return false;
    }

    public boolean updateContactPhone(String contactId, String number) {
        Contact contact = contacts.get(contactId);
        if (contact != null) {
            contact.setPhone(number);
            return true;
        }
        return false;
    }

    public boolean updateContactAddress(String contactId, String address) {
        Contact contact = contacts.get(contactId);
        if (contact != null) {
            contact.setAddress(address);
            return true;
        }
        return false;
    }
}