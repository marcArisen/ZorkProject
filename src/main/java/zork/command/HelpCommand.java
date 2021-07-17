package zork.command;

import zork.Colour;
import zork.Game;

import java.util.List;

public class HelpCommand implements Command{
    @Override
    public int numArgs() {
        return 0;
    }

    @Override
    public void execute(Game game, List<String> args) {
        game.getOutput().println(Colour.YELLOW + "HELP MENU");
        game.getOutput().println("--info : print out information of the player");
        game.getOutput().println("--take : take the item that is on the floor");
        game.getOutput().println("--attack with {weapon} : attack the enemy on the map");
        game.getOutput().println("--drop {item} : drop that item in player's inventory");
        game.getOutput().println("--list item : list the item that are in the player's inventory");
        game.getOutput().println("--use {item} : use that item in the player's inventory");
        game.getOutput().println("--quit : end the current game");
        game.getOutput().println("--exit : exit the whole game");

    }

    @Override
    public String getCommand() {
        return "help";
    }
}
