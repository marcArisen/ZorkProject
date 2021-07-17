package zork.command;

import zork.Colour;
import zork.Game;
import zork.actors.Player;
import zork.items.Item;

import java.util.List;

public class DropCommand implements Command{
    @Override
    public int numArgs() {
        return 1;
    }

    @Override
    public void execute(Game game, List<String> args) {
        Player player = game.getGamePlayer();
        List<Item> playerInventory = player.getInventory();

        for (int i = 0; i < playerInventory.size(); i++ ){
            if (playerInventory.get(i).getName().equalsIgnoreCase(args.get(0))){
                playerInventory.remove(i);
                game.getOutput().println(Colour.YELLOW + "Already drop that item");
            }

        }

    }

    @Override
    public String getCommand() {
        return "drop";
    }
}
