import java.util.ArrayList;
import java.util.List;

public class CharacterBuilder {
  private String type;
  private String name;
  private int health;
  private int attack;
  private int defense;
  private List<Equipment> equipments;

  public CharacterBuilder(String type) {
    this.type = type;
    this.equipments = new ArrayList<>();
  }

  public CharacterBuilder setName(String name) {
    this.name = name;
    return this;
  }

  public CharacterBuilder setHealth(int health) {
    this.health = health;
    return this;
  }

  public CharacterBuilder setAttack(int attack) {
    this.attack = attack;
    return this;
  }

  public CharacterBuilder setDefense(int defense) {
    this.defense = defense;
    return this;
  }

  public CharacterBuilder addEquipment(Equipment equipment) {
    equipments.add(equipment);
    return this;
  }

  public GameCharacter build() {
    for (Equipment equipment : equipments) {
      attack += equipment.getAttackBonus();
      defense += equipment.getDefenseBonus();
    }

    switch (type.toLowerCase()) {
      case "warrior":
        return new Warrior(name, health, attack, defense);
      case "mage":
        return new Mage(name, health, attack, defense);
      case "archer":
        return new Archer(name, health, attack, defense);
      default:
        throw new IllegalArgumentException("Unknown character type: " + type);
    }
  }
}
