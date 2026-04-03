import java.util.ArrayList;
import java.util.List;

public class SmartHomeController {
  private static SmartHomeController instance;
  private final List<SmartDevice> devices;

  private SmartHomeController() {
    this.devices = new ArrayList<>();
  }

  public static SmartHomeController getInstance() {
    if (instance == null) {
      instance = new SmartHomeController();
    }
    return instance;
  }

  public void addDevice(SmartDevice device) {
    if (device == null) {
      throw new IllegalArgumentException("Device cannot be null.");
    }
    this.devices.add(device);
  }

  public void turnAllOn() {
    for (SmartDevice device : this.devices) {
      device.turnOn();
    }
  }

  public void turnAllOff() {
    for (SmartDevice device : this.devices) {
      device.turnOff();
    }
  }

  public void showAllStatuses() {
    for (SmartDevice device : this.devices) {
      System.out.println(device.getStatus());
    }
  }

  public List<SmartDevice> getDevices() {
    return new ArrayList<>(this.devices);
  }
}