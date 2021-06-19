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
        String cleannedInput = stringInput.trim();
        String cmd = matchInputToCommand(cleannedInput);
        Command command = CommandFactory.get(cmd);
        if (command.numArgs() > 0){
            //TODO : do some checking for sapce later
            //TODO : handle valid args
            String argString = cleannedInput.substring(cmd.length()+1);
            System.out.println(argString);
            return Arrays.asList(cmd, argString);
        }else{
            return Arrays.asList(cmd);
        }
    }
}
