public class ArmorDecorator extends GameCharacter {
  private GameCharacter character;
  private Equipment armor;

  public ArmorDecorator(GameCharacter character, Equipment armor) {
    super(character.getName(),
        character.getHealth(),
        character.getAttack() + armor.getAttackBonus(),
        character.getDefense() + armor.getDefenseBonus());
    this.character = character;
    this.armor = armor;
  }

  @Override
  public GameCharacter clone() {
    return new ArmorDecorator(character.clone(),
        new BasicEquipment(
            armor.getDescription(),
            armor.getAttackBonus(),
            armor.getDefenseBonus()));
  }

  @Override
  public String getDescription() {
    return character.getDescription() + ", Equipped with " + armor.getDescription();
  }
}
