package zork.command;

import zork.Colour;
import zork.Game;
import zork.Location;
import zork.actors.Player;

import java.util.List;

public class TakeCommand implements Command{
    @Override
    public int numArgs() {
        return 0;
    }

    @Override
    public void execute(Game game, List<String> args) {
        Player player = game.getGamePlayer();
        Location currentLocation = game.getWhereThePlayer();

        if (currentLocation.getItem() != null){
            player.take(currentLocation.getItem());
            game.getOutput().println(Colour.PURPLE + "Player acquired " + currentLocation.getItem().getName());
            currentLocation.setItem(null);
        } else {
            game.getOutput().println("There is no item in this location");
        }


    }

    @Override
    public String getCommand() {
        return "take";
    }
}
