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
        game.getOutput().println("Player HP :" + game.getGamePlayer().getCurrentHP() + "/" + game.getGamePlayer().getMaxHP());
        game.getOutput().println("runnining on the map '" + game.getWhereThePlayer().getNameOfLocation() + "'");

        game.getOutput().println(String.format(" UP: %s, DOWN: %s, LEFT: %s, RIGHT: %s"
                ,game.getWhereThePlayer().getUp().getNameOfLocation()
                ,game.getWhereThePlayer().getDown().getNameOfLocation()
                ,game.getWhereThePlayer().getLeft().getNameOfLocation()
                ,game.getWhereThePlayer().getRight().getNameOfLocation()
        ));


        if (game.getWhereThePlayer().getMonster() != null) {
            game.getOutput().println("There is " + game.getWhereThePlayer().getMonster().getName());
        } else{
            game.getOutput().println("There is no monster here");
        }

        if (game.getWhereThePlayer().getItem() != null) {
            game.getOutput().println("There is " + game.getWhereThePlayer().getItem().getName() + " on the floor");
        }

    }

    @Override
    public String getCommand() {
        return "info";
    }
}
