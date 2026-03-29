public class Student {
  private String firstName;
  private String lastName;
  private String studentId;
  private String email;

  public Student(String firstName, String lastName, String studentId, String email) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.studentId = studentId;
    this.email = email;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getStudentId() {
    return studentId;
  }

  public void setStudentId(String studentId) {
    this.studentId = studentId;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Override
  public String toString() {
    return "First Name: " + firstName +
        ", Last Name: " + lastName +
        ", ID: " + studentId +
        ", Email: " + email;
  }
}