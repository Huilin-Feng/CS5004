package chess;

public abstract class ChessPiece implements ChessPieceContract {
  protected final int row;
  protected final int col;
  protected final Color color;

  protected ChessPiece(int row, int col, Color color) {
    if (!inBounds(row, col)) {
      throw new IllegalArgumentException("Position out of bounds");
    }
    if (color == null) {
      throw new IllegalArgumentException("Color cannot be null");
    }
    this.row = row;
    this.col = col;
    this.color = color;
  }

  @Override
  public int getRow() { return row; }

  @Override
  public int getColumn() { return col; }

  @Override
  public Color getColor() { return color; }

  protected static boolean inBounds(int r, int c) {
    return r >= 0 && r <= 7 && c >= 0 && c <= 7;
  }

  protected boolean sameSquare(int r, int c) {
    return this.row == r && this.col == c;
  }

  @Override
  public boolean canKill(ChessPiece piece) {
    if (piece == null) return false;
    if (this.color == piece.color) return false;
    return canMove(piece.row, piece.col);
  }
}

