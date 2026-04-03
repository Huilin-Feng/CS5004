public class Warrior extends GameCharacter {

  public Warrior(String name, int health, int attack, int defense) {
    super(name, health, attack, defense);
  }

  @Override
  public GameCharacter clone() {
    return new Warrior(name, health, attack, defense);
  }

  @Override
  public String getDescription() {
    return "Warrior: " + toString();
  }
}
