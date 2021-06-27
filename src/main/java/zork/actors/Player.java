package zork.actors;

import zork.Location;
import zork.items.Item;

import java.util.ArrayList;
import java.util.List;

public class Player extends Actor{

    List<Item> Inventory = new ArrayList<>();


    public Player(int MaxHP, int CurrentHP, int AttackDamage, Location location) {
        super(MaxHP, CurrentHP, AttackDamage, location);
    }
}
