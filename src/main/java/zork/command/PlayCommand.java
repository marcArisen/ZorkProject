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

    }

    @Override
    public String getCommand() {
        return "play";
    }
}