package problem2;

import java.util.Arrays;

public class Problem2Runner {
  public static void main(String[] args) {
    Author author1 = new Author("Jane", "Austen");
    Author author2 = new Author("George", "Orwell");

    RecordingArtist artist1 = new RecordingArtist("Taylor", "Swift");
    RecordingArtist artist2 = new RecordingArtist("John", "Lennon");
    RecordingArtist artist3 = new RecordingArtist("Paul", "McCartney");

    Band band = new Band("The Beatles", Arrays.asList(artist2, artist3));

    Book book1 = new Book("Pride and Prejudice", 1813, author1);
    Book book2 = new Book("1984", 1949, author2);

    Music music1 = new Music("Love Story", 2008, artist1);
    Music music2 = new Music("Hey Jude", 1968, band);

    Catalog catalog = new Catalog();
    catalog.addItem(book1);
    catalog.addItem(book2);
    catalog.addItem(music1);
    catalog.addItem(music2);

    System.out.println("Search by keyword 'pr': " + catalog.search("pr"));
    System.out.println("Search by author Jane Austen: " + catalog.search(author1));
    System.out.println("Search by artist John Lennon: " + catalog.search(artist2));
  }
}