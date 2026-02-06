package chess;

public class Queen extends ChessPiece {
  public Queen(int row, int col, Color color) {
    super(row, col, color);
  }

  @Override
  public boolean canMove(int r, int c) {
    if (!inBounds(r, c) || sameSquare(r, c)) return false;

    int dr = Math.abs(r - row);
    int dc = Math.abs(c - col);

    return r == row || c == col || dr == dc;
  }
}
