public class Main {
  public static void main(String[] args) {
    System.out.println("=== Smart Home Control System Demo ===");

    SmartDevice light = DeviceFactory.createDevice("light");
    SmartDevice speaker = DeviceFactory.createDevice("speaker");

    LegacyThermostat legacyThermostat = new LegacyThermostat();
    SmartDevice thermostatAdapter = new LegacyThermostatAdapter(legacyThermostat);

    SmartHomeController controller = SmartHomeController.getInstance();
    controller.addDevice(light);
    controller.addDevice(speaker);
    controller.addDevice(thermostatAdapter);

    System.out.println("\n=== Initial statuses ===");
    controller.showAllStatuses();

    System.out.println("\n=== Turn all devices on ===");
    controller.turnAllOn();
    controller.showAllStatuses();

    SmartHomeFacade facade = new SmartHomeFacade();

    System.out.println("\n=== Night mode ===");
    facade.activateNightMode();
    controller.showAllStatuses();

    System.out.println("\n=== Leave home ===");
    facade.leaveHome();
    controller.showAllStatuses();

    System.out.println("\n=== End of Problem 1 Demo ===");
  }
}
