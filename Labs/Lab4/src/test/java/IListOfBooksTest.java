import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class IListOfBooksTest {

  Book b1 = new Book("A", "Ann", 1999, 10.0f);
  Book b2 = new Book("B", "Bob", 2005, 20.0f);
  Book b3 = new Book("C", "Cat", 1980, 5.0f);

  IListOfBooks empty = new EmptyNode();
  IListOfBooks one = new ElementNode(b1, empty);
  IListOfBooks two = new ElementNode(b1,
      new ElementNode(b2, empty));

  // ---------- EmptyNode ----------

  @Test
  public void testEmptyCount() {
    assertEquals(0, empty.count());
    assertNotEquals(1, empty.count());
  }

  @Test
  public void testEmptyTotalPrice() {
    assertEquals(0.0f, empty.totalPrice(), 0.0001);
    assertTrue(empty.totalPrice() <= 0);
  }

  @Test
  public void testEmptyAllBefore() {
    assertEquals(0, empty.allBefore(2000).count());
    assertEquals("[]", empty.toString());
  }

  @Test
  public void testEmptyAddAtEnd() {
    IListOfBooks r = empty.addAtEnd(b1);
    assertEquals(1, r.count());
    assertEquals(10.0f, r.totalPrice(), 0.0001);
  }

  @Test
  public void testEmptyToString() {
    assertEquals("[]", empty.toString());
    assertNotEquals("", empty.toString());
  }

  // ---------- ElementNode ----------

  @Test
  public void testElementCount() {
    assertEquals(1, one.count());
    assertEquals(2, two.count());
  }

  @Test
  public void testElementTotalPrice() {
    assertEquals(10.0f, one.totalPrice(), 0.0001);
    assertEquals(30.0f, two.totalPrice(), 0.0001);
  }

  @Test
  public void testElementAllBefore() {
    IListOfBooks filtered = two.allBefore(2000);
    assertEquals(1, filtered.count());
    assertTrue(filtered.totalPrice() == 10.0f);
  }

  @Test
  public void testElementAddAtEnd() {
    IListOfBooks r = two.addAtEnd(b3);
    assertEquals(3, r.count());
    assertEquals(35.0f, r.totalPrice(), 0.0001);
  }

  @Test
  public void testElementToString() {
    assertTrue(one.toString().contains("A"));
    assertTrue(two.toString().contains("B"));
  }
}

