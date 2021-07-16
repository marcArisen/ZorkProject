package zork.items;

public class Weapon extends Item{

    private int Damage;
    public Weapon(String name, String description, int damage) {
        super(name, description);
        this.Damage = damage;
    }


    public int getDamage() {
        return Damage;
    }
}
