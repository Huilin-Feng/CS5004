package problem2;

public class Book extends LibraryItem {
  public Book(String title, int year, Author author) {
    super(title, year, author);
  }

  public Author getAuthor() {
    return (Author) getCreator();
  }

  @Override
  public String toString() {
    return "Book: " + getTitle() + " (" + getYear() + ") by " + getAuthor();
  }
}
