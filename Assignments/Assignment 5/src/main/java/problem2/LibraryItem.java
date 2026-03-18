package problem2;

public abstract class LibraryItem {
  private String title;
  private int year;
  private Creator creator;

  public LibraryItem(String title, int year, Creator creator) {
    if (title == null || title.isBlank()) {
      throw new IllegalArgumentException("Title cannot be null or blank.");
    }
    if (creator == null) {
      throw new IllegalArgumentException("Creator cannot be null.");
    }
    this.title = title;
    this.year = year;
    this.creator = creator;
  }

  public String getTitle() {
    return title;
  }

  public int getYear() {
    return year;
  }

  public Creator getCreator() {
    return creator;
  }
}
