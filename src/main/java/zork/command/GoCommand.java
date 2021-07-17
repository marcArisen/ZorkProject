package zork.command;

import zork.Colour;
import zork.Game;
import zork.NullLocation;
import zork.actors.Player;

import java.util.List;

public class GoCommand implements Command{

    public int identifyDirection(List<String> args){
        if (args.get(0).equalsIgnoreCase("up")){
            return 1;
        } else if (args.get(0).equalsIgnoreCase("down")){
            return 2;
        } else if (args.get(0).equalsIgnoreCase("left")){
            return 3;
        } else if (args.get(0).equalsIgnoreCase("right")){
            return 4;
        }
        return 0;
    }

    @Override
    public int numArgs() {
        return 1;
    }

    @Override
    public void execute(Game game, List<String> args) {
        Player player = game.getGamePlayer();
        int direction = identifyDirection(args);

        if (direction == 0){
            game.getOutput().println(Colour.RED + "that is not a direction");
        } else if (direction == 1){
            if (player.getLocation().getUp() != NullLocation.getInstance()) {
                player.move(player.getLocation().getUp());
                game.getOutput().println(Colour.YELLOW + "Player currently in " + player.getLocation().getNameOfLocation());
            } else {
                game.getOutput().println("you cannot go in that way!!");
            }
        } else if (direction == 2){
            if (player.getLocation().getDown() != NullLocation.getInstance()) {
                player.move(player.getLocation().getDown());
                game.getOutput().println(Colour.YELLOW +"Player currently in " + player.getLocation().getNameOfLocation());
            } else {
                game.getOutput().println("you cannot go in that way!!");
            }
        } else if (direction == 3){
            if (player.getLocation().getLeft() != NullLocation.getInstance()) {
                player.move(player.getLocation().getLeft());
                game.getOutput().println(Colour.YELLOW + "Player currently in " + player.getLocation().getNameOfLocation());
            } else {
                game.getOutput().println("you cannot go in that way!!");
            }
        } else if (direction == 4){
            if (player.getLocation().getRight() != NullLocation.getInstance()) {
                player.move(player.getLocation().getRight());
                game.getOutput().println(Colour.YELLOW + "Player currently in " + player.getLocation().getNameOfLocation());
            } else {
                game.getOutput().println("you cannot go in that way!!");
            }
        }

    }

    @Override
    public String getCommand() {
        return "go";
    }
}