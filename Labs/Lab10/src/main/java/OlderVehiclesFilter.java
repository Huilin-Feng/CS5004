import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Represents a filter for retrieving older vehicles.
 */
public class OlderVehiclesFilter {
  private List<Vehicle> vehicles = new ArrayList<>();

  /**
   * Creates an OlderVehiclesFilter with a given list of vehicles.
   *
   * @param vehicles the list of vehicles
   */
  public OlderVehiclesFilter(List<Vehicle> vehicles) {
    this.vehicles = vehicles;
  }

  /**
   * Creates an OlderVehiclesFilter with three vehicle objects.
   *
   * @param vehicle1 the first vehicle
   * @param vehicle2 the second vehicle
   * @param vehicle3 the third vehicle
   */
  public OlderVehiclesFilter(Vehicle vehicle1, Vehicle vehicle2, Vehicle vehicle3) {
    this.vehicles.add(vehicle1);
    this.vehicles.add(vehicle2);
    this.vehicles.add(vehicle3);
  }

  /**
   * Filters all vehicles manufactured before 1999 and returns their
   * make, model, and year as strings.
   *
   * @return a list of formatted strings for vehicles made before 1999
   */
  public List<String> filterOlderVehicles() {
    return this.vehicles.stream()
        .filter(vehicle -> vehicle.getYear() < 1999)
        .map(vehicle -> vehicle.getMake() + " " + vehicle.getModel() + " " + vehicle.getYear())
        .collect(Collectors.toList());
  }
}