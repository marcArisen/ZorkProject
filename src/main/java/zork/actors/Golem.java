package zork.actors;

import zork.Game;
import zork.Location;

public class Golem extends Monster{

    public Golem(Game game, Location location) {
        super(game, 150, 30, location);
    }
}
