import Manager.CollectionManager;
import Manager.Console;
import Manager.Inputs;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws  IOException {
        Console console = new Console();
        CollectionManager collectionManager = new CollectionManager();
        Inputs inputs = new Inputs(console);
        boolean flag = true;
        while (flag) {
            flag = inputs.commandInput(collectionManager);
        }
    }
}