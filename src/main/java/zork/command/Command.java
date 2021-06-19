package zork.command;

import zork.Game;

import java.util.List;

public interface Command {

    int numArgs(); //return num of args


    void execute(Game game, List<String> args); //lets commands do the works

    String getCommand();



}
