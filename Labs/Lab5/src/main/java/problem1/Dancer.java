package problem1;

/**
 * Represents a Dancer.
 */
public class Dancer extends Performer {

  public Dancer(String firstName,
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
