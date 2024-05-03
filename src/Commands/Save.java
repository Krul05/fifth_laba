package Commands;

import Manager.CollectionManager;

import Manager.Console;
import Models.Movie;



import java.beans.XMLEncoder;
import java.io.*;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Save extends Command {

    CollectionManager collectionManager;

    public Save(Console console, CollectionManager collectionManager) {
        super(console, "save", "сохранить коллекцию в файл");
        this.collectionManager = collectionManager;
    }


    public void action() throws FileNotFoundException {
        LinkedList<Movie> collection = collectionManager.getCollection();
        try (XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream("src/collection.xml")))) {
            encoder.writeObject(collection);
        } catch (Exception e) {
            e.printStackTrace();
        }
        console.println("Коллекция сохранена");

    }
}
