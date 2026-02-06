package chess;

public class Bishop extends ChessPiece {
  public Bishop(int row, int col, Color color) {
    super(row, col, color);
  }

  @Override
  public boolean canMove(int r, int c) {
    if (!inBounds(r, c) || sameSquare(r, c)) return false;
    int dr = Math.abs(r - row);
    int dc = Math.abs(c - col);
    return dr == dc;
  }
}

