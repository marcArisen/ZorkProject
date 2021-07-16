package zork;

import zork.command.Command;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommandParser {

    private List<String> AllCommandsSortedByLength = new ArrayList<>();
    {
        AllCommandsSortedByLength.addAll(CommandFactory.getAllCommands());
        AllCommandsSortedByLength.sort(((o1, o2) -> o2.length() - o1.length()));
    }

    private String matchInputToCommand(String input){
        for (String command : AllCommandsSortedByLength) {
            if (input.startsWith(command)){
                return command;
            }
        }
        return null;
    }

    // "attack with a valid weapon"
    public List<String> parse(String stringInput){
        String cleanedInput = stringInput.trim(); //eliminating spaces in front and end
        String cmd = matchInputToCommand(cleanedInput);
        Command command = CommandFactory.get(cmd);
        if (command == null){
            //handle invalid command
            cmd = matchInputToCommand("invalid");
            command = CommandFactory.get(cmd);
        }

        if (command.numArgs() > 0){
            String argString = cleanedInput.substring(cmd.length()+1);
           // System.out.println(argString);
            return Arrays.asList(cmd, argString);
        }else{
            //System.out.println("checking "+ cmd ); // TODO : GET IT OUT
            return Arrays.asList(cmd);
        }
    }
}
