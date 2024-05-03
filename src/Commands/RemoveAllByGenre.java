package Commands;

import Manager.CollectionManager;
import Manager.CommandManager;
import Manager.Console;
import Models.Movie;
import Models.MovieGenre;

import java.util.Iterator;
import java.util.LinkedList;

public class RemoveAllByGenre extends Command{

    CollectionManager collectionManager;
    public RemoveAllByGenre(Console console, CollectionManager collectionManager) {
        super(console, "remove_all_by_genre", "удалить из коллекции все элементы, значение поля genre которых эквивалентно заданному");
        this.collectionManager = collectionManager;
    }


    public void action(MovieGenre genre) {
        LinkedList<Movie> collection = collectionManager.getCollection();
        Iterator<Movie> iterator = collection.iterator();
        while (iterator.hasNext()) {
            Movie movie = iterator.next();
            if (movie.getGenre().equals(genre)) {
                iterator.remove();
            }
        }
    }
}
