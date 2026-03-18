package problem2;

import java.util.Objects;

public abstract class Person extends Creator {
  private String firstName;
  private String lastName;

  public Person(String firstName, String lastName) {
    if (firstName == null || firstName.isBlank()
        || lastName == null || lastName.isBlank()) {
      throw new IllegalArgumentException("Names cannot be null or blank.");
    }
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Person)) {
      return false;
    }
    Person person = (Person) o;
    return firstName.equals(person.firstName)
        && lastName.equals(person.lastName)
        && this.getClass().equals(person.getClass());
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstName, lastName, getClass());
  }

  @Override
  public String toString() {
    return firstName + " " + lastName;
  }
}
