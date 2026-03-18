package problem2;

public class Music extends LibraryItem {
  public Music(String title, int year, RecordingArtist artist) {
    super(title, year, artist);
  }

  public Music(String title, int year, Band band) {
    super(title, year, band);
  }

  @Override
  public String toString() {
    return "Music: " + getTitle() + " (" + getYear() + ") by " + getCreator();
  }
}
