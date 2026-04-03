public class SmartLight implements SmartDevice {
  private boolean isOn;

  public SmartLight() {
    this.isOn = false;
  }

  @Override
  public void turnOn() {
    this.isOn = true;
  }

  @Override
  public void turnOff() {
    this.isOn = false;
  }

  @Override
  public String getStatus() {
    return this.isOn ? "SmartLight is ON" : "SmartLight is OFF";
  }

  @Override
  public String getDeviceType() {
    return "light";
  }
}
