package seedu.duke.command;

import seedu.duke.DukeException;
import seedu.duke.Storage;
import seedu.duke.TaskList;
import seedu.duke.Ui;

/**
 * Represents a command entered by the user for Duke to execute.
 */
public interface Command {
    /**
     * Executes the command.
     *
     * @param taskList a list of the user's tasks
     * @param ui       Deals with interactions with the user.
     * @param storage  Deals with the saving of the user's tasks.
     * @throws DukeException
     */
    void execute(TaskList taskList, Ui ui, Storage storage) throws DukeException;

    /**
     * Determines if this <code>Command</code> causes Duke to stop running.
     *
     * @return whether or not this command terminates the program
     */
    boolean isDone();
}