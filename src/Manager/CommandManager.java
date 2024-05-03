package Manager;

import Commands.*;
import Models.MovieGenre;


import java.io.IOException;

import java.util.Scanner;
/**
 * Класс CommandManager - обрабатывает команды
 */
public class CommandManager {
    Console console;
    CollectionManager collectionManager;
    private Scanner scanner = null;
    public CommandManager(Console console, CollectionManager collectionManager) {
        this.console = console;
        this.collectionManager = collectionManager;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public boolean commandManage(String s) throws IOException {
    String[] elements = s.split(" ", 0);
        if (elements.length>0) {
            if (elements[0].equals("add")) {
                Add add = new Add(console, collectionManager);
                if (scanner==null) {
                    add.action();
                } else {
                    add.action(scanner);
                }
            } else if (elements[0].equals("help")) {
                Help help = new Help(console);
                help.action();
            } else if (elements[0].equals("info")) {
                Info info = new Info(console, collectionManager);
                info.action();
            } else if (elements[0].equals("show")) {
                Show show = new Show(console, collectionManager);
                show.action();
            } else if (elements[0].equals("update")) {
                if (elements.length == 2) {
                    Update update = new Update(console, collectionManager);
                    if (scanner==null) {
                        update.action(Integer.parseInt(elements[1]));
                    } else {
                        update.action(Integer.parseInt(elements[1]), scanner);
                    }
                } else {
                    console.println("Вы забыли ввести id, пожалуйста, повторите ввод");
                }
            } else if (elements[0].equals("remove_by_id")) {
                if (elements.length == 2) {
                    RemoveById removeById = new RemoveById(console, collectionManager);
                    removeById.action(Integer.parseInt(elements[1]));
                } else {
                    console.println("Вы забыли ввести id, пожалуйста, повторите ввод");
                }
            } else if (elements[0].equals("clear")) {
                Clear clear = new Clear(console, collectionManager);
                clear.action();
            } else if (elements[0].equals("exit")) {
                Exit exit = new Exit(console);
                return exit.action();
            } else if (elements[0].equals("save")) {
                Save save = new Save(console, collectionManager);
                save.action();
            } else if (elements[0].equals("execute_script")) {
                ExecuteScript executeScript = new ExecuteScript(console, collectionManager);
                if (elements.length == 2) {
                    executeScript.action(elements[1]);
                } else {
                    console.println("Вы забыли ввести путь к файлу");
                }
            } else if (elements[0].equals("remove_first")) {
                RemoveFirst removeFirst = new RemoveFirst(console, collectionManager);
                removeFirst.action();
            } else if (elements[0].equals("head")) {
                Head head = new Head(console, collectionManager);
                head.action();
            } else if (elements[0].equals("add_if_max")) {
                AddIfMax addIfMax = new AddIfMax(console, collectionManager);
                if (scanner == null) {
                    addIfMax.action();
                } else {
                    addIfMax.action(scanner);
                }
            } else if (elements[0].equals("remove_all_by_genre")) {
                if (elements.length==2) {
                    RemoveAllByGenre removeAllByGenre = new RemoveAllByGenre(console, collectionManager);
                    try {
                        removeAllByGenre.action(MovieGenre.valueOf(elements[1]));
                    } catch (Exception ex) {
                        console.println("Такого жанра нет");
                    }

                } else {
                    console.println("Вы забыли указать жанр");
                }
            } else if (elements[0].equals("filter_greater_than_oscars_count")) {
                if (elements.length == 2) {
                    FilterGreaterThanOscarsCount filterGreaterThanOscarsCount = new FilterGreaterThanOscarsCount(console, collectionManager);
                    try {
                        filterGreaterThanOscarsCount.action(Integer.parseInt(elements[1]));
                    } catch (Exception ex) {
                        console.println("Количество оскаров - целочисленное число");
                    }

                } else {
                    console.println("Вы забыли ввести количество оскаров, пожалуйста, повторите ввод");
                }
            } else if (elements[0].equals("print_field_ascending_operator")) {
                PrintFieldAscendingOperator printFieldAscendingOperator = new PrintFieldAscendingOperator(console, collectionManager);
                printFieldAscendingOperator.action();
            } else {
                console.println("Такой команды нет, пожалуйста, повторите ввод");
                console.println(s);
            }
        } else {
            console.println("Такой команды нет, пожалуйста, повторите ввод");
            console.println(s);
        }
        return true;
    }
}
