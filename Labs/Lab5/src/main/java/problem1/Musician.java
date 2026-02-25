package problem1;

/**
 * Represents a Musician.
 */
public class Musician extends Artist {

  private String recordingCompany;
  private String lastRecordAlbum;

  /**
   * Constructs a Musician.
   */
  public Musician(String firstName,
      String lastName,
      int age,
      String[] genres,
      String[] awards,
      String recordingCompany,
      String lastRecordAlbum) {

    super(firstName, lastName, age, genres, awards);
    this.recordingCompany = recordingCompany;
    this.lastRecordAlbum = lastRecordAlbum;
  }
}