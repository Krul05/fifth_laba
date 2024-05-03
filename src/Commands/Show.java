package Commands;

import Manager.CollectionManager;
import Manager.CommandManager;
import Manager.Console;

public class Show extends Command{

    CollectionManager collectionManager;
    public Show(Console console, CollectionManager collectionManager) {
        super(console, "show", "вывести все элементы коллекции");
        this.collectionManager = collectionManager;
    }


    public void action() {
        console.println(collectionManager.show());
    }
}
