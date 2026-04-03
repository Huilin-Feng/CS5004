public class Mage extends GameCharacter {

  public Mage(String name, int health, int attack, int defense) {
    super(name, health, attack, defense);
  }

  @Override
  public GameCharacter clone() {
    return new Mage(name, health, attack, defense);
  }

  @Override
  public String getDescription() {
    return "Mage: " + toString();
  }
}
