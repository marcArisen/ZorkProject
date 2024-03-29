package zork.command;

import zork.Colour;
import zork.Game;

import java.util.List;

public class InvalidCommand implements Command{
    @Override
    public int numArgs() {
        return 0;
    }


    @Override
    public void execute(Game game, List<String> args) {
        game.getOutput().println(Colour.RED + "THIS IS NOT VALID COMMAND, TRY AGAIN");
    }

    @Override
    public String getCommand() {
        return "invalid";
    }
}
