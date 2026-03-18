package problem2;

import java.util.ArrayList;
import java.util.List;

public class Catalog {
  private List<LibraryItem> items;

  public Catalog() {
    this.items = new ArrayList<>();
  }

  public Catalog(List<LibraryItem> items) {
    if (items == null) {
      throw new IllegalArgumentException("Items cannot be null.");
    }
    this.items = new ArrayList<>(items);
  }

  public List<LibraryItem> getItems() {
    return new ArrayList<>(items);
  }

  public void addItem(LibraryItem item) {
    if (item == null) {
      throw new IllegalArgumentException("Item cannot be null.");
    }
    items.add(item);
  }

  public void removeItem(LibraryItem item) {
    items.remove(item);
  }

  public List<LibraryItem> search(String keyword) {
    List<LibraryItem> result = new ArrayList<>();
    if (keyword == null) {
      return result;
    }

    String lowerKeyword = keyword.toLowerCase();
    for (LibraryItem item : items) {
      if (item.getTitle().toLowerCase().contains(lowerKeyword)) {
        result.add(item);
      }
    }
    return result;
  }

  public List<LibraryItem> search(Author author) {
    List<LibraryItem> result = new ArrayList<>();
    if (author == null) {
      return result;
    }

    for (LibraryItem item : items) {
      if (item instanceof Book) {
        Book book = (Book) item;
        if (book.getAuthor().equals(author)) {
          result.add(book);
        }
      }
    }
    return result;
  }

  public List<LibraryItem> search(RecordingArtist artist) {
    List<LibraryItem> result = new ArrayList<>();
    if (artist == null) {
      return result;
    }

    for (LibraryItem item : items) {
      if (item instanceof Music) {
        Creator creator = item.getCreator();

        if (creator instanceof RecordingArtist
            && creator.equals(artist)) {
          result.add(item);
        } else if (creator instanceof Band) {
          Band band = (Band) creator;
          if (band.hasMember(artist)) {
            result.add(item);
          }
        }
      }
    }
    return result;
  }
}
