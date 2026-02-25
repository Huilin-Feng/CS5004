package problem1;

/**
 * Represents a visual artist whose work has been shown in exhibits.
 * Painters and Photographers extend this class.
 */
public abstract class VisualArtist extends Artist {

  protected String[] exhibits;

  /**
   * Constructs a VisualArtist.
   */
  public VisualArtist(String firstName,
      String lastName,
      int age,
      String[] genres,
      String[] awards,
      String[] exhibits) {

    super(firstName, lastName, age, genres, awards);
    this.exhibits = exhibits;
  }
}
