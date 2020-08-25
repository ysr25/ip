package main.java.duke;

import main.java.duke.command.ByeCommand;
import main.java.duke.command.Command;
import main.java.duke.command.DeadlineCommand;
import main.java.duke.command.DeleteCommand;
import main.java.duke.command.DoneCommand;
import main.java.duke.command.EventCommand;
import main.java.duke.command.FindCommand;
import main.java.duke.command.ListCommand;
import main.java.duke.command.ToDoCommand;

/**
 * Responsible for the parsing of the user's inputs.
 */
public class Parser {
    /**
     * Parses an input from the user.
     *
     * @param command the input to be parsed
     * @return a <code>Command</code> that can be executed
     * @throws DukeException if the given input is not supported by Duke
     */
    public static Command parse(String command) throws DukeException {
        String[] inputArray = command.split("\\s+");
        switch (inputArray[0]) {
        case "bye":
            return new ByeCommand();
        case "":
            return null;
        case "todo":
            return new ToDoCommand(command);
        case "deadline":
            return new DeadlineCommand(command);
        case "event":
            return new EventCommand(command);
        case "done":
            return new DoneCommand(inputArray);
        case "delete":
            return new DeleteCommand(inputArray);
        case "list":
            return new ListCommand(inputArray);
        case "find":
            return new FindCommand(command);
        default:
            throw new DukeException("I'm not sure what you're talking about.");
        }
    }
}
