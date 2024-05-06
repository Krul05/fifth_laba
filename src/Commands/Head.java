package Commands;

import Manager.CollectionManager;
import Manager.CommandManager;
import Manager.Console;
import Models.Movie;

import java.util.LinkedList;

public class Head extends Command{

    CollectionManager collectionManager;
    public Head(Console console, CollectionManager collectionManager) {
        super(console, "head", "вывести первый элемент коллекции");
        this.collectionManager = collectionManager;
    }


    public void action() {
        LinkedList<Movie> collection = collectionManager.getCollection();
        try {
            console.println(collection.get(0).getMovie());
        } catch (Exception ex) {
            console.println("Коллекция пуста");
        }

    }
}
