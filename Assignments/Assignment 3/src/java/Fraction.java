/**
 * Represents a rational number as a numerator over a positive denominator.
 * The denominator is always positive; any sign is stored in the numerator.
 */
public interface Fraction extends Comparable<Fraction> {

  /**
   * Returns the numerator of this fraction.
   *
   * @return the numerator (may be negative, zero, or positive)
   */
  int getNumerator();

  /**
   * Returns the denominator of this fraction.
   *
   * @return the denominator (always positive)
   */
  int getDenominator();

  /**
   * Sets the numerator of this fraction.
   *
   * @param n the new numerator
   */
  void setNumerator(int n);

  /**
   * Sets the denominator of this fraction.
   *
   * @param d the new denominator (must be > 0)
   * @throws IllegalArgumentException if d <= 0
   */
  void setDenominator(int d);

  /**
   * Returns the decimal (double) representation of this fraction.
   *
   * @return the decimal value
   */
  double toDouble();

  /**
   * Returns the reciprocal of this fraction.
   *
   * @return a new Fraction representing the reciprocal
   * @throws IllegalArgumentException if numerator is 0
   */
  Fraction reciprocal();

  /**
   * Adds this fraction to another fraction.
   *
   * @param other the other fraction
   * @return the sum as a new Fraction
   * @throws IllegalArgumentException if other is null
   */
  Fraction add(Fraction other);

  /**
   * Compares this fraction to another fraction.
   *
   * @param other the other fraction
   * @return negative if this < other,
   *         0 if equal,
   *         positive if this > other
   * @throws IllegalArgumentException if other is null
   */
  @Override
  int compareTo(Fraction other);
}


