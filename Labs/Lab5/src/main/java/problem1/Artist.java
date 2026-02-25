package problem1;

/**
 * This abstract class represents a general Artist.
 * All specific types of artists extend this class.
 */
public abstract class Artist {

  protected String firstName;
  protected String lastName;
  protected int age;
  protected String[] genres;
  protected String[] awards;

  /**
   * Constructs an Artist with basic information.
   *
   * @param firstName the first name of the artist
   * @param lastName the last name of the artist
   * @param age the age of the artist (must be between 0 and 128)
   * @param genres the genres associated with the artist
   * @param awards the awards received by the artist
   * @throws IllegalArgumentException if age is out of range
   */
  public Artist(String firstName,
      String lastName,
      int age,
      String[] genres,
      String[] awards) {

    if (age < 0 || age > 128) {
      throw new IllegalArgumentException("Age must be between 0 and 128.");
    }

    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
    this.genres = genres;
    this.awards = awards;
  }

  /**
   * Adds a new award to the artist's awards list.
   *
   * @param award the award to be added
   */
  public void receiveAward(String award) {

    String[] newAwards = new String[this.awards.length + 1];

    for (int i = 0; i < this.awards.length; i++) {
      newAwards[i] = this.awards[i];
    }

    newAwards[this.awards.length] = award;
    this.awards = newAwards;
  }
}
