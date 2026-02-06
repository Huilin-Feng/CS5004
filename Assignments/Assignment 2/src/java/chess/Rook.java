package chess;

public class Rook extends ChessPiece {
  public Rook(int row, int col, Color color) {
    super(row, col, color);
  }

  @Override
  public boolean canMove(int r, int c) {
    if (!inBounds(r, c) || sameSquare(r, c)) return false;
    return r == row || c == col;
  }
}

