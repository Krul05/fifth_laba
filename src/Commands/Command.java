package Commands;

import Manager.Console;
/**
 * Базовый класс команд содержит поля <b>console</b>, <b>name</b>, <b>description</b>
 */
public abstract class Command {
    protected final Console console;
    private final String name;
    private final String description;
    /**
     * @param console - выводит в консоль
     * @param name - название команды
     * @param description - описание команды
     */
    protected Command(Console console, String name, String description) {
        this.console = console;
        this.name = name;
        this.description = description;
    }


    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
}
