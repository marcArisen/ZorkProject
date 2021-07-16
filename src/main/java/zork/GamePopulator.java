package zork;

import zork.actors.Boss;
import zork.actors.Monster;
import zork.actors.Slime;
import zork.items.SteelSword;

public class GamePopulator {

    public static void setTheGameMap(Game game){
        Location room1 = new Location("Village");
        Location room2 = new Location("The Forrest");
        Location room3 = new Location("The ฺCave level 1");
        Location room4 = new Location("The Cave level 2");
        Location room5 = new Location("BOSS ROOM");
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
        Monster bigboss = new Boss(game,game.getMaps().get(3));

        room2.setItem(new SteelSword());
    }

}
