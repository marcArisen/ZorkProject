package zork.actors;

import zork.Game;
import zork.Location;

public class Boss extends Monster{
    public Boss(Game game, Location location) {
        super(game, 300, 100, location);
    }
}
