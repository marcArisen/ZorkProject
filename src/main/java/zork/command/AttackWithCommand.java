package zork.command;

import zork.Colour;
import zork.Game;
import zork.actors.Player;
import zork.items.Item;
import zork.items.Weapon;

import java.util.List;

//Attack command is already complete
public class AttackWithCommand implements Command{
    @Override
    public int numArgs() {
        return 1;
    }

    @Override
    public void execute(Game game, List<String> args) {
        Player player = game.getGamePlayer();

        if (player.getLocation().getMonster() != null) {
            for (Item item : player.getInventory()) {
                if (item.getName().equalsIgnoreCase(args.get(0))) {
                    if (item instanceof Weapon) {
                        game.getOutput().println(Colour.YELLOW + "Player use " + item.getName() + " for attacking");
                        player.setWeapon((Weapon) item);
                        //player attacks first
                        int damage = player.attack(player.getLocation().getMonster());
                        game.getOutput().println(Colour.CYAN + player.getLocation().getMonster().getName() + " was dealt " + damage + " damage");
                        game.getOutput().println("current HP of monster is " + player.getLocation().getMonster().getCurrentHP());
                        //Monster attacks back
                        if (player.getLocation().getMonster().getCurrentHP() > 0) {
                            int damage2 = player.getLocation().getMonster().attack(player);
                            game.getOutput().println(Colour.PURPLE +"Monster attacks back to the player, dealt " + damage2 + " damage");
                            game.getOutput().println("Player HP is " + player.getCurrentHP());
                        }

                        return;
                    }
                }

            }
            game.getOutput().println(Colour.RED + "Invalid item");
        }else {
            game.getOutput().println(Colour.RED + "There is no monster here");
        }
    }

    @Override
    public String getCommand() {
        return "attack with";
    }
}
