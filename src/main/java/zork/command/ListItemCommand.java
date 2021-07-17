package zork.command;

import zork.Colour;
import zork.Game;
import zork.items.Item;

import java.util.List;

public class ListItemCommand implements Command{
    @Override
    public int numArgs() {
        return 0;
    }

    @Override
    public void execute(Game game, List<String> args) {
        for (Item item : game.getGamePlayer().getInventory()){
            game.getOutput().println(Colour.BLUE + item.getName() + " : " + item.getDescription());
        }
    }

    @Override
    public String getCommand() {
        return "list item";
    }
}
