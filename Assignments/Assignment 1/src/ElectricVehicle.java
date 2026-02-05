import java.text.DecimalFormat;

/**
 * Represents an electric vehicle and its driving range.
 */
public class ElectricVehicle {

  private String name;
  private double batterySize;
  private double stateOfCharge;
  private double currentEfficiency;
  private double defaultEfficiency;

  /**
   * Clamps a value to the given range.
   *
   * @param value the value to clamp
   * @param min   minimum allowed value
   * @param max   maximum allowed value
   * @return the clamped value
   */
  private double clamp(double value, double min, double max) {
    if (value < min) {
      return min;
    }
    if (value > max) {
      return max;
    }
    return value;
  }

  /**
   * Constructs an ElectricVehicle.
   *
   * @param name the name of the vehicle
   * @param batterySize the battery size in kWh
   * @param stateOfCharge the state of charge (0.15 to 1.0)
   * @param defaultEfficiency the rated efficiency
   */
  public ElectricVehicle(String name,
      double batterySize,
      double stateOfCharge,
      double defaultEfficiency) {

    // name handling
    if (name == null || name.length() == 0) {
      this.name = "unknown EV";
    } else {
      this.name = name;
    }

    // clamp values
    this.batterySize = clamp(batterySize, 10.0, 150.0);
    this.defaultEfficiency = clamp(defaultEfficiency, 0.5, 4.5);
    this.stateOfCharge = clamp(stateOfCharge, 0.15, 1.0);

    // current efficiency starts as default efficiency
    this.currentEfficiency = this.defaultEfficiency;
  }

  /**
   * Computes the estimated range of the EV in miles.
   *
   * @return the range in miles
   */
  public double range() {
    return this.currentEfficiency * this.stateOfCharge * this.batterySize;
  }

  /**
   * Returns the current efficiency (not the default efficiency).
   *
   * @return the current efficiency
   */
  public double getEfficiency() {
    return this.currentEfficiency;
  }

  /**
   * Returns the battery size in kWh.
   *
   * @return the battery size
   */
  public double getBatterySize() {
    return this.batterySize;
  }

  /**
   * Returns the current state of charge (decimal form).
   *
   * @return the state of charge
   */
  public double getStateOfCharge() {
    return this.stateOfCharge;
  }

  /**
   * Returns the name of this EV.
   *
   * @return the name
   */
  public String getName() {
    return this.name;
  }

  /**
   * Sets the state of charge (decimal form) and clamps it to [0.15, 1.0].
   *
   * @param stateOfCharge the new state of charge
   */
  public void setStateOfCharge(double stateOfCharge) {
    this.stateOfCharge = clamp(stateOfCharge, 0.15, 1.0);
  }

  /**
   * Updates the current efficiency based on the outside temperature in Fahrenheit.
   *
   * Rules:
   * - If 65.0 <= temp <= 77.0: current efficiency = 100% of default efficiency
   * - If temp > 77.0: current efficiency = 85% of default efficiency
   * - If temp < 65.0: efficiency decreases by 1% per degree below 65,
   *   capped at 50% of default efficiency
   *
   * @param currentTemp the current temperature in Fahrenheit
   */
  public void updateEfficiency(double currentTemp) {
    if (currentTemp >= 65.0 && currentTemp <= 77.0) {
      this.currentEfficiency = this.defaultEfficiency;
    } else if (currentTemp > 77.0) {
      this.currentEfficiency = 0.85 * this.defaultEfficiency;
    } else {
      double drop = 0.01 * (65.0 - currentTemp);
      double factor = 1.0 - drop;
      if (factor < 0.5) {
        factor = 0.5;
      }
      this.currentEfficiency = factor * this.defaultEfficiency;
    }
  }

  /**
   * Returns a string representation of this ElectricVehicle.
   *
   * Format:
   * Name SOC: XX.X% Range (miles): YY.Y
   *
   * @return the string representation
   */
  @Override
  public String toString() {
    DecimalFormat oneDecimal = new DecimalFormat("0.0");

    String socPercent = oneDecimal.format(this.stateOfCharge * 100);
    String rangeMiles = oneDecimal.format(this.range());

    return this.name
        + " SOC: "
        + socPercent
        + "% Range (miles): "
        + rangeMiles;
  }
}
