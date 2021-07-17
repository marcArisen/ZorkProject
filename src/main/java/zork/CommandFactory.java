package zork;

import zork.command.*;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CommandFactory {

    private static final List<Class<? extends Command>> REGISTERED_COMMANDS = Arrays.asList(
            ExitCommand.class,
            InfoCommand.class,
            InvalidCommand.class,
            AttackWithCommand.class,
            ListItemCommand.class,
            GoCommand.class,
            TakeCommand.class,
            PlayCommand.class,
            QuitCommand.class,
            DropCommand.class,
            HelpCommand.class
    );

    private static final Map<String,Command> COMMAND_MAPS = new HashMap<>();

    static {{
        for (Class<? extends Command>  commandClass : REGISTERED_COMMANDS){
            try {
                Command command = commandClass.getDeclaredConstructor().newInstance();
                COMMAND_MAPS.put(command.getCommand(),command);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }

    }}

    public static Command get(String command){
        return COMMAND_MAPS.get(command);
    }

    public static List<String> getAllCommands(){
        return COMMAND_MAPS.keySet().stream().collect(Collectors.toList());
    }



}
