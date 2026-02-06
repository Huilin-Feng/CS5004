package chess;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class KingTest {

  @Test
  void testCanMove() {
    King k = new King(4, 4, Color.WHITE);

    // 8 个方向走一步都可以
    assertTrue(k.canMove(5, 4)); // up
    assertTrue(k.canMove(3, 4)); // down
    assertTrue(k.canMove(4, 5)); // right
    assertTrue(k.canMove(4, 3)); // left
    assertTrue(k.canMove(5, 5)); // diag
    assertTrue(k.canMove(5, 3)); // diag
    assertTrue(k.canMove(3, 5)); // diag
    assertTrue(k.canMove(3, 3)); // diag

    // invalid
    assertFalse(k.canMove(6, 4)); // too far
    assertFalse(k.canMove(4, 4)); // same square
    assertFalse(k.canMove(-1, 4)); // out of bounds
  }

  @Test
  void testCanKill() {
    King k = new King(4, 4, Color.WHITE);
    King enemy = new King(5, 5, Color.BLACK);
    King friend = new King(5, 5, Color.WHITE);

    assertTrue(k.canKill(enemy));
    assertFalse(k.canKill(friend));
  }

  @Test
  void testConstructorOutOfBounds() {
    assertThrows(IllegalArgumentException.class, () -> new King(8, 0, Color.WHITE));
    assertThrows(IllegalArgumentException.class, () -> new King(0, -1, Color.WHITE));
  }
}

