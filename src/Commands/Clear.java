package Commands;

import Manager.CollectionManager;
import Manager.CommandManager;
import Manager.Console;

public class Clear extends Command{
    CollectionManager collectionManager;
    public Clear(Console console, CollectionManager collectionManager) {
        super(console, "clear", "очистить коллекцию");
        this.collectionManager = collectionManager;
    }


    public void action() {
        collectionManager.getCollection().clear();
    }
}
