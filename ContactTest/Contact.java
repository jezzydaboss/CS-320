public class Contact {
    // Fields for contact information
    private final String contactId; // Immutable contact ID
    private String firstName;
    private String lastName;
    private String phone;
    private String address;

    // Constructor with validations
    public Contact(String contactId, String firstName, String lastName, String phone, String address) {
        // Validate required fields and constraints
        if (contactId == null || contactId.length() > 10) throw new IllegalArgumentException("Invalid Contact ID");
        if (firstName == null || firstName.length() > 10) throw new IllegalArgumentException("Invalid First Name");
        if (lastName == null || lastName.length() > 10) throw new IllegalArgumentException("Invalid Last Name");
        if (phone == null || phone.length() != 10 || !phone.matches("\\d+")) throw new IllegalArgumentException("Phone must be 10 digits");
        if (address == null || address.length() > 30) throw new IllegalArgumentException("Invalid Address");

        // Assign validated values
        this.contactId = contactId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
    }

    // Getter methods only for contactId (immutable) and other fields
    public String getContactId() { return contactId; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getPhone() { return phone; }
    public String getAddress() { return address; }

    // Setters with validation for updatable fields
    public void setFirstName(String firstName) {
        if (firstName == null || firstName.length() > 10) throw new IllegalArgumentException();
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.length() > 10) throw new IllegalArgumentException();
        this.lastName = lastName;
    }

    public void setPhone(String phone) {
        if (phone == null || phone.length() != 10 || !phone.matches("\\d+")) throw new IllegalArgumentException();
        this.phone = phone;
    }

    public void setAddress(String address) {
        if (address == null || address.length() > 30) throw new IllegalArgumentException();
        this.address = address;
    }
}
