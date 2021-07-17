package zork.actors;

import zork.Location;
import zork.items.Item;
import zork.items.StoneSword;
import zork.items.Weapon;

import java.util.ArrayList;
import java.util.List;

public class Player extends Actor{

    List<Item> Inventory = new ArrayList<>();

    private int weaponAttack;

    public void setInventory(List<Item> inventory) {
        Inventory = inventory;
    }

    public int getWeaponAttack() {
        return weaponAttack;
    }

    @Override
    public int attack(Actor target) {
        int damaged = this.getAttackDamage() + this.getWeaponAttack();
        target.setCurrentHP(target.getCurrentHP() - damaged);
        return damaged;
    }

//    public int attackWithWeapon(Actor target){
//        int damaged = this.AttackDamage;
//        target.CurrentHP = target.CurrentHP - this.AttackDamage;
//        return damaged;
//    }


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
        this.healHp(10);
        this.setLocation(direction);
    }


    public void take(Item item){
        Inventory.add(item);
    }

    public void setWeapon(Weapon item){
        this.weaponAttack = item.getDamage();
        //this.setAttackDamage(item.getDamage());
    }

    public void eliminatedMonster(){
        this.setAttackDamage(this.getAttackDamage()+5);
    }
}
