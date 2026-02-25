package problem1;

/**
 * Represents a performing artist who has participated in multimedia works.
 * Actors, Dancers, and Filmmakers extend this class.
 */
public abstract class Performer extends Artist {

  protected String[] movies;
  protected String[] series;
  protected String[] otherMultimedia;

  /**
   * Constructs a Performer.
   *
   * @param firstName the first name
   * @param lastName the last name
   * @param age the age (0..128)
   * @param genres the genres
   * @param awards the awards
   * @param movies the movies worked on
   * @param series the tv series worked on
   * @param otherMultimedia other multimedia works
   */
  public Performer(String firstName,
      String lastName,
      int age,
      String[] genres,
      String[] awards,
      String[] movies,
      String[] series,
      String[] otherMultimedia) {

    super(firstName, lastName, age, genres, awards);
    this.movies = movies;
    this.series = series;
    this.otherMultimedia = otherMultimedia;
  }
}
