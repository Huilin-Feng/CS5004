public class SmartSpeaker implements SmartDevice {
  private boolean isOn;

  public SmartSpeaker() {
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
    return this.isOn ? "SmartSpeaker is ON" : "SmartSpeaker is OFF";
  }

  @Override
  public String getDeviceType() {
    return "speaker";
  }
}