package Commands;

import Manager.CollectionManager;
import Manager.CommandManager;
import Manager.Console;

public class Info extends Command{

    CollectionManager collectionManager;
    public Info(Console console, CollectionManager collectionManager) {
        super(console, "info", "вывести информацию о коллекции (тип, дата инициализации, количество элементов и т.д.");
        this.collectionManager = collectionManager;
    }


    public void action() {
        console.println(collectionManager.getDiscription());
    }
}
