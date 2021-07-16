package zork.command;

import zork.Game;

import java.util.List;

public class PlayCommand implements Command{


    @Override
    public int numArgs() {
        return 1;
    }

    @Override
    public void execute(Game game, List<String> args) {

    }

    @Override
    public String getCommand() {
        return "play";
    }
}