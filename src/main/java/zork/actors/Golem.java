package zork.actors;

import zork.Game;
import zork.Location;

public class Golem extends Monster{

    public Golem(Game game, int MaxHP, int AttackDamage, Location location) {
        super(game, 200, 40, location);
    }
}
