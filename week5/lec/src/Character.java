public class Character {
    protected String name;
    protected float maxHp, currentHp, attack, defense;
    protected int intelligence, strength, agility;

    public Character(String name, float maxHp, float attack, float defense, int intelligence, int strength,
            int agility) {
        this.name = name;
        this.maxHp = maxHp;
        this.currentHp = maxHp;
        this.attack = attack;
        this.defense = defense;
        this.intelligence = intelligence;
        this.strength = strength;
        this.agility = agility;
    }
}
