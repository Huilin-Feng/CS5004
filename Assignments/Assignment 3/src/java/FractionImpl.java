/**
 * Concrete implementation of the Fraction interface.
 * <p>
 * Invariant: the denominator is always positive. Any sign is stored in the numerator.
 * The fraction is always maintained in simplest form (reduced by gcd).
 */
public class FractionImpl implements Fraction {

  private int numerator;
  private int denominator;

  /**
   * Constructs a fraction with the given numerator and denominator.
   * Denominator must be strictly positive.
   *
   * @param numerator the numerator
   * @param denominator the denominator (must be > 0)
   * @throws IllegalArgumentException if denominator <= 0
   */
  public FractionImpl(int numerator, int denominator) {
    setNormalized(numerator, denominator);
  }

  /**
   * Centralized validation + normalization to avoid duplicated validation code.
   * Enforces denominator > 0, reduces by gcd, and normalizes 0 to 0/1.
   */
  private void setNormalized(int n, int d) {
    if (d <= 0) {
      throw new IllegalArgumentException("Denominator must be > 0.");
    }

    // Normalize zero numerator to 0/1
    if (n == 0) {
      this.numerator = 0;
      this.denominator = 1;
      return;
    }

    // Reduce to simplest form
    int g = gcd(Math.abs(n), d);
    n /= g;
    d /= g;

    // Denominator is guaranteed positive by the check above.
    this.numerator = n;
    this.denominator = d;
  }

  /**
   * Euclid's algorithm for greatest common divisor.
   * Assumes inputs are non-negative.
   */
  private static int gcd(int a, int b) {
    if (b == 0) {
      return a;
    }
    return gcd(b, a % b);
  }

  @Override
  public int getNumerator() {
    return numerator;
  }

  @Override
  public int getDenominator() {
    return denominator;
  }

  @Override
  public void setNumerator(int n) {
    setNormalized(n, this.denominator);
  }

  @Override
  public void setDenominator(int d) {
    setNormalized(this.numerator, d);
  }

  @Override
  public double toDouble() {
    return ((double) numerator) / denominator;
  }

  /**
   * Returns a String depiction of this fraction in simplest form as "a / b".
   *
   * @return string form "numerator / denominator"
   */
  @Override
  public String toString() {
    return numerator + " / " + denominator;
  }

  @Override
  public Fraction reciprocal() {
    if (numerator == 0) {
      throw new IllegalArgumentException("Cannot take reciprocal of 0.");
    }

    int newNum = denominator;
    int newDen = numerator;

    // Ensure denominator positive for constructor requirement
    if (newDen < 0) {
      newNum = -newNum;
      newDen = -newDen;
    }

    return new FractionImpl(newNum, newDen);
  }

  @Override
  public Fraction add(Fraction other) {
    if (other == null) {
      throw new IllegalArgumentException("Other fraction cannot be null.");
    }

    // a/b + c/d = (ad + bc) / bd
    long a = this.numerator;
    long b = this.denominator;
    long c = other.getNumerator();
    long d = other.getDenominator();

    long num = a * d + c * b;
    long den = b * d;

    // Constructor will reduce; denominator will be positive.
    return new FractionImpl((int) num, (int) den);
  }

  @Override
  public int compareTo(Fraction other) {
    if (other == null) {
      throw new IllegalArgumentException("Other fraction cannot be null.");
    }

    // Compare a/b and c/d by cross-multiplication to avoid double rounding errors
    long left = (long) this.numerator * (long) other.getDenominator();
    long right = (long) other.getNumerator() * (long) this.denominator;

    return Long.compare(left, right);
  }
}
