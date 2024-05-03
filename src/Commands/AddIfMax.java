package Commands;

import Manager.CollectionManager;
import Manager.CommandManager;
import Manager.Console;
import Manager.Inputs;
import Models.Movie;

import java.util.LinkedList;
import java.util.Scanner;

public class AddIfMax extends Command{

    CollectionManager collectionManager;
    public AddIfMax(Console console, CollectionManager collectionManager) {
        super(console, "add_if_max", "добавить новый элемент в коллекцию, если его значение превышает значение наибольшего элемента этой коллекции");
        this.collectionManager = collectionManager;
    }

    public void action() {
        Inputs inputs = new Inputs(console);
        Movie movie = inputs.movieInput();
        LinkedList<Movie> collection = collectionManager.getCollection();
        int n = collection.size()-1;
        if (movie.compareTo(collection.get(n)) > 0) {
            collectionManager.getCollection().add(movie);
        }
    }
    public void action(Scanner scanner) {
        Inputs inputs = new Inputs(console);
        Movie movie = inputs.movieScan(scanner);
        LinkedList<Movie> collection = collectionManager.getCollection();
        int n = collection.size()-1;
        if (movie.compareTo(collection.get(n)) > 0) {
            collectionManager.getCollection().add(movie);
        }
    }
}
