package zork.actors;

import zork.Location;
import zork.items.Item;
import zork.items.StoneSword;
import zork.items.Weapon;

import java.util.ArrayList;
import java.util.List;

public class Player extends Actor{

    List<Item> Inventory = new ArrayList<>();


    public Player(int MaxHP, int AttackDamage, Location location) {
        super(MaxHP, AttackDamage, location);
        //player takes Stone Sword at the start of the game
        take(new StoneSword());
    }

    public List<Item> getInventory() {
        return Inventory;
    }

    //Method to move to another locations
    public void move(Location direction){
        this.setLocation(direction);
    }


    public void take(Item item){
        Inventory.add(item);
    }

    public void setWeapon(Weapon item){
        this.setAttackDamage(item.getDamage());
    }

}
