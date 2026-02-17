import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class FractionImplTest {

  // ---------- Constructor / normalization / invariants ----------

  @Test
  void constructorRejectsNonPositiveDenominator() {
    assertThrows(IllegalArgumentException.class, () -> new FractionImpl(1, 0));
    assertThrows(IllegalArgumentException.class, () -> new FractionImpl(1, -2));
  }

  @Test
  void constructorNormalizesZeroToZeroOverOne() {
    Fraction z = new FractionImpl(0, 5);
    assertEquals(0, z.getNumerator());
    assertEquals(1, z.getDenominator());
    assertEquals("0 / 1", z.toString());
  }

  @Test
  void constructorReducesToSimplestForm() {
    Fraction f = new FractionImpl(4, 2);
    assertEquals("2 / 1", f.toString());

    Fraction g = new FractionImpl(2, 4);
    assertEquals("1 / 2", g.toString());

    Fraction h = new FractionImpl(-6, 8);
    assertEquals("-3 / 4", h.toString());
  }

  // ---------- Getters / setters ----------

  @Test
  void gettersReturnCurrentValues() {
    Fraction f = new FractionImpl(3, 7);
    assertEquals(3, f.getNumerator());
    assertEquals(7, f.getDenominator());
  }

  @Test
  void setNumeratorKeepsSimplestForm() {
    Fraction f = new FractionImpl(2, 4); // becomes 1/2
    assertEquals("1 / 2", f.toString());

    f.setNumerator(2); // 2/2 -> 1/1 after reduction
    assertEquals("1 / 1", f.toString());
  }

  @Test
  void setDenominatorRejectsNonPositive() {
    Fraction f = new FractionImpl(1, 2);
    assertThrows(IllegalArgumentException.class, () -> f.setDenominator(0));
    assertThrows(IllegalArgumentException.class, () -> f.setDenominator(-3));
  }

  @Test
  void setDenominatorKeepsSimplestForm() {
    Fraction f = new FractionImpl(1, 2);
    f.setDenominator(4); // 1/4 simplest
    assertEquals("1 / 4", f.toString());

    f.setDenominator(6); // 1/6 simplest
    assertEquals("1 / 6", f.toString());
  }

  // ---------- toDouble / toString ----------

  @Test
  void toDoubleWorksForPositiveAndNegative() {
    Fraction a = new FractionImpl(1, 2);
    assertEquals(0.5, a.toDouble(), 1e-12);

    Fraction b = new FractionImpl(-1, 2);
    assertEquals(-0.5, b.toDouble(), 1e-12);
  }

  @Test
  void toStringAlwaysReturnsSimplestForm() {
    Fraction f = new FractionImpl(10, 20);
    assertEquals("1 / 2", f.toString());

    Fraction g = new FractionImpl(-10, 20);
    assertEquals("-1 / 2", g.toString());
  }

  // ---------- reciprocal ----------

  @Test
  void reciprocalWorksAndStaysSimplified() {
    Fraction f = new FractionImpl(2, 3);
    assertEquals("3 / 2", f.reciprocal().toString());

    Fraction g = new FractionImpl(-2, 3);
    assertEquals("-3 / 2", g.reciprocal().toString());
  }

  @Test
  void reciprocalThrowsForZeroNumerator() {
    Fraction z = new FractionImpl(0, 7);
    assertThrows(IllegalArgumentException.class, z::reciprocal);
  }

  // ---------- add ----------

  @Test
  void addWorksWithDifferentDenominators() {
    Fraction a = new FractionImpl(1, 2);
    Fraction b = new FractionImpl(1, 3);
    assertEquals("5 / 6", a.add(b).toString());
  }

  @Test
  void addWorksWithNegatives() {
    Fraction a = new FractionImpl(-1, 2);
    Fraction b = new FractionImpl(1, 3);
    assertEquals("-1 / 6", a.add(b).toString());
  }

  @Test
  void addThrowsOnNull() {
    Fraction a = new FractionImpl(1, 2);
    assertThrows(IllegalArgumentException.class, () -> a.add(null));
  }

  // ---------- compareTo ----------

  @Test
  void compareToReturnsCorrectSigns() {
    Fraction a = new FractionImpl(1, 2);
    Fraction b = new FractionImpl(2, 3);

    assertTrue(a.compareTo(b) < 0);
    assertTrue(b.compareTo(a) > 0);

    Fraction c = new FractionImpl(2, 4); // equals 1/2
    assertEquals(0, a.compareTo(c));
  }

  @Test
  void compareToThrowsOnNull() {
    Fraction a = new FractionImpl(1, 2);
    assertThrows(IllegalArgumentException.class, () -> a.compareTo(null));
  }
}

