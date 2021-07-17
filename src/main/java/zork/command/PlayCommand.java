package zork.command;

import zork.Colour;
import zork.Game;
import zork.actors.Player;

import java.util.List;

public class PlayCommand implements OutGameCommand{


    @Override
    public int numArgs() {
        return 1;
    }

    @Override
    public void execute(Game game, List<String> args) {
        game.setTheMap(game);
        game.setGamePlayer(new Player(200, 5,null));
        game.getGamePlayer().setLocation(game.getMaps().get(0));
        game.getOutput().println(Colour.GREEN + "game start!!!!!");
        game.setStart(true);
        game.getOutput().println(Colour.BLUE + "There is BOSS monster ruling your village !!!!");
        game.getOutput().println("You have to defeat the boss in order to secure your hometown");
        game.getOutput().println("But your power alone is not enough");
        game.getOutput().println("Hint : go to the legendary place to take the legendary sword");
    }

    @Override
    public String getCommand() {
        return "play";
    }
}