package Manager;

import Models.Movie;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.LinkedList;

public class XMLWorker {
    File file;
    public XMLWorker(File file) {
        this.file = file;
    }
    public LinkedList<Movie> read() {
        LinkedList<Movie> deserialized = new LinkedList<Movie>();

        try(FileInputStream fis = new FileInputStream(file);
            XMLDecoder decoder = new XMLDecoder(fis)) {
            final boolean[] e = {false};
            decoder.setExceptionListener(ex -> e[0] = true);
            deserialized = (LinkedList<Movie>) decoder.readObject();
            if(e[0]){
                System.out.print("Файл пуст");
                return new LinkedList<>();
            }
        } catch (Exception e) {
            System.out.println("Что-то пошло не так");
        }
        return deserialized;
    }
    public void write(LinkedList<Movie> collection) {
        if (file.canWrite()) {
            try (XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(file)))) {
                encoder.writeObject(collection);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("В файл нельзя ничего записать");
        }
    }
}
