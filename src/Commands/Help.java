package Commands;

import Manager.CommandManager;
import Manager.Console;

public class Help extends Command{

    public Help(Console console) {
        super(console, "help", "вывести справку по доступным командам");
    }

    public void action() {
        console.println("help: вывести справку по доступным командам");
        console.println("info: вывести информацию о коллекции (тип, дата инициализации, количество элементов и т.д.");
        console.println("show: вывести все элементы коллекции");
        console.println("add: добавить новый элемент в коллекцию");
        console.println("update: обновить значение элемента коллекции, id которого равен заданному");
        console.println("remove_by_id: удалить элемент коллекции по его id");
        console.println("clear: очистить коллекцию");
        console.println("save: сохранить коллекцию в файл");
        console.println("execute_script: считать и исполнить скрипт из файла");
        console.println("exit: завершить программу (без сохранения в файл)");
        console.println("remove_first: удалить первый элемент из коллекции");
        console.println("head: вывести первый элемент коллекции");
        console.println("add_if_max: добавить новый элемент в коллекцию, если его значение превышает значение наибольшего элемента этой коллекции");
        console.println("remove_all_by_genre: удалить из коллекции все элементы, значение поля genre которых эквивалентно заданному");
        console.println("filter_greater_than_oscars_count: вывести элементы, значение поля oscarsCount больше заданных");
        console.println("print_field_ascending_operator: вывести значение поля operator всех элементов в порядке возрастания");
    }
}
