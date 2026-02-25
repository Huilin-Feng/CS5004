package problem1;

/**
 * Represents a Poet.
 */
public class Poet extends Artist {

  private String publishingCompany;
  private String lastPublishedCollection;

  /**
   * Constructs a Poet.
   */
  public Poet(String firstName,
      String lastName,
      int age,
      String[] genres,
      String[] awards,
      String publishingCompany,
      String lastPublishedCollection) {

    super(firstName, lastName, age, genres, awards);
    this.publishingCompany = publishingCompany;
    this.lastPublishedCollection = lastPublishedCollection;
  }
}
