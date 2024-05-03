package Commands;

import Manager.CollectionManager;
import Manager.CommandManager;
import Manager.Console;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.util.Scanner;


public class ExecuteScript extends Command{
    CollectionManager collectionManager;
    public ExecuteScript(Console console, CollectionManager collectionManager) {
        super(console, "execute_script", "считать и исполнить скрипт из файла");
        this.collectionManager = collectionManager;
    }

    public void action(String file) throws IOException {
        try {
            FileReader fileReader = new FileReader(file);
            Scanner scan = new Scanner(fileReader);
            String command;
            while (scan.hasNextLine()) {
                command = scan.nextLine().trim();
                CommandManager commandManager = new CommandManager(console, collectionManager);
                commandManager.setScanner(scan);
                commandManager.commandManage(command);
            }
        } catch (FileNotFoundException exception) {
            console.println("Такого файла нет");
        }



    }
}
