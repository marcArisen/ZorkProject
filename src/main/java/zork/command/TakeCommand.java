package zork.command;

import zork.Game;

import java.util.List;

public class TakeCommand implements Command{
    @Override
    public int numArgs() {
        return 0;
    }

    @Override
    public void execute(Game game, List<String> args) {

    }

    @Override
    public String getCommand() {
        return null;
    }
}
