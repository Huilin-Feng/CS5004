/**
 * Represents a person with a first name and last name.
 */
public class Person {

    private String firstName;
    private String lastName;

    /**
     * Constructs a Person with the given first and last name.
     *
     * @param firstName the person's first name
     * @param lastName the person's last name
     */
    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * Returns the first name.
     *
     * @return first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Returns the last name.
     *
     * @return last name
     */
    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}
