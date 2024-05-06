package Commands;

import Manager.CollectionManager;
import Manager.CommandManager;
import Manager.Console;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Clear extends Command{
    CollectionManager collectionManager;
    public Clear(Console console, CollectionManager collectionManager) {
        super(console, "clear", "очистить коллекцию");
        this.collectionManager = collectionManager;
    }


    public void action() throws FileNotFoundException {
        collectionManager.getCollection().clear();
        PrintWriter printWriter = new PrintWriter(collectionManager.getFile());
        printWriter.print("");
        printWriter.close();
    }
}
