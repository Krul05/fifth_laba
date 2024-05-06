import Manager.*;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws  IOException {
        Console console = new Console();
        Inputs inputs = new Inputs(console);
        String s;
        if (args.length!=0) {
            s = args[0];
        } else {
            console.println("Введите название файла");
            try {
                s = inputs.input().trim();
            } catch (Exception ex) {
                console.println("Программа завершена");
                return;
            }

        }
        File file = new File(s);
        while (!file.isFile()) {
            console.println("Такого файла нет");
            console.println("Введите название файла");
            s = inputs.input().trim();
            file = new File(s);
        }
        if (file.canRead()) {
            XMLWorker xmlWorker = new XMLWorker(file);
            CollectionManager collectionManager = new CollectionManager(file, xmlWorker.read());
            boolean flag = true;
            while (flag) {
                try {
                    flag = inputs.commandInput(collectionManager);
                } catch (Exception ex) {
                    console.println("Программа завершена");
                    return;
                }

            }
        } else {
            console.println("Файл нельзя прочитать");
        }
    }
}