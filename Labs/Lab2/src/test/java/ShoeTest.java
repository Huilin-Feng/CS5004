import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ShoeTest {

  @Test
  public void testConstructorAndGetters() {
    Shoe shoe = new Shoe(Kind.SNEAKER, Color.BLACK, Brand.NIKE, 8.5);

    assertEquals(Kind.SNEAKER, shoe.getKind());
    assertEquals(Color.BLACK, shoe.getColor());
    assertEquals(Brand.NIKE, shoe.getBrand());
    assertEquals(8.5, shoe.getSize(), 0.0001);
  }

  @Test
  public void testConstructorThrowsForNikeDress() {
    IllegalArgumentException ex = assertThrows(
        IllegalArgumentException.class,
        () -> new Shoe(Kind.DRESS, Color.WHITE, Brand.NIKE, 9.0)
    );

    assertTrue(ex.getMessage().toLowerCase().contains("nike"));
  }

  @Test
  public void testToStringIncludesAllAttributes() {
    Shoe shoe = new Shoe(Kind.BOOT, Color.WHITE, Brand.ADIDAS, 7.0);
    String s = shoe.toString().toLowerCase();

    assertTrue(s.contains("adidas"));
    assertTrue(s.contains("boot"));
    assertTrue(s.contains("neutral"));
    assertTrue(s.contains("size 7.0"));
  }

  @Test
  public void testToStringColorCaseBlack() {
    Shoe shoe = new Shoe(Kind.SNEAKER, Color.BLACK, Brand.NIKE, 8.5);
    String s = shoe.toString().toLowerCase();

    assertTrue(s.contains("nike"));
    assertTrue(s.contains("sneaker"));
    assertTrue(s.contains("black"));
    assertTrue(s.contains("size 8.5"));
  }
}

