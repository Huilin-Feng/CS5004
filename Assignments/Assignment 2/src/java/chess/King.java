package chess;

public class King extends ChessPiece {
  public King(int row, int col, Color color) {
    super(row, col, color);
  }

  @Override
  public boolean canMove(int r, int c) {
    if (!inBounds(r, c) || sameSquare(r, c)) return false;

    int dr = Math.abs(r - row);
    int dc = Math.abs(c - col);

    return Math.max(dr, dc) == 1;
  }
}

