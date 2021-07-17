package zork.command;

import zork.Colour;
import zork.Game;

import java.util.List;

public class InfoCommand implements Command{
    @Override
    public int numArgs() {
        return 0;
    }

    @Override
    public void execute(Game game, List<String> args) {

        game.getOutput().println(Colour.PURPLE + "SHOWING CURRENT STATUS");
        game.getOutput().println(Colour.YELLOW + "Player HP :" + game.getGamePlayer().getCurrentHP() + "/" + game.getGamePlayer().getMaxHP());
        game.getOutput().println("runnining on the map '" + game.getWhereThePlayer().getNameOfLocation() + "'");

        game.getOutput().println(String.format(Colour.GREEN + " UP: %s,\n DOWN: %s,\n LEFT: %s,\n RIGHT: %s"
                ,game.getWhereThePlayer().getUp().getNameOfLocation()
                ,game.getWhereThePlayer().getDown().getNameOfLocation()
                ,game.getWhereThePlayer().getLeft().getNameOfLocation()
                ,game.getWhereThePlayer().getRight().getNameOfLocation()
        ));


        if (game.getWhereThePlayer().getMonster() != null) {
            game.getOutput().println(Colour.RED + "There is " + game.getWhereThePlayer().getMonster().getName());
        } else{
            game.getOutput().println(Colour.RED + "There is no monster here");
        }

        if (game.getWhereThePlayer().getItem() != null) {
            game.getOutput().println(Colour.BLUE + "There is " + game.getWhereThePlayer().getItem().getName() + " on the floor");
        }

    }

    @Override
    public String getCommand() {
        return "info";
    }
}
