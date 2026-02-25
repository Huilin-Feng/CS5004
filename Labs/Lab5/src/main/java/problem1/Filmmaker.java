package problem1;

/**
 * Represents a Filmmaker.
 */
public class Filmmaker extends Performer {

  public Filmmaker(String firstName,
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
