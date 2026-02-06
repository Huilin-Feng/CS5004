package chess;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class QueenTest {

  @Test
  void testCanMove() {
    Queen q = new Queen(4, 4, Color.WHITE);

    // rook-like
    assertTrue(q.canMove(4, 7));
    assertTrue(q.canMove(0, 4));

    // bishop-like
    assertTrue(q.canMove(6, 6));
    assertTrue(q.canMove(2, 6));

    // invalid
    assertFalse(q.canMove(5, 6));
    assertFalse(q.canMove(4, 4));
    assertFalse(q.canMove(9, 9));
  }

  @Test
  void testCanKill() {
    Queen q = new Queen(4, 4, Color.WHITE);
    Queen enemy = new Queen(4, 7, Color.BLACK);
    Queen friend = new Queen(4, 7, Color.WHITE);

    assertTrue(q.canKill(enemy));
    assertFalse(q.canKill(friend));
  }

  @Test
  void testConstructorOutOfBounds() {
    assertThrows(IllegalArgumentException.class, () -> new Queen(-1, 0, Color.WHITE));
    assertThrows(IllegalArgumentException.class, () -> new Queen(0, 8, Color.WHITE));
  }
}

