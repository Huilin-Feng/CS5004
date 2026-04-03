public class LegacyThermostat {
  private boolean active;
  private int currentTemp;

  public LegacyThermostat() {
    this.active = false;
    this.currentTemp = 72;
  }

  public void activate() {
    this.active = true;
  }

  public void deactivate() {
    this.active = false;
  }

  public int getCurrentTemp() {
    return this.currentTemp;
  }

  public boolean isActive() {
    return this.active;
  }
}
