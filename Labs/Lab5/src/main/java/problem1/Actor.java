package problem1;

/**
 * Represents an Actor.
 */
public class Actor extends Performer {

  /**
   * Constructs an Actor.
   */
  public Actor(String firstName,
      String lastName,
      int age,
      String[] genres,
      String[] awards,
      String[] movies,
      String[] series,
      String[] otherMultimedia) {

    super(firstName, lastName, age,
        genres, awards,
        movies, series, otherMultimedia);
  }
}
