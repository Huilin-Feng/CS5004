package chess;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class KnightTest {

  @Test
  void testCanMove() {
    Knight k = new Knight(4, 4, Color.WHITE);
    assertTrue(k.canMove(6, 5));
    assertTrue(k.canMove(5, 6));
    assertTrue(k.canMove(2, 3));
    assertTrue(k.canMove(3, 2));

    assertFalse(k.canMove(4, 5));  // not L
    assertFalse(k.canMove(4, 4));  // same square
    assertFalse(k.canMove(9, 9));  // out of bounds
  }

  @Test
  void testCanKill() {
    Knight k = new Knight(4, 4, Color.WHITE);
    Knight enemy = new Knight(6, 5, Color.BLACK);
    Knight friend = new Knight(6, 5, Color.WHITE);

    assertTrue(k.canKill(enemy));
    assertFalse(k.canKill(friend));
  }

  @Test
  void testConstructorOutOfBounds() {
    assertThrows(IllegalArgumentException.class, () -> new Knight(-1, 0, Color.WHITE));
    assertThrows(IllegalArgumentException.class, () -> new Knight(0, 8, Color.WHITE));
  }
}

