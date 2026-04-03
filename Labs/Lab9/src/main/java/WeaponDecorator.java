public class WeaponDecorator extends GameCharacter {
  private GameCharacter character;
  private Equipment weapon;

  public WeaponDecorator(GameCharacter character, Equipment weapon) {
    super(character.getName(),
        character.getHealth(),
        character.getAttack() + weapon.getAttackBonus(),
        character.getDefense() + weapon.getDefenseBonus());
    this.character = character;
    this.weapon = weapon;
  }

  @Override
  public GameCharacter clone() {
    return new WeaponDecorator(character.clone(),
        new BasicEquipment(
            weapon.getDescription(),
            weapon.getAttackBonus(),
            weapon.getDefenseBonus()));
  }

  @Override
  public String getDescription() {
    return character.getDescription() + ", Equipped with " + weapon.getDescription();
  }
}
