public class CharacterManager {

  public void demonstrate() {
    System.out.println("=== Game Character Creation System Demo ===");

    System.out.println("\n=== Factory Method Demo ===");
    GameCharacter tank = CharacterFactory.createCharacter("tank", "Brutus");
    GameCharacter dps = CharacterFactory.createCharacter("dps", "Robin");
    GameCharacter support = CharacterFactory.createCharacter("support", "Luna");

    System.out.println(tank.getDescription());
    System.out.println(dps.getDescription());
    System.out.println(support.getDescription());

    System.out.println("\n=== Builder Demo ===");
    GameCharacter builtMage = new CharacterBuilder("mage")
        .setName("Mystra")
        .setHealth(85)
        .setAttack(30)
        .setDefense(12)
        .addEquipment(new BasicEquipment("Magic Staff", 10, 0))
        .addEquipment(new BasicEquipment("Magic Robe", 0, 5))
        .build();

    System.out.println(builtMage.getDescription());

    System.out.println("\n=== Prototype Demo ===");
    GameCharacter clonedTank = tank.clone();
    clonedTank.setName("Brutus Clone");
    clonedTank.setDefense(clonedTank.getDefense() + 5);
    System.out.println(clonedTank.getDescription());

    System.out.println("\n=== Decorator Demo ===");
    Equipment sword = new BasicEquipment("Sword", 15, 0);
    Equipment heavyArmor = new BasicEquipment("Heavy Armor", 0, 20);

    GameCharacter decoratedCharacter = new WeaponDecorator(tank, sword);
    decoratedCharacter = new ArmorDecorator(decoratedCharacter, heavyArmor);

    System.out.println(decoratedCharacter.getDescription());
    System.out.println(decoratedCharacter.toString());

    System.out.println("\n=== End of Problem 2 Demo ===");
  }
}
