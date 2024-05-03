package Manager;

import Commands.Command;

import java.util.HashMap;
import java.util.Map;

public class CommandMeneger {
    private Map<String, Command> commands = new HashMap<>();
    public Map<String, Command> getCommands() {
        return commands;
    }

}
