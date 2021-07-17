package zork.command;

import zork.Colour;
import zork.Game;

import java.util.List;

public class QuitCommand implements Command{
    @Override
    public int numArgs() {
        return 0;
    }

    @Override
    public void execute(Game game, List<String> args) {
        game.getOutput().println(Colour.BLUE + "GO BACK TO THE MAIN MENU");
        game.setStart(false);
        game.backToMainMenu();
    }

    @Override
    public String getCommand() {
        return "quit";
    }
}
