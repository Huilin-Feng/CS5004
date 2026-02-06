package chess;

public class Knight extends ChessPiece {
  public Knight(int row, int col, Color color) {
    super(row, col, color);
  }

  @Override
  public boolean canMove(int r, int c) {
    if (!inBounds(r, c) || sameSquare(r, c)) return false;
    int dr = Math.abs(r - row);
    int dc = Math.abs(c - col);
    return (dr == 2 && dc == 1) || (dr == 1 && dc == 2);
  }
}

