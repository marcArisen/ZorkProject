package zork.actors;

import zork.Game;
import zork.Location;

public class Ghost extends Monster{

    public Ghost(Game game, Location location) {
        super(game, 200, 40, location);
    }
}
