import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BookTest {
  private Book b1;
  private Book b2;
  private Book b3;

  @BeforeEach
  void setUp() {
    b1 = new Book("Clean Code", "Robert C. Martin", 464);
    b2 = new Book("Effective Java", "Joshua Bloch", 416);
    b3 = new Book("The Pragmatic Programmer", "Andrew Hunt", 352);
  }

  @Test
  void testGetTitle() {
    assertEquals("Clean Code", b1.getTitle());
    assertEquals("Effective Java", b2.getTitle());
    assertEquals("The Pragmatic Programmer", b3.getTitle());
  }

  @Test
  void testGetAuthor() {
    assertEquals("Robert C. Martin", b1.getAuthor());
    assertEquals("Joshua Bloch", b2.getAuthor());
    assertEquals("Andrew Hunt", b3.getAuthor());
  }

  @Test
  void testGetPages() {
    assertEquals(464, b1.getPages());
    assertEquals(416, b2.getPages());
    assertEquals(352, b3.getPages());
  }
}

