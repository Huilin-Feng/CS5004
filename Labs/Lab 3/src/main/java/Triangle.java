/**
 * This class represents a triangle defined by three points.
 * The first point is the reference point used for distanceFromOrigin().
 */
public class Triangle extends AbstractShape {

  private final Point2D p2;
  private final Point2D p3;

  /**
   * Construct a Triangle using three (x,y) points.
   * The first point (x1,y1) is the reference point.
   *
   * @param x1 x coordinate of reference point
   * @param y1 y coordinate of reference point
   * @param x2 x coordinate of second point
   * @param y2 y coordinate of second point
   * @param x3 x coordinate of third point
   * @param y3 y coordinate of third point
   * @throws IllegalArgumentException if any two points are identical
   */
  public Triangle(double x1, double y1,
      double x2, double y2,
      double x3, double y3) {
    super(new Point2D(x1, y1));
    Point2D tmp2 = new Point2D(x2, y2);
    Point2D tmp3 = new Point2D(x3, y3);

    if (samePoint(this.reference, tmp2)
        || samePoint(this.reference, tmp3)
        || samePoint(tmp2, tmp3)) {
      throw new IllegalArgumentException("Triangle cannot have identical points.");
    }

    this.p2 = tmp2;
    this.p3 = tmp3;
  }

  private boolean samePoint(Point2D a, Point2D b) {
    return Double.compare(a.getX(), b.getX()) == 0
        && Double.compare(a.getY(), b.getY()) == 0;
  }

  private double dist(Point2D a, Point2D b) {
    double dx = a.getX() - b.getX();
    double dy = a.getY() - b.getY();
    return Math.sqrt(dx * dx + dy * dy);
  }

  @Override
  public double perimeter() {
    double a = dist(this.reference, this.p2);
    double b = dist(this.p2, this.p3);
    double c = dist(this.p3, this.reference);
    return a + b + c;
  }

  @Override
  public double area() {
    double a = dist(this.reference, this.p2);
    double b = dist(this.p2, this.p3);
    double c = dist(this.p3, this.reference);

    double s = (a + b + c) / 2.0;
    double inside = s * (s - a) * (s - b) * (s - c);

    if (inside < 0 && inside > -1e-12) {
      inside = 0;
    }

    return Math.sqrt(inside);
  }

  @Override
  public Shape resize(double factor) {
    if (factor <= 0) {
      throw new IllegalArgumentException("Resize factor must be positive.");
    }
    double sqrtFactor = Math.sqrt(factor);

    double x1 = this.reference.getX();
    double y1 = this.reference.getY();

    double newX2 = x1 + sqrtFactor * (this.p2.getX() - x1);
    double newY2 = y1 + sqrtFactor * (this.p2.getY() - y1);

    double newX3 = x1 + sqrtFactor * (this.p3.getX() - x1);
    double newY3 = y1 + sqrtFactor * (this.p3.getY() - y1);

    return new Triangle(x1, y1, newX2, newY2, newX3, newY3);
  }

  @Override
  public String toString() {
    return String.format(
        "Triangle: (%.3f,%.3f) (%.3f,%.3f) (%.3f,%.3f)",
        this.reference.getX(), this.reference.getY(),
        this.p2.getX(), this.p2.getY(),
        this.p3.getX(), this.p3.getY()
    );
  }
}
