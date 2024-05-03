package Commands;

import Manager.CollectionManager;
import Manager.CommandManager;
import Manager.Console;
import Models.Movie;
import Models.Person;

import java.util.Collections;
import java.util.LinkedList;

public class PrintFieldAscendingOperator extends Command{

    CollectionManager collectionManager;
    public PrintFieldAscendingOperator(Console console, CollectionManager collectionManager) {
        super(console, "print_field_ascending_operator", "вывести значение поля operator всех элементов в порядке возрастания");
        this.collectionManager = collectionManager;
    }


    public void action() {
        LinkedList<Movie> collection = collectionManager.getCollection();
        LinkedList<Person> operators = new LinkedList<Person>();
        for (int i = 0; i<collection.size(); i++) {
            if (collection.get(i).getOperator()!=null)
                operators.add(collection.get(i).getOperator());
        }
        Collections.sort(operators);
        for (int i = 0; i<operators.size(); i++) {
            console.println(operators.get(i).toString());
            console.println("");
        }
    }
}
