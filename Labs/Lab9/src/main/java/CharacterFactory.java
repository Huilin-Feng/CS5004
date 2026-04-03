public class CharacterFactory {

  public static GameCharacter createCharacter(String template, String name) {
    if (template == null || template.trim().isEmpty()) {
      throw new IllegalArgumentException("Template cannot be null or empty.");
    }

    switch (template.toLowerCase()) {
      case "tank":
        return new Warrior(name, 150, 20, 40);
      case "dps":
        return new Archer(name, 100, 40, 15);
      case "support":
        return new Mage(name, 90, 25, 20);
      default:
        throw new IllegalArgumentException("Unknown template: " + template);
    }
  }
}