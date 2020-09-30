package Commands;

import This.OrganizationData;

import java.util.HashMap;
import java.util.Map;

public class CommandExecutor {
    private static Map<String, Command> commandMap = new HashMap<>();

    private static Map<String, Command> getCommandMap() {
        return commandMap;
    }

    public static void addCommand(String name, Command command) {
        commandMap.put(name, command);
    }

    public static Map<Command, String> execute(String action) {
        Map<Command, String> map = new HashMap<>();
        String[] actionParts = action.split(" ");
        if (action.isEmpty()) {
            return null;
        }
        if (action.equals("exit")){
            System.exit(0);
        }
        if (actionParts.length == 1) {
            Command command = commandMap.get(actionParts[0]);
            if (command != null) {
                map.put(command, null);
                return map;
            } else {

                System.out.println("commands.Command doesn't exist.");
                return null;
            }
        } else if (actionParts.length == 2) {
            Command command = commandMap.get(actionParts[0]);
            String arg = actionParts[1];
            if (command != null) {
                map.put(command, arg);
                return map;
            } else {
                System.out.println("commandMap.Command doesn't exist.");
                return null;
            }
        } else {
            System.out.println("Wrong command input.");
            return null;
        }
    }

}
