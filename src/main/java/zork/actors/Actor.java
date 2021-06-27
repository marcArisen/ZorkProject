package zork.actors;

import zork.Location;

public abstract class Actor {

    int MaxHP;
    int CurrentHP;
    int AttackDamage;
    Location location; // where it is in the map

    public Actor(int MaxHP, int CurrentHP, int AttackDamage, Location location){
        this.MaxHP = MaxHP;
        this.CurrentHP = CurrentHP;
        this.AttackDamage = AttackDamage;
        this.location = location;
    }


}
