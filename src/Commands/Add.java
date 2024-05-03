package Commands;

import Manager.CollectionManager;
import Manager.Console;
import Manager.Inputs;
import Models.Movie;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Add extends Command{
    CollectionManager collectionManager;
    public Add(Console console, CollectionManager collectionManager) {
        super(console, "add", "добавить новый элемент в коллекцию");
        this.collectionManager = collectionManager;
    }


    public void action() {
        Inputs inputs = new Inputs(console);
        Movie movie = inputs.movieInput();
        collectionManager.getCollection().add(movie);
        Collections.sort(collectionManager.getCollection());
    }
    public void action(Scanner scanner) {
        Inputs inputs = new Inputs(console);
        Movie movie = inputs.movieScan(scanner);
        collectionManager.getCollection().add(movie);
        Collections.sort(collectionManager.getCollection());
    }

}
