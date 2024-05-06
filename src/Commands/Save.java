package Commands;

import Manager.CollectionManager;

import Manager.Console;
import Manager.XMLWorker;
import Models.Movie;



import java.beans.XMLEncoder;
import java.io.*;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class Save extends Command {

    CollectionManager collectionManager;

    public Save(Console console, CollectionManager collectionManager) {
        super(console, "save", "сохранить коллекцию в файл");
        this.collectionManager = collectionManager;
    }


    public void action(File file) throws IOException {
        LinkedList<Movie> collection = collectionManager.getCollection();
        XMLWorker xmlWorker = new XMLWorker(file);
        xmlWorker.write(collection);
        console.println("Коллекция сохранена");
    }
}
