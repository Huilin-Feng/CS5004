import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TriangleTest {

  @Test
  public void testToString() {
    Shape t = new Triangle(0, 0, 3, 0, 0, 4);
    assertEquals("Triangle: (0.000,0.000) (3.000,0.000) (0.000,4.000)", t.toString());
  }

  @Test
  public void testPerimeter() {
    Shape t = new Triangle(0, 0, 3, 0, 0, 4);
    assertEquals(12.0, t.perimeter(), 0.001);
  }

  @Test
  public void testArea() {
    Shape t = new Triangle(0, 0, 3, 0, 0, 4);
    assertEquals(6.0, t.area(), 0.001);
  }

  @Test
  public void testAreaCollinearIsZero() {
    Shape t = new Triangle(0, 0, 1, 1, 2, 2);
    assertEquals(0.0, t.area(), 0.001);
  }

  @Test
  public void testResizeScalesAreaByFactor() {
    Shape t = new Triangle(0, 0, 3, 0, 0, 4);
    Shape resized = t.resize(10.0);
    assertEquals(10.0 * t.area(), resized.area(), 0.001);
  }

  @Test
  public void testConstructorThrowsOnIdenticalPoints() {
    assertThrows(IllegalArgumentException.class,
        () -> new Triangle(0, 0, 0, 0, 1, 1));

    assertThrows(IllegalArgumentException.class,
        () -> new Triangle(0, 0, 2, 2, 2, 2));
  }

  @Test
  public void testConstructorDoesNotThrowOnValidTriangle() {
    assertDoesNotThrow(() -> new Triangle(0, 0, 3, 0, 0, 4));
  }
}
