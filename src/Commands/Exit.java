package Commands;

import Manager.CommandManager;
import Manager.Console;

public class Exit extends Command{

    public Exit(Console console) {
        super(console, "exit", "завершить программу (без сохранения в файл)");
    }


    public boolean action() {
        return false;
    }
}
