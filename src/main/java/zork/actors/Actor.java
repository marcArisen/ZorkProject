package zork.actors;

import zork.Location;

public abstract class Actor {

    private boolean alive = true;
    private int MaxHP;
    private int CurrentHP;
    private int AttackDamage;
    private Location location; // where it is in the map

    public Actor(int MaxHP, int AttackDamage, Location location){
        this.MaxHP = MaxHP;
        this.CurrentHP = MaxHP;
        this.AttackDamage = AttackDamage;
        this.location = location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public int getMaxHP() {
        return MaxHP;
    }

    public Location getLocation() {
        return location;
    }

    public void setAttackDamage(int attackDamage) {
        AttackDamage = attackDamage;
    }

    public int getAttackDamage() {
        return AttackDamage;
    }

    public int getCurrentHP() {
        return CurrentHP;
    }

    public boolean isAlive() {
        return alive;
    }

    public int attack(Actor target){
        int damaged = this.AttackDamage;
        target.CurrentHP = target.CurrentHP - this.AttackDamage;
        return damaged;
    }

    public String getName(){
        return this.getClass().getSimpleName();
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }
}
