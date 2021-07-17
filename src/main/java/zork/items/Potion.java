package zork.items;

import zork.actors.Player;

public class Potion extends Item{

    public Potion() {
        super("potion", "use for restoring 100 HP.");
    }

    public void use(Player player){
        player.healHp(100);
    }
}
