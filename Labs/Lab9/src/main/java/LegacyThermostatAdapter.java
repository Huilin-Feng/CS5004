public class LegacyThermostatAdapter implements SmartDevice {
  private final LegacyThermostat legacyThermostat;

  public LegacyThermostatAdapter(LegacyThermostat legacyThermostat) {
    if (legacyThermostat == null) {
      throw new IllegalArgumentException("Legacy thermostat cannot be null.");
    }
    this.legacyThermostat = legacyThermostat;
  }

  @Override
  public void turnOn() {
    this.legacyThermostat.activate();
  }

  @Override
  public void turnOff() {
    this.legacyThermostat.deactivate();
  }

  @Override
  public String getStatus() {
    String state = this.legacyThermostat.isActive() ? "ON" : "OFF";
    return "LegacyThermostat is " + state
        + ", current temperature: " + this.legacyThermostat.getCurrentTemp();
  }

  @Override
  public String getDeviceType() {
    return "thermostat";
  }
}
