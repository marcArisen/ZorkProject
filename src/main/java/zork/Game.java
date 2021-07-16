package zork;

import zork.actors.Monster;
import zork.actors.Player;
import zork.command.Command;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {

    private boolean isStart = false;

    private GameOutput output = new GameOutput();

    private CommandParser commandParser = new CommandParser();

    private Player gamePlayer =  new Player(200, 5,null);

    private List<Location> Maps = new ArrayList<>();

    private List<Monster> Monsters = new ArrayList<>();

    public boolean isStart() {
        return isStart;
    }

    public void setStart(boolean start) {
        isStart = start;
    }

    public List<Location> getMaps(){
        return Maps;
    }

    public void addMonsters(Monster monster){
        Monsters.add(monster);
    }

    public Player getGamePlayer() {
        return gamePlayer;
    }

    public Location getWhereThePlayer() {
        return this.getGamePlayer().getLocation();
    }

    public boolean endGameCondition(){
        if (!gamePlayer.isAlive()){
            return true;
        }
        return false;
    }

    public void checkDeath(Game game){
        for (Monster monster : Monsters){
            if (monster.getCurrentHP() <= 0){
                monster.setAlive(false);
                game.getOutput().println(monster.getName() + " is dead");
                //eliminating the monster
                Monsters.remove(monster);
                monster.getLocation().removeMonster();
            }
        }

        if (gamePlayer.getCurrentHP() <= 0){
            getOutput().println("Player has died, GAME OVER");
            gamePlayer.setAlive(false);
            //isStart = false;
        }
    }

    public void selectMap(){

        output.println("Welcome to Zork by Witchapat Issariyawat 6280872");
        output.println("There are 2 available maps in game right now");
        output.println("Enter 1 to play in ADVENTURE IN THE CAVE");
        output.println("Enter 2 to play in __________");
    }

    public void setTheMap(Game game){
        //set up the map and monsters
    GamePopulator.setTheGameMap(game);
    }


    public void run(){
        selectMap(); // just print before game getting started
        while (){
            Scanner in = new Scanner(System.in);
            String s = in.nextLine(); // this variable is where we take input in

            ////////////////////////This is just for setting the map and the game//////////////////////////////////////
            if (isStart != true){
             if ((s.compareTo("1") == 0) || (s.compareTo("2") == 0)){
                 //TODO : Set the map and set the game right here
                 setTheMap(this);
                 gamePlayer.setLocation(Maps.get(0));
                 output.println("game start!!!!!");
                 isStart = true;
                 continue;
             }else{
                 output.println("Please select the Map");
             }
            }
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////


            List<String> words = commandParser.parse(s);
            Command command = CommandFactory.get(words.get(0));
            if (command != null) {
                command.execute(this, words.subList(1, words.size()));
                checkDeath(this);

            }

        }
    }


    /*public void run(){
        selectMap(); // just print before game getting started
        while (!endGameCondition() || !isStart){
            Scanner in = new Scanner(System.in);
            String s = in.nextLine(); // this variable is where we take input in

            ////////////////////////This is just for setting the map and the game//////////////////////////////////////
            if (isStart != true){
                if ((s.compareTo("1") == 0) || (s.compareTo("2") == 0)){

                    setTheMap(this);
                    gamePlayer.setLocation(Maps.get(0));
                    output.println("game start!!!!!");
                    isStart = true;
                    continue;
                }else{
                    output.println("Please select the Map");
                }
            }
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////


            List<String> words = commandParser.parse(s);
            Command command = CommandFactory.get(words.get(0));
            if (command != null) {
                command.execute(this, words.subList(1, words.size()));
                checkDeath(this);

            }

        }
    }*/

    public GameOutput getOutput(){
        return output;
    }

    public void exit() {
        System.exit(0);
    }
}
