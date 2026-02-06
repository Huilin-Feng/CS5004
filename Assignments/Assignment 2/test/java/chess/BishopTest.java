package chess;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class BishopTest {

  @Test
  void testCanMove() {
    Bishop b = new Bishop(4, 4, Color.WHITE);
    assertTrue(b.canMove(6, 6));   // diagonal
    assertTrue(b.canMove(2, 6));   // diagonal
    assertFalse(b.canMove(4, 7));  // straight (invalid)
    assertFalse(b.canMove(4, 4));  // same square
    assertFalse(b.canMove(-1, 3)); // out of bounds
  }

  @Test
  void testCanKill() {
    Bishop b = new Bishop(4, 4, Color.WHITE);
    Bishop enemy = new Bishop(6, 6, Color.BLACK);
    Bishop friend = new Bishop(6, 6, Color.WHITE);

    assertTrue(b.canKill(enemy));
    assertFalse(b.canKill(friend));
  }

  @Test
  void testConstructorOutOfBounds() {
    assertThrows(IllegalArgumentException.class, () -> new Bishop(8, 0, Color.WHITE));
    assertThrows(IllegalArgumentException.class, () -> new Bishop(0, -2, Color.WHITE));
  }
}

