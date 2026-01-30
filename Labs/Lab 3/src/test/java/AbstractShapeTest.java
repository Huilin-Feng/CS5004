import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AbstractShapeTest {

  @Test
  public void testCompareToThreeOutcomes() {
    Shape small = new Circle(0, 0, 1);        // area = PI
    Shape same  = new Circle(2, 2, 1);        // area = PI
    Shape big   = new Rectangle(0, 0, 10, 10); // area = 100

    assertTrue(small.compareTo(big) < 0);
    assertEquals(0, small.compareTo(same));
    assertTrue(big.compareTo(small) > 0);
  }

  @Test
  public void testDistanceFromOriginUsesReferencePoint() {
    Shape c = new Circle(3, 4, 5); // reference (3,4)
    assertEquals(5.0, c.distanceFromOrigin(), 0.001);
  }
}

