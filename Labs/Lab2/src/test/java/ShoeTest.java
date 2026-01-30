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
  public void testToStringFormatLikeInstructor() {
    Shoe shoe = new Shoe(Kind.SNEAKER, Color.BLACK, Brand.NIKE, 8.5);

    String expected =
        "Brand: Nike\n" +
        "Kind: Sneaker\n" +
        "Color: Black\n" +
        "Size: 8.5";

    assertEquals(expected, shoe.toString());
  }

}

