public class Archer extends GameCharacter {

  public Archer(String name, int health, int attack, int defense) {
    super(name, health, attack, defense);
  }

  @Override
  public GameCharacter clone() {
    return new Archer(name, health, attack, defense);
  }

  @Override
  public String getDescription() {
    return "Archer: " + toString();
  }
}
