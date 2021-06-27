package zork;

import zork.actors.Player;
import zork.command.Command;

import java.util.List;
import java.util.Scanner;

public class Game {

    private boolean isStart = false;

    private GameOutput output = new GameOutput();

    private CommandParser commandParser = new CommandParser();

    private Player gamePlayer;

    private Location startingPoint;

    public void selectMap(){

        output.println("Welcome to Zork by Witchapat Issariyawat 6280872");
        output.println("There are 2 available maps in game right now");
        output.println("Enter 1 to play in __________");
        output.println("Enter 2 to play in __________");
    }

    public void setTheMap(){
        return;
    }

    public void setTheGame(){
        gamePlayer = new Player(200, 200, 1, startingPoint);

    }

    public void run(){
        selectMap(); // just print before game getting started
        while (true){
            Scanner in = new Scanner(System.in);
            String s = in.nextLine(); // this variable is where we take input in

            ////////////////////////This is just for setting the map and the game//////////////////////////////////////
            if (isStart != true){
             if ((s.compareTo("1") == 0) || (s.compareTo("2") == 0)){
                 //TODO : Set the map and set the game right here
                 isStart = true;
                 output.println("game start!!!!!");
                 continue;
             }else{
                 continue;
             }
            }
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////


            List<String> words = commandParser.parse(s);
            Command command = CommandFactory.get(words.get(0));
            if (command != null) {
                command.execute(this, words.subList(1, words.size()));
            }

        }
    }

    public GameOutput getOutput(){
        return output;
    }

    public void exit() {
        System.exit(0);
    }
}
