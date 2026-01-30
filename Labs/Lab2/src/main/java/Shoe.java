/**
 * Represents a shoe with a kind, color, brand, and size.
 */
public class Shoe {

  private final Kind kind;
  private final Color color;
  private final Brand brand;
  private final double size;

  /**
   * Constructs a Shoe with the given attributes.
   *
   * @param kind  the kind of the shoe
   * @param color the color of the shoe
   * @param brand the brand of the shoe
   * @param size  the size of the shoe
   *
   * @throws IllegalArgumentException if the brand is NIKE and the kind is DRESS
   */
  public Shoe(Kind kind, Color color, Brand brand, double size) {
    if (brand == Brand.NIKE && kind == Kind.DRESS) {
      throw new IllegalArgumentException("NIKE does not sell dress shoes");
    }
    this.kind = kind;
    this.color = color;
    this.brand = brand;
    this.size = size;
  }

  /**
   * Gets the kind of this shoe.
   *
   * @return the shoe kind
   */
  public Kind getKind() {
    return kind;
  }

  /**
   * Gets the color of this shoe.
   *
   * @return the shoe color
   */
  public Color getColor() {
    return color;
  }

  /**
   * Gets the brand of this shoe.
   *
   * @return the shoe brand
   */
  public Brand getBrand() {
    return brand;
  }

  /**
   * Gets the size of this shoe.
   *
   * @return the shoe size
   */
  public double getSize() {
    return size;
  }

  /**
   * Returns a string representation of this shoe.
   *
   * @return a string containing the kind, color, brand, and size of the shoe
   */
  @Override
  public String toString() {
    String brandStr;
    switch (brand) {
      case NIKE -> brandStr = "Nike";
      case ADIDAS -> brandStr = "Adidas";
      case PUMA -> brandStr = "Puma";
      case VANS -> brandStr = "Vans";
      default -> brandStr = brand.toString();
    }

    String kindStr;
    switch (kind) {
      case SNEAKER -> kindStr = "Sneaker";
      case BOOT -> kindStr = "Boot";
      case DRESS -> kindStr = "Dress";
      case SANDAL -> kindStr = "Sandal";
      default -> kindStr = kind.toString();
    }

    String colorStr;
    switch (color) {
      case BLACK -> colorStr = "Black";
      case WHITE -> colorStr = "White"; // 更稳：WHITE 单独一个 case
      case RED -> colorStr = "Red";
      default -> colorStr = "Neutral";  // 例如 BEIGE 走这里，符合“别给每个颜色写 case”
    }

    return "Brand: " + brandStr + "\n"
        + "Kind: " + kindStr + "\n"
        + "Color: " + colorStr + "\n"
        + "Size: " + size;
  }
}
