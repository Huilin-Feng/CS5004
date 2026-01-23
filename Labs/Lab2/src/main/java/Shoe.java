public class Shoe {

  private final Kind kind;
  private final Color color;
  private final Brand brand;
  private final double size;

  public Shoe(Kind kind, Color color, Brand brand, double size) {
    if (brand == Brand.NIKE && kind == Kind.DRESS) {
      throw new IllegalArgumentException("NIKE does not sell dress shoes.");
    }
    this.kind = kind;
    this.color = color;
    this.brand = brand;
    this.size = size;
  }

  public Kind getKind() {
    return kind;
  }

  public Color getColor() {
    return color;
  }

  public Brand getBrand() {
    return brand;
  }

  public double getSize() {
    return size;
  }

  /**
   * Returns a summary of this shoe including brand, color, kind, and size.
   *
   * @return a string summary of this shoe
   */
  @Override
  public String toString() {
    String kindStr;
    switch (kind) {
      case SNEAKER:
        kindStr = "Sneaker";
        break;
      case BOOT:
        kindStr = "Boot";
        break;
      case DRESS:
        kindStr = "Dress";
        break;
      case SANDAL:
        kindStr = "Sandal";
        break;
      default:
        kindStr = kind.toString();
    }

    String brandStr;
    switch (brand) {
      case NIKE:
        brandStr = "Nike";
        break;
      case ADIDAS:
        brandStr = "Adidas";
        break;
      case PUMA:
        brandStr = "Puma";
        break;
      case VANS:
        brandStr = "Vans";
        break;
      default:
        brandStr = brand.toString();
    }

    // Color: do NOT provide a case for every color; rely on default for some.
    String colorStr;
    switch (color) {
      case BLACK:
        colorStr = "Black";
        break;
      case WHITE:
        colorStr = "White";
        break;
      case RED:
        colorStr = "Red";
        break;
      default:
        colorStr = "Neutral";
    }

    return brandStr + " " + colorStr + " " + kindStr + " (size " + size + ")";
  }

}   // ← **整个文件只在这里关一次 class**
