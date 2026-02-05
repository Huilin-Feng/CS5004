import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for the ElectricVehicle class.
 */
public class ElectricVehicleTest {

  private static final double DELTA = 0.0001;

  /**
   * Tests that a null name is replaced with "unknown EV".
   */
  @Test
  public void testConstructorNullNameBecomesUnknown() {
    ElectricVehicle ev = new ElectricVehicle(null, 50.0, 0.50, 3.0);
    assertEquals("unknown EV", ev.getName());
  }

  /**
   * Tests that an empty name is replaced with "unknown EV".
   */
  @Test
  public void testConstructorEmptyNameBecomesUnknown() {
    ElectricVehicle ev = new ElectricVehicle("", 50.0, 0.50, 3.0);
    assertEquals("unknown EV", ev.getName());
  }

  /**
   * Tests battery size clamping at the lower bound (10.0).
   */
  @Test
  public void testConstructorClampsBatterySizeLow() {
    ElectricVehicle ev = new ElectricVehicle("A", 1.0, 0.50, 3.0);
    assertEquals(10.0, ev.getBatterySize(), DELTA);
  }

  /**
   * Tests battery size clamping at the upper bound (150.0).
   */
  @Test
  public void testConstructorClampsBatterySizeHigh() {
    ElectricVehicle ev = new ElectricVehicle("A", 500.0, 0.50, 3.0);
    assertEquals(150.0, ev.getBatterySize(), DELTA);
  }

  /**
   * Tests default efficiency clamping at the lower bound (0.5) and that
   * current efficiency starts equal to default efficiency.
   */
  @Test
  public void testConstructorClampsDefaultEfficiencyLowAndSetsCurrent() {
    ElectricVehicle ev = new ElectricVehicle("A", 50.0, 0.50, 0.1);
    assertEquals(0.5, ev.getEfficiency(), DELTA);
  }

  /**
   * Tests default efficiency clamping at the upper bound (4.5) and that
   * current efficiency starts equal to default efficiency.
   */
  @Test
  public void testConstructorClampsDefaultEfficiencyHighAndSetsCurrent() {
    ElectricVehicle ev = new ElectricVehicle("A", 50.0, 0.50, 10.0);
    assertEquals(4.5, ev.getEfficiency(), DELTA);
  }

  /**
   * Tests state of charge clamping at the lower bound (0.15).
   */
  @Test
  public void testConstructorClampsSocLow() {
    ElectricVehicle ev = new ElectricVehicle("A", 50.0, 0.01, 3.0);
    assertEquals(0.15, ev.getStateOfCharge(), DELTA);
  }

  /**
   * Tests state of charge clamping at the upper bound (1.0).
   */
  @Test
  public void testConstructorClampsSocHigh() {
    ElectricVehicle ev = new ElectricVehicle("A", 50.0, 2.0, 3.0);
    assertEquals(1.0, ev.getStateOfCharge(), DELTA);
  }

  /**
   * Tests setStateOfCharge clamps values into [0.15, 1.0].
   */
  @Test
  public void testSetStateOfChargeClamps() {
    ElectricVehicle ev = new ElectricVehicle("A", 50.0, 0.50, 3.0);

    ev.setStateOfCharge(0.01);
    assertEquals(0.15, ev.getStateOfCharge(), DELTA);

    ev.setStateOfCharge(2.0);
    assertEquals(1.0, ev.getStateOfCharge(), DELTA);
  }

  /**
   * Tests range calculation with easy-to-check numbers.
   */
  @Test
  public void testRangeCalculation() {
    // batterySize=100, SoC=0.5, efficiency=3.0 => range = 3.0 * 0.5 * 100 = 150
    ElectricVehicle ev = new ElectricVehicle("A", 100.0, 0.50, 3.0);
    assertEquals(150.0, ev.range(), DELTA);
  }

  /**
   * Tests updateEfficiency within [65, 77] sets efficiency to 100% of default.
   */
  @Test
  public void testUpdateEfficiencyComfortTempIsDefault() {
    ElectricVehicle ev = new ElectricVehicle("A", 50.0, 0.50, 3.0);

    ev.updateEfficiency(65.0);
    assertEquals(3.0, ev.getEfficiency(), DELTA);

    ev.updateEfficiency(77.0);
    assertEquals(3.0, ev.getEfficiency(), DELTA);

    ev.updateEfficiency(70.0);
    assertEquals(3.0, ev.getEfficiency(), DELTA);
  }

  /**
   * Tests updateEfficiency above 77 sets efficiency to 85% of default.
   */
  @Test
  public void testUpdateEfficiencyHotTempIsEightyFivePercent() {
    ElectricVehicle ev = new ElectricVehicle("A", 50.0, 0.50, 4.0);

    ev.updateEfficiency(80.0);
    assertEquals(0.85 * 4.0, ev.getEfficiency(), DELTA);
  }

  /**
   * Tests updateEfficiency below 65 reduces by 1% per degree (with decimals allowed).
   */
  @Test
  public void testUpdateEfficiencyColdTempDropsOnePercentPerDegree() {
    ElectricVehicle ev = new ElectricVehicle("A", 50.0, 0.50, 4.0);

    // 64.0 => 1 degree below => factor 0.99
    ev.updateEfficiency(64.0);
    assertEquals(0.99 * 4.0, ev.getEfficiency(), DELTA);

    // 60.0 => 5 degrees below => factor 0.95
    ev.updateEfficiency(60.0);
    assertEquals(0.95 * 4.0, ev.getEfficiency(), DELTA);
  }

  /**
   * Tests updateEfficiency cold cap: efficiency never goes below 50% of default.
   */
  @Test
  public void testUpdateEfficiencyColdTempHasFiftyPercentFloor() {
    ElectricVehicle ev = new ElectricVehicle("A", 50.0, 0.50, 4.0);

    // Very cold: factor would be less than 0.5, but must floor to 0.5
    ev.updateEfficiency(0.0);
    assertEquals(0.5 * 4.0, ev.getEfficiency(), DELTA);
  }

  /**
   * Tests toString formatting includes 1 decimal SOC% and 1 decimal range.
   */
  @Test
  public void testToStringFormat() {
    ElectricVehicle ev = new ElectricVehicle("Ford MachE", 100.0, 0.50, 3.0);
    // range = 150.0, SOC% = 50.0%
    assertEquals("Ford MachE SOC: 50.0% Range (miles): 150.0", ev.toString());
  }

  /**
   * Tests toString reflects updated SoC and updated efficiency effects on range.
   */
  @Test
  public void testToStringReflectsStateAndEfficiencyChanges() {
    ElectricVehicle ev = new ElectricVehicle("A", 100.0, 0.50, 4.0);

    // Make it hot: efficiency = 0.85 * 4.0 = 3.4
    ev.updateEfficiency(90.0);

    // Change SoC to 1.0 => SOC% 100.0, range = 3.4 * 1.0 * 100 = 340.0
    ev.setStateOfCharge(1.0);

    assertEquals("A SOC: 100.0% Range (miles): 340.0", ev.toString());
  }
}

