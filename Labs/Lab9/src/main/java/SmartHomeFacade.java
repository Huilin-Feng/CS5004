public class SmartHomeFacade {
  private final SmartHomeController controller;

  public SmartHomeFacade() {
    this.controller = SmartHomeController.getInstance();
  }

  public void activateNightMode() {
    System.out.println("Activating night mode...");
    for (SmartDevice device : this.controller.getDevices()) {
      if (device.getDeviceType().equals("light")) {
        device.turnOff();
      } else if (device.getDeviceType().equals("speaker")) {
        device.turnOff();
      } else if (device.getDeviceType().equals("thermostat")) {
        device.turnOn();
      }
    }
  }

  public void leaveHome() {
    System.out.println("Leaving home...");
    this.controller.turnAllOff();
  }
}