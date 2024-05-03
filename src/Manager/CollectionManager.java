package Manager;

import Models.Movie;

import java.util.LinkedList;
/**
 * Класс CollectionManager - управляет коллекцией
 */
public class CollectionManager {
    public CollectionManager() {
        creationDate = java.time.ZonedDateTime.now();
    }
    LinkedList<Movie> collection = new LinkedList<>();
    private java.time.ZonedDateTime creationDate;
    public LinkedList getCollection() {
        return collection;
    }

    public String show() {
        int size = collection.size();
        if (size==0) {
            return "Коллекция пуста!";
        } else {
            String s = "";
            for (int i = 0; i<size; i++) {
                s += collection.get(i).getMovie();
                s += "\n";
            }
            return s;
        }
    }
    public String getDiscription() {
        String type = "java.util.LinkedList";
        String date = creationDate.getDayOfMonth() + " " + creationDate.getMonth() + " " + creationDate.getYear() + " " + creationDate.getHour() +":" + creationDate.getMinute() + ":" + creationDate.getSecond();
        String size = String.valueOf(collection.size());
        return "тип - " + type + " \n" + "время инициализации - " + date + "\n" + "количество элементов в коллекции - " + size;
    }
}
