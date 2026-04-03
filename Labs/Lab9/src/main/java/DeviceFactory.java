public class DeviceFactory {

  public static SmartDevice createDevice(String type) {
    if (type == null || type.trim().isEmpty()) {
      throw new IllegalArgumentException("Device type cannot be null or empty.");
    }

    switch (type.toLowerCase()) {
      case "light":
        return new SmartLight();
      case "speaker":
        return new SmartSpeaker();
      default:
        throw new IllegalArgumentException("Unknown device type: " + type);
    }
  }
}
