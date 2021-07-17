package zork;

import zork.actors.*;
import zork.items.LegendarySword;
import zork.items.Potion;
import zork.items.SteelSword;

public class GamePopulator {

    public static void setTheGameMap(Game game){
        Location room1 = new Location("Village");
        Location room2 = new Location("The Forrest");
        Location room3 = new Location("The ฺCave level 1");
        Location room4 = new Location("The Cave level 2");
        Location room5 = new Location("LEGENDARY ROOOM");
        Location room6 = new Location("Plain Field");
        Location room7 = new Location("ROOM");

        game.getMaps().add(room1);
        game.getMaps().add(room2);
        game.getMaps().add(room3);
        game.getMaps().add(room4);
        game.getMaps().add(room5);
        game.getMaps().add(room6);
        game.getMaps().add(room7);

        room1.setDown(room2);
        room2.setUp(room1);

        room2.setLeft(room6);
        room6.setRight(room2);

        room2.setRight(room3);
        room3.setLeft(room2);

        room3.setDown(room4);
        room4.setUp(room3);

        room4.setRight(room5);
        room5.setLeft(room4);


        Monster monster1 = new Slime(game,game.getMaps().get(1));
        Monster monster2 = new Slime(game,game.getMaps().get(2));
        Monster monster3 = new Golem(game,game.getMaps().get(3));
        Monster monster4 = new Ghost(game,game.getMaps().get(4));

        Monster bigboss = new Boss(game,game.getMaps().get(0));

        game.setBoss(bigboss);

        room2.setItem(new Potion());
        room4.setItem(new Potion());
        room6.setItem(new SteelSword());
        room5.setItem(new LegendarySword());
    }

}
