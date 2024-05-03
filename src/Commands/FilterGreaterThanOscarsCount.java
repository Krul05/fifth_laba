package Commands;

import Manager.CollectionManager;
import Manager.CommandManager;
import Manager.Console;
import Models.Movie;

import java.util.LinkedList;

public class FilterGreaterThanOscarsCount extends Command{

    CollectionManager collectionManager;
    public FilterGreaterThanOscarsCount(Console console, CollectionManager collectionManager) {
        super(console, "filter_greater_than_oscars_count", "вывести элементы, значение поля oscarsCount больше заданных");
        this.collectionManager = collectionManager;
    }


    public void action(int oscarsCount) {
        LinkedList<Movie> collection = collectionManager.getCollection();
        for (int i = 0; i<collection.size(); i++) {
            if (collection.get(i).getOscarsCount()>oscarsCount) {
                console.println(collection.get(i).getMovie());
            }
        }
    }
}
