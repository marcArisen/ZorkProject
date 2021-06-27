package zork.command;

import zork.Game;

import java.util.List;

public class InfoCommand implements Command{
    @Override
    public int numArgs() {
        return 0;
    }

    @Override
    public void execute(Game game, List<String> args) {
        game.getOutput().println("SHOWING CURRENT STATUS");
    }

    @Override
    public String getCommand() {
        return "info";
    }
}