package zork;

import zork.actors.Monster;
import zork.actors.Player;
import zork.command.Command;
import zork.command.OutGameCommand;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {

    private boolean isStart = false;

    private GameOutput output = new GameOutput();

    private CommandParser commandParser = new CommandParser();

    private Player gamePlayer;

    private List<Location> Maps = new ArrayList<>();

    private List<Monster> Monsters = new ArrayList<>();

    private Monster boss;

    public Monster getBoss() {
        return boss;
    }

    public void setBoss(Monster boss) {
        this.boss = boss;
    }

    public void setGamePlayer(Player gamePlayer) {
        this.gamePlayer = gamePlayer;
    }

    public void setMaps(List<Location> maps) {
        Maps = maps;
    }

    public List<Monster> getMonsters() {
        return Monsters;
    }

    public void setMonsters(List<Monster> monsters) {
        Monsters = monsters;
    }

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

    public void endGameCondition(){
        if (!boss.isAlive()){
            getOutput().println(Colour.BLUE + "YOU HAVE DEFEATED THE BOSS !!!!!!");
            getOutput().println("YOUR VILLAGE HAVE BEEN SAVED BY YOU");
            gamePlayer.setAlive(false);
            isStart = false;
            backToMainMenu();
        }

    }

    public void checkDeath(Game game){
        for (int i = 0; i < getMonsters().size(); i++ ){
            Monster monster = getMonsters().get(i);
            if (monster.getCurrentHP() <= 0){
                monster.getLocation().removeMonster();
                monster.setAlive(false);
                game.getOutput().println(Colour.YELLOW + monster.getName() + " is dead");
                gamePlayer.eliminatedMonster();
                game.getOutput().println("Now, attacking power of Player is " + gamePlayer.getAttackDamage() + "!!!!");
                //eliminating the monster
                Monsters.remove(monster);
            }
        }

        if (gamePlayer.getCurrentHP() <= 0){
            getOutput().println(Colour.RED + "Player has died, GAME OVER");
            gamePlayer.setAlive(false);
            isStart = false;
            backToMainMenu();

        }
    }

    public void backToMainMenu(){

        output.println(Colour.YELLOW + "Zork by Witchapat Issariyawat 6280872");
        output.println("There are 2 available maps in game right now");
        output.println(Colour.CYAN + "Enter 'play 1' to play in ADVENTURE IN THE CAVE");
        output.println("Enter 'play 2' to play in [NOT IMPLEMENTED YET]");
    }

    public void setTheMap(Game game){
        //set up the map and monsters
    GamePopulator.setTheGameMap(game);
    }


    public void run(){
        backToMainMenu(); // just print before game getting started
        while (true){
            Scanner in = new Scanner(System.in);
            String s = in.nextLine(); // this variable is where we take input in



            List<String> words = commandParser.parse(s);
            Command command = CommandFactory.get(words.get(0));

            if (command != null) {

                if (isStart == true) {
                    command.execute(this, words.subList(1, words.size()));
                    checkDeath(this);
                    endGameCondition();
                } else{

                    if (command instanceof OutGameCommand){
                        command.execute(this, words.subList(1, words.size()));
                    }
                }

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
