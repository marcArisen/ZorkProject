package zork.actors;

import zork.Game;
import zork.Location;

public class Monster extends Actor{


    public Monster(Game game, int MaxHP, int AttackDamage, Location location) {
        super(MaxHP, AttackDamage, location);
        location.setMonster(this);
        game.addMonsters(this);
    }


}

