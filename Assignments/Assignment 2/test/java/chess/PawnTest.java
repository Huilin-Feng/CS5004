package chess;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PawnTest {

  @Test
  void testWhitePawnCanMove() {
    Pawn p = new Pawn(1, 4, Color.WHITE);

    assertTrue(p.canMove(2, 4));  // forward 1
    assertTrue(p.canMove(3, 4));  // forward 2 from start row

    assertFalse(p.canMove(0, 4)); // backwards
    assertFalse(p.canMove(2, 5)); // diagonal is NOT normal move
    assertFalse(p.canMove(1, 4)); // same square
  }

  @Test
  void testBlackPawnCanMove() {
    Pawn p = new Pawn(6, 4, Color.BLACK);

    assertTrue(p.canMove(5, 4));  // forward 1 (down)
    assertTrue(p.canMove(4, 4));  // forward 2 from start row

    assertFalse(p.canMove(7, 4)); // backwards
    assertFalse(p.canMove(5, 5)); // diagonal is NOT normal move
  }

  @Test
  void testPawnCanKill() {
    Pawn white = new Pawn(3, 3, Color.WHITE);
    Pawn black = new Pawn(4, 4, Color.BLACK);
    Pawn black2 = new Pawn(4, 2, Color.BLACK);
    Pawn friend = new Pawn(4, 4, Color.WHITE);

    assertTrue(white.canKill(black));   // diag forward-right
    assertTrue(white.canKill(black2));  // diag forward-left
    assertFalse(white.canKill(friend)); // same color

    Pawn b = new Pawn(4, 4, Color.BLACK);
    Pawn w1 = new Pawn(3, 3, Color.WHITE);
    assertTrue(b.canKill(w1)); // black captures diagonally "down"
  }

  @Test
  void testPawnConstructorSpecialRowRestriction() {
    assertThrows(IllegalArgumentException.class, () -> new Pawn(0, 0, Color.WHITE));
    assertThrows(IllegalArgumentException.class, () -> new Pawn(7, 0, Color.BLACK));
  }

  @Test
  void testPawnConstructorOutOfBounds() {
    assertThrows(IllegalArgumentException.class, () -> new Pawn(-1, 0, Color.WHITE));
    assertThrows(IllegalArgumentException.class, () -> new Pawn(1, 8, Color.WHITE));
  }
}
