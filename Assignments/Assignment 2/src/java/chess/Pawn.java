package chess;

public class Pawn extends ChessPiece {
  public Pawn(int row, int col, Color color) {
    super(row, col, color);

    if (color == Color.WHITE && row == 0) {
      throw new IllegalArgumentException("White pawn cannot be on row 0");
    }
    if (color == Color.BLACK && row == 7) {
      throw new IllegalArgumentException("Black pawn cannot be on row 7");
    }
  }

  @Override
  public boolean canMove(int r, int c) {
    if (!inBounds(r, c) || sameSquare(r, c)) return false;

    int dir = (color == Color.WHITE) ? 1 : -1;
    int startRow = (color == Color.WHITE) ? 1 : 6;

    int dr = r - row;
    int dc = Math.abs(c - col);

    if (dc == 0) {
      if (dr == dir) return true;
      if (row == startRow && dr == 2 * dir) return true;
    }

    return false;
  }

  @Override
  public boolean canKill(ChessPiece piece) {
    if (piece == null) return false;
    if (this.color == piece.color) return false;

    int dir = (color == Color.WHITE) ? 1 : -1;
    int dr = piece.row - this.row;
    int dc = Math.abs(piece.col - this.col);

    return dr == dir && dc == 1;
  }
}

