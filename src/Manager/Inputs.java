package Manager;

import Models.*;

import java.io.*;
import java.util.Scanner;
/**
 * Класс Inputs - вводит данные
 */
public class Inputs {
    Console console;
    public Inputs(Console console) {
        this.console = console;
    }
    public String oscarsInput() {
        console.println("Пожалуйста, введите количество оскаров, которое получил фильм, если не хотите вводить нажмите 'Enter'");
        String s = input();
        return s;
    }
    public String movieNameInput() {
        console.println("Пожалуйста, введите название фильма");
        String name = input();
        return name;
    }
    public Movie movieInput() {
        Builders builders = new Builders(console, this);
        String movieName = builders.movieNameBuilder(movieNameInput());
        int oscars = builders.oscarsBuilder(oscarsInput());
        Coordinates coordinates = builders.coordinatesBuilder(xInput(), yInput());
        String isOperator = builders.isOperatorBuilder(isOperatorInput());
        Person person = null;
        if (isOperator.equals("yes")) {
            String personName = builders.personNameBuilder(personNameInput());
            String passportID = builders.passportIDBuilder(passportIDInput());
            Country nationality = builders.nationalityBuilder(nationalityInput());
            person = new Person(personName, passportID, nationality);
        }
        MovieGenre genre = builders.genreBuilder(genreInput());
        MpaaRating rating = builders.ratingBuilder(ratingInput());
        Movie movie = new Movie(movieName, coordinates, oscars, genre, rating, person);
        return movie;
    }
    public Movie movieScan(Scanner scanner) {
        try {
            Builders builders = new Builders(console, this);
            String movieName = builders.movieNameBuilder(scanner.nextLine());
            int oscars = builders.oscarsBuilder(scanner.nextLine());
            Coordinates coordinates = builders.coordinatesBuilder(scanner.nextLine(), scanner.nextLine());
            String isOperator = builders.isOperatorBuilder(scanner.nextLine());
            Person person = null;
            if (isOperator.equals("yes")) {
                String personName = builders.personNameBuilder(scanner.nextLine());
                String passportID = builders.passportIDBuilder(scanner.nextLine());
                Country nationality = builders.nationalityBuilder(scanner.nextLine());
                person = new Person(personName, passportID, nationality);
            }
            MovieGenre genre = builders.genreBuilder(genreInput());
            MpaaRating rating = builders.ratingBuilder(ratingInput());
            Movie movie = new Movie(movieName, coordinates, oscars, genre, rating, person);
            return movie;
        } catch (Exception ex) {
            console.println("Значений в файле мало");
            return movieInput();
        }
    }
    public String isOperatorInput() {
        console.println("Хотите ли вы ввести оператора? Введите 'yes', если хотите, и 'no', если не хотите \n");
        String s = input();
        return s;
    }
    public String genreInput() {
        console.println("Пожалуйста выберите жанр фильма из предложенных вариантов (введите сам вариант):\n" +
                "1. MUSICAL\n" +
                "2. ADVENTURE\n" +
                "3. HORROR\n" +
                "4. SCIENCE_FICTION\n");
        String s = input();
        return s;
    }
    public String ratingInput() {
        console.println("Пожалуйста выберите рейтинг фильма из предложенных вариантов (введите сам вариант):\n" +
                "1. G\n" +
                "2. PG\n" +
                "3. PG_13\n" +
                "4. R\n" +
                "5. NC_17\n");
        String s = input();
        return s;
    }
    public String xInput() {
        console.println("Пожалуйста введите координату x (x - вещественное число (знак разделения '.'))");
        String s = input();
        return s;
    }
    public String yInput() {
        console.println("Пожалуйста введите координату y (y - целое число до 662)");
        String s = input();
        return s;
    }

    public String personNameInput() {
        console.println("Пожалуйста введите имя человека");
        String name = input();
        return name;
    }
    public String passportIDInput() {
        console.println("Пожалуйста введите паспортID (9-40 символов) человека, если не хотите вводить нажмите 'Enter'");
        String passportID = input();
        return passportID;
    }

    public String nationalityInput() {
        console.println("Пожалуйста выберите национальность человека из предложенных вариантов (введите сам вариант):\n" +
                "1. UNITED_KINGDOM\n" +
                "2. GERMANY\n" +
                "3. CHINA\n" +
                "4. SOUTH_KOREA");
        String s = input();
        return s;
    }

    private String input() {
        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader reader = new BufferedReader(inputStreamReader);
        String s = null;
        try {
            s = reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return s;
    }
    public boolean commandInput(CollectionManager collectionManager) throws IOException {
        console.println("Пожалуйста введите название команды");
        String s = input();
        CommandManager commandManager = new CommandManager(console, collectionManager);
        return commandManager.commandManage(s);
    }
}
