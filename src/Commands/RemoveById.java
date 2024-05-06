package Commands;

import Manager.CollectionManager;
import Manager.CommandManager;
import Manager.Console;
import Models.Movie;

import java.util.LinkedList;

public class RemoveById extends Command{
    CollectionManager collectionManager;
    public RemoveById(Console console, CollectionManager collectionManager) {
        super(console, "remove_by_id", "удалить элемент коллекции по его id");
        this.collectionManager = collectionManager;
    }


    public void action(int id) {
        LinkedList<Movie> collection = collectionManager.getCollection();
        try {
            for (int i = 0; i < collection.size(); i++) {
                if (collection.get(i).getId() == id) {
                    collectionManager.getCollection().remove(i);
                }
            }
        } catch (Exception ex) {
            console.println("Такого id нет");
        }
    }
}
