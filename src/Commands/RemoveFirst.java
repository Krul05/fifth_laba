package Commands;

import Manager.CollectionManager;
import Manager.CommandManager;
import Manager.Console;

public class RemoveFirst extends Command {

    CollectionManager collectionManager;
    public RemoveFirst(Console console, CollectionManager collectionManager) {
        super(console, "remove_first", "удалить первый элемент из коллекции");
        this.collectionManager = collectionManager;
    }


    public void action() {
        try {
            collectionManager.getCollection().remove(0);
        } catch (Exception ex) {
            console.println("Коллекция пуста");
        }

    }
}
