package Commands;

import Manager.CollectionManager;
import Manager.CommandManager;
import Manager.Console;
import Manager.Inputs;
import Models.Movie;

import java.util.LinkedList;
import java.util.Scanner;

public class Update extends Command{
    CollectionManager collectionManager;
    public Update(Console console, CollectionManager collectionManager) {
        super(console, "update", "обновить значение элемента коллекции, id которого равен заданному");
        this.collectionManager = collectionManager;

    }


    public void action(int id) {
        LinkedList<Movie> collection = collectionManager.getCollection();
        Inputs inputs = new Inputs(console);
        for(int i = 0; i<=collection.size(); i++) {
            if (collection.get(i).getId()==id) {
                collectionManager.getCollection().set(i, inputs.movieInput());
            }
        }
    }
    public void action(int id, Scanner scanner) {
        LinkedList<Movie> collection = collectionManager.getCollection();
        Inputs inputs = new Inputs(console);
        for(int i = 0; i<=collection.size(); i++) {
            if (collection.get(i).getId()==id) {
                collectionManager.getCollection().set(i, inputs.movieScan(scanner));
            }
        }
    }
}
