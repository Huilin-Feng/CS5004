package chess;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class RookTest {

  @Test
  void testCanMove() {
    Rook r = new Rook(4, 4, Color.WHITE);
    assertTrue(r.canMove(4, 7));   // same row
    assertTrue(r.canMove(0, 4));   // same col
    assertFalse(r.canMove(5, 5));  // diagonal (invalid)
    assertFalse(r.canMove(4, 4));  // same square (invalid)
    assertFalse(r.canMove(9, 4));  // out of bounds (invalid)
  }

  @Test
  void testCanKill() {
    Rook r = new Rook(4, 4, Color.WHITE);
    Rook enemy = new Rook(4, 7, Color.BLACK);
    Rook friend = new Rook(4, 7, Color.WHITE);

    assertTrue(r.canKill(enemy));
    assertFalse(r.canKill(friend));
  }

  @Test
  void testConstructorOutOfBounds() {
    assertThrows(IllegalArgumentException.class, () -> new Rook(-1, 0, Color.WHITE));
    assertThrows(IllegalArgumentException.class, () -> new Rook(0, 8, Color.WHITE));
  }
}

